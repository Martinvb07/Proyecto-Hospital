package Controlador;

import Modelo.HistoriaClinicaDetalle;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class HistoriaClinicaDAO {

    public static DefaultTableModel obtenerHistoriasClinicas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Fecha");
        modelo.addColumn("Paciente");

         String sql = "SELECT hc.id, hc.fecha, CONCAT(p.nombres, ' ', p.apellidos) AS paciente "
               + "FROM historiaclinica hc "
               + "JOIN pacientes p ON hc.id_paciente = p.id";

        try (Connection con = new ConexionBD().conexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id"),
                    rs.getDate("fecha"),
                    rs.getString("paciente")
                };
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
        }
        return modelo;
    }
        


    public boolean insertarHistoriaClinica(int idPaciente, Date fecha, String motivo, String antecedentes, String especialidad,
                                           String diagnostico, String medicamentos, String dosis, Date desde, Date hasta) {
        String sql = "INSERT INTO historiaclinica (id_paciente, fecha, motivo_consulta, antecedentes, especialidad, diagnostico, medicamentos, dosis, desde, hasta) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = new ConexionBD().conexion();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql)) {  // Ahora se usa la clase correcta
            ps.setInt(1, idPaciente);
            ps.setDate(2, new java.sql.Date(fecha.getTime()));  // Convertir Date a java.sql.Date
            ps.setString(3, motivo);
            ps.setString(4, antecedentes);
            ps.setString(5, especialidad);
            ps.setString(6, diagnostico);
            ps.setString(7, medicamentos);
            ps.setString(8, dosis);
            ps.setDate(9, new java.sql.Date(desde.getTime()));  // Convertir Date a java.sql.Date
            ps.setDate(10, new java.sql.Date(hasta.getTime()));  // Convertir Date a java.sql.Date

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public HistoriaClinicaDetalle obtenerDetalleHistoria(int idHistoria) {
    HistoriaClinicaDetalle detalle = null;

    String sql = "SELECT hc.fecha, hc.motivo_consulta, hc.antecedentes, hc.diagnostico, " +
                 "hc.medicamentos, hc.dosis, hc.desde, hc.hasta, " +
                 "CONCAT(p.nombres, ' ', p.apellidos) AS nombrePaciente, " +
                 "p.numero_documento AS documentoPaciente, hc.especialidad " +  // Corrección aquí
                 "FROM historiaclinica hc " +
                 "JOIN pacientes p ON hc.id_paciente = p.id " +
                 "WHERE hc.id = ?";

    try (Connection con = new ConexionBD().conexion();
         PreparedStatement stmt = con.prepareStatement(sql)) {

        stmt.setInt(1, idHistoria);  // Establecer el ID de la historia clínica
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                detalle = new HistoriaClinicaDetalle();
                detalle.setFecha(rs.getString("fecha"));
                detalle.setMotivoConsulta(rs.getString("motivo_consulta"));
                detalle.setAntecedentes(rs.getString("antecedentes"));
                detalle.setDiagnostico(rs.getString("diagnostico"));
                detalle.setMedicamentos(rs.getString("medicamentos"));
                detalle.setDosis(rs.getString("dosis"));
                detalle.setDesde(rs.getString("desde"));
                detalle.setHasta(rs.getString("hasta"));
                detalle.setNombrePaciente(rs.getString("nombrePaciente"));
                detalle.setDocumentoPaciente(rs.getString("documentoPaciente"));
                detalle.setEspecialidad(rs.getString("especialidad"));  // Ahora 'especialidad' es de historiaclinica
            }
        }

    } catch (SQLException e) {
        System.err.println("Error al obtener los detalles de la historia clínica: " + e.getMessage());
    }

    return detalle;
}
 public static DefaultTableModel obtenerHistoriasClinicasConDiagnostico() {
    DefaultTableModel modelo = new DefaultTableModel(
        new Object[]{"Id Paciente", "Descripción Diagnóstico", "Fecha Registro"}, 0
    );

    // Consulta para obtener las historias clínicas de todos los pacientes
    String sql = "SELECT hc.id_paciente, hc.diagnostico, hc.fecha " +
                 "FROM historiaclinica hc";

    try (Connection con = new ConexionBD().conexion();
         PreparedStatement stmt = con.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        
        // Recorrer el resultado y agregar cada fila a la tabla
        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getInt("id_paciente"),
                rs.getString("diagnostico"),
                rs.getString("fecha")
            });
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener las historias clínicas: " + e.getMessage());
    }

    return modelo;
}

 public static int contarDiagnosticos() {
    int total = 0;
    String sql = "SELECT COUNT(*) AS total FROM historiaclinica WHERE diagnostico IS NOT NULL";

    try (Connection con = new ConexionBD().conexion();
         PreparedStatement stmt = con.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        if (rs.next()) {
            total = rs.getInt("total");
        }

    } catch (SQLException e) {
        System.err.println("Error al contar los diagnósticos: " + e.getMessage());
    }

    return total;
}
 
 public static int contarHistorias() {
    int total = 0;
    String sql = "SELECT COUNT(*) AS total FROM historiaclinica";

    try (Connection con = new ConexionBD().conexion();
         PreparedStatement stmt = con.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        if (rs.next()) {
            total = rs.getInt("total");  // Usa el alias 'total'
        }

    } catch (SQLException e) {
        System.err.println("Error al contar las historias: " + e.getMessage());
    }

    return total;
}

}
