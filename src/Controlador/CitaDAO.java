/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.ConexionBD;
import Modelo.CitaMedica;
import Modelo.CitaMedica;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author marti
 */
public class CitaDAO {

    public static boolean guardarCita(CitaMedica cita) {
        String sql = "INSERT INTO citas (especialidad, medico, documento_paciente) VALUES (?, ?, ? )";

        try (java.sql.Connection con = new ConexionBD().conexion();
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
    String sql = "SELECT * FROM citas WHERE documento_paciente = ?";

    try (java.sql.Connection con = new ConexionBD().conexion();
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
                    .setDocumentoPaciente(rs.getString("documento_paciente"))
                    .build();

            citas.add(cita);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return citas;
}
    
    public static boolean eliminarCita(int id) {
    try (java.sql.Connection con = new ConexionBD().conexion();
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

    try (java.sql.Connection con = new ConexionBD().conexion()) {
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
        ConexionBD conexion = new ConexionBD();

        try (java.sql.Connection con = conexion.conexion()) {
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

    try (java.sql.Connection con = new ConexionBD().conexion();
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
        try (java.sql.Connection con = new ConexionBD().conexion();
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
    try (java.sql.Connection con = new ConexionBD().conexion()) {
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
    
    

}

