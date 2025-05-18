/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.ConexionBD;
import Modelo.CitaMedica;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marti
 */
public class CitaDAO {

    public static boolean guardarCita(CitaMedica cita) {
        String sql = "INSERT INTO citas (especialidad, medico, documento_paciente) VALUES (?, ?, ? )";

        try (java.sql.Connection con = ConexionBD.getInstancia().getConexion();
            java.sql.PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cita.getEspecialidad());
            ps.setString(2, cita.getMedico());
            ps.setString(3, cita.getDocumentoPaciente());
            

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static List<CitaMedica> obtenerCitasPorPaciente(String documentoPaciente) {
    List<CitaMedica> citas = new ArrayList<>();
    String sql = "SELECT c.id, c.fecha, c.hora, c.especialidad, c.medico, h.diagnostico " +
                 "FROM citas c " +
                 "LEFT JOIN historiaclinica h ON c.documento_paciente = h.id_paciente " +  
                 "WHERE c.documento_paciente = ?";

    try (Connection con = ConexionBD.getInstancia().getConexion();
         java.sql.PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, documentoPaciente);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            CitaMedica cita = new CitaMedica.Builder()
                    .setId(rs.getInt("id"))
                    .setFecha(rs.getString("fecha"))
                    .setHora(rs.getString("hora"))
                    .setEspecialidad(rs.getString("especialidad"))
                    .setMedico(rs.getString("medico"))
                    .setDiagnostico(rs.getString("diagnostico")) // Si el diagnóstico se encuentra, lo añade
                    .build();

            citas.add(cita);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return citas;
}

    
    public static boolean eliminarCita(int id) {
    try (Connection con = ConexionBD.getInstancia().getConexion();
         java.sql.PreparedStatement ps = con.prepareStatement("DELETE FROM citas WHERE id = ?")) {
         
        ps.setInt(1, id);
        int filas = ps.executeUpdate();
        return filas > 0;
        } catch (SQLException e) {
        e.printStackTrace();
        return false;
        }
    }
    
    public CitaMedica obtenerCitaPorId(int idCita) {
    CitaMedica cita = null;

    try (Connection con = ConexionBD.getInstancia().getConexion()) {
        String sql = "SELECT * FROM citas WHERE id = ?";
        java.sql.PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idCita);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            cita = new CitaMedica.Builder()
                    .setId(rs.getInt("id"))
                    .setFecha(rs.getString("fecha"))
                    .setHora(rs.getString("hora"))
                    .setMedico(rs.getString("medico"))
                    .setEspecialidad(rs.getString("especialidad"))
                    .build();
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return cita;
}
    
    public List<CitaMedica> obtenerCitasPorMedico(String nombreMedico) {
        List<CitaMedica> lista = new ArrayList<>();

        try (Connection con = ConexionBD.getInstancia().getConexion()) {
            String sql = "SELECT * FROM citas WHERE medico = ?";
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreMedico);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CitaMedica cita = new CitaMedica.Builder()
                        .setId(rs.getInt("id"))
                        .setFecha(rs.getString("fecha"))
                        .setHora(rs.getString("hora"))
                        .setEspecialidad(rs.getString("especialidad"))
                        .setMedico(rs.getString("medico"))
                        .setDocumentoPaciente(rs.getString("documento_paciente"))
                        .build();
                lista.add(cita);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener citas del médico: " + e.getMessage());
        }

        System.out.println("Número de citas encontradas: " + lista.size());
        return lista;
    }

    
    public static boolean actualizarEstadoCita(int id, String estado) {
    String sql = "UPDATE citas SET estado = ? WHERE id = ?";

    try (Connection con = ConexionBD.getInstancia().getConexion();
         java.sql.PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, estado);
        ps.setInt(2, id);

        int filas = ps.executeUpdate();
        return filas > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
  }
    
    public static boolean eliminarCitaMedico(int id) {
        try (Connection con = ConexionBD.getInstancia().getConexion();
             java.sql.PreparedStatement ps = con.prepareStatement("DELETE FROM citas WHERE id = ?")) 
        {
             
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public String obtenerNombreMedico(String nomreMedico) {
    String nombreMedico = "";
    try (Connection con = ConexionBD.getInstancia().getConexion()) {
        String sql = "SELECT nombre FROM medicos WHERE id = ?";
        java.sql.PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombreMedico);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            nombreMedico = rs.getString("nombre");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return nombreMedico;
}
    public void actualizarHora(int idCita, String nuevaHora) {
    String sql = "UPDATE citas SET hora = ? WHERE id = ?";

    try (Connection con = ConexionBD.getInstancia().getConexion();
         java.sql.PreparedStatement stmt = con.prepareStatement(sql)) {  // No es necesario hacer cast
        stmt.setString(1, nuevaHora);
        stmt.setInt(2, idCita);
        stmt.executeUpdate();
    } catch (SQLException e) {
        System.err.println("Error al actualizar hora de la cita: " + e.getMessage());
    }
}

public void actualizarFecha(int idCita, String nuevaFecha) {
    String sql = "UPDATE citas SET fecha = ? WHERE id = ?";

    try (Connection con = ConexionBD.getInstancia().getConexion();
         java.sql.PreparedStatement stmt = con.prepareStatement(sql)) {  // No es necesario hacer cast
        stmt.setString(1, nuevaFecha);
        stmt.setInt(2, idCita);
        stmt.executeUpdate();
    } catch (SQLException e) {
        System.err.println("Error al actualizar fecha de la cita: " + e.getMessage());
    }
}
}
