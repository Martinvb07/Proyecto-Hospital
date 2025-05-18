/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.ConexionBD;
import Modelo.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author marti
 */


public class DoctorDAO {
    
    

    public static boolean validarUsuario(String correo, String contrasena) {
        String sql = "SELECT * FROM doctores WHERE email = ? AND contrasena = ?";

        try (Connection con = ConexionBD.getInstancia().getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, correo);
            ps.setString(2, contrasena);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); 
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; //
    }
    
    public static List<String> obtenerNombresYApellidos() {
        List<String> medicos = new ArrayList<>();
        String sql = "SELECT nombres, apellidos FROM doctores";

        try (Connection con = ConexionBD.getInstancia().getConexion();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String medico = rs.getString("nombres") + " " + rs.getString("apellidos");
                medicos.add(medico);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener los médicos: " + e.getMessage());
        }
        return medicos;
    }
    
   // Método para obtener los datos completos de los médicos
    public static List<Medico> obtenerDatosMedicos() {
        List<Medico> medicos = new ArrayList<>();
        String sql = "SELECT id ,nombres, apellidos, email, telefono, especialidad FROM doctores"; 

            try (Connection con = ConexionBD.getInstancia().getConexion();
                 PreparedStatement stmt = con.prepareStatement(sql);  
                 ResultSet rs = stmt.executeQuery()) {  

                while (rs.next()) {
                    // Crear un objeto Medico con los datos obtenidos
                    Medico medico = new Medico();
                    medico.setId(rs.getInt("id"));  // Ahora asignamos el 'id'
                    medico.setNombres(rs.getString("nombres"));
                    medico.setApellidos(rs.getString("apellidos"));
                    medico.setEmail(rs.getString("email"));
                    medico.setCelular(rs.getString("telefono"));
                    medico.setEspecialidad(rs.getString("especialidad"));

                    // Agregar el objeto Medico a la lista
                    medicos.add(medico);
                }

            } catch (SQLException e) {
                System.err.println("Error al obtener los médicos: " + e.getMessage());  
            }
            return medicos;  
        }
    
     public boolean registrarMedico(Medico medico) {
        String sql = "INSERT INTO doctores (nombres, apellidos, tipo_documento, numero_documento, genero, tipo_sangre, " +
                     "email, telefono, direccion, contrasena, especialidad) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.getInstancia().getConexion();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, medico.getNombres());
            stmt.setString(2, medico.getApellidos());
            stmt.setString(3, medico.getTipoDocumento());
            stmt.setString(4, medico.getNumeroDocumento());
            stmt.setString(5, medico.getGenero());
            stmt.setString(6, medico.getTipoSangre());
            stmt.setString(7, medico.getEmail());
            stmt.setString(8, medico.getCelular());
            stmt.setString(9, medico.getDireccion());
            stmt.setString(10, medico.getContrasena());
            stmt.setString(11, medico.getEspecialidad());

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al registrar médico: " + e.getMessage());
            return false;
        }
    }
     
    public Medico obtenerMedicoPorId(int id) {
    Medico medico = null;
    String sql = "SELECT * FROM doctores WHERE id = ?";

    try (Connection con = ConexionBD.getInstancia().getConexion();
         PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            medico = new Medico();
            medico.setId(rs.getInt("id"));
            medico.setNombres(rs.getString("nombres"));
            medico.setApellidos(rs.getString("apellidos"));
            medico.setEmail(rs.getString("email"));
            medico.setCelular(rs.getString("telefono"));
            medico.setEspecialidad(rs.getString("especialidad"));
            medico.setTipoDocumento(rs.getString("tipo_documento"));
            medico.setNumeroDocumento(rs.getString("numero_documento"));
            medico.setGenero(rs.getString("genero"));
            medico.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
            medico.setTipoSangre(rs.getString("tipo_sangre"));
            medico.setDireccion(rs.getString("direccion"));
            medico.setContrasena(rs.getString("contrasena"));
        } else {
            System.out.println("No se encontró médico con ID: " + id);
        }

    } catch (SQLException e) {
        System.err.println("Error al obtener el médico por ID: " + e.getMessage());
    }

    return medico;
}
    
 public boolean actualizarDatosMedico(Medico medico) {
    String sql = "UPDATE doctores SET direccion = ?, especialidad = ?, email = ?, contrasena = ?, telefono = ? WHERE id = ?";
    
    try (Connection con = ConexionBD.getInstancia().getConexion();
         PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, medico.getDireccion());
            stmt.setString(2, medico.getEspecialidad());
            stmt.setString(3, medico.getEmail());
            stmt.setString(4, medico.getContrasena());
            stmt.setString(5, medico.getCelular());
            stmt.setInt(6, medico.getId());

            int filasActualizadas = stmt.executeUpdate();
            return filasActualizadas > 0;

         } catch (SQLException e) {
              System.err.println("Error al actualizar médico: " + e.getMessage());
              return false;
         }
}
   public int contarDoctores() {
    String sql = "SELECT COUNT(*) FROM doctores";
    int total = 0;

    try (Connection con = ConexionBD.getInstancia().getConexion();
         PreparedStatement stmt = con.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        
        if (rs.next()) {
            total = rs.getInt(1);
        }
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return total;
    }
}
