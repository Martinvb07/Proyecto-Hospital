 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.ConexionBD;
import Modelo.ColeccionPacientes;
import Modelo.Paciente;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marti
 */

//Mostrar datos en tabla

public class PacienteDAO {
    public static DefaultTableModel obtenerPacientes() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("Nombres");
    modelo.addColumn("N° Documento");
    modelo.addColumn("Ocupación");
    modelo.addColumn("EPS");
    modelo.addColumn("Opciones"); 

    try (Connection con = ConexionBD.getInstancia().getConexion();
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT nombres, numero_documento, ocupacion, eps FROM pacientes")) {
        
        while (rs.next()) {
            Object[] fila = {
                rs.getString("nombres"),
                rs.getString("numero_documento"),
                rs.getString("ocupacion"),
                rs.getString("eps"),
                "" 
                };
                modelo.addRow(fila);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return modelo;
}
    
    public static DefaultTableModel obtenerPacientesAdmin() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("ID");
    modelo.addColumn("Nombres");
    modelo.addColumn("N° Documento");
    modelo.addColumn("Email");
    modelo.addColumn("EPS");

    try (Connection con = ConexionBD.getInstancia().getConexion();
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT id ,nombres, numero_documento, email, eps FROM pacientes")) {
        
        while (rs.next()) {
            Object[] fila = {
                rs.getString("id"),
                rs.getString("nombres"),
                rs.getString("numero_documento"),
                rs.getString("email"),
                rs.getString("eps"),
                };
                modelo.addRow(fila);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return modelo;
}
    
    public Paciente obtenerPacientePorId(int id) {
    Paciente paciente = null;
    String sql = "SELECT * FROM pacientes WHERE id = ?";

    try (Connection con = ConexionBD.getInstancia().getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            paciente = new Paciente();
            paciente.setId(rs.getInt("id"));
            paciente.setNombres(rs.getString("nombres"));
            paciente.setDocumento(rs.getString("numero_documento"));
            paciente.setOcupacion(rs.getString("ocupacion"));
            paciente.setEps(rs.getString("eps"));
            paciente.setAlergias(rs.getString("alergias"));
            paciente.setCelular(rs.getString("celular"));
            paciente.setContrasena(rs.getString("contrasena"));
            paciente.setDireccion(rs.getString("direccion"));
            paciente.setEmail(rs.getString("email"));
            paciente.setEnfermedadesCronicas(rs.getString("enfermedades_cronicas"));
            paciente.setTipoDocumento(rs.getString("tipo_documento"));

        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return paciente;
    }

 public boolean actualizarDatosPacienteAdmin(Paciente paciente) {
    String sql = "UPDATE pacientes SET tipo_documento = ?, numero_documento = ?, alergias = ?, enfermedades_cronicas = ?, celular = ? , email = ?, direccion = ?, eps = ?, contrasena = ? WHERE id = ?";
    
    try (Connection con = ConexionBD.getInstancia().getConexion();
         PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, paciente.getTipoDocumento());
            stmt.setString(2, paciente.getDocumento());
            stmt.setString(3, paciente.getAlergias());
            stmt.setString(4, paciente.getEnfermedadesCronicas());
            stmt.setString(5, paciente.getCelular());
            stmt.setString(6, paciente.getEmail());
            stmt.setString(7, paciente.getDireccion());
            stmt.setString(8, paciente.getEps());
            stmt.setString(9, paciente.getContrasena());
            stmt.setInt(10, paciente.getId());

            int filasActualizadas = stmt.executeUpdate();
            return filasActualizadas > 0;

         } catch (SQLException e) {
              System.err.println("Error al actualizar médico: " + e.getMessage());
              return false;
         }
}    
//Validar datos de la BD del paciente para iniciar sesion
    
public static boolean validarUsuario(String correo, String contrasena) {
    boolean acceso = false;

    try (Connection con = ConexionBD.getInstancia().getConexion()) {
        String sql = "SELECT * FROM pacientes WHERE email = ? AND contrasena = ?";
        PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ps.setString(1, correo);
        ps.setString(2, contrasena);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            acceso = true;
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al validar usuario: " + e.getMessage());
    }

    return acceso;
}

//Obtener la informacion

public static Paciente validarYObtenerPaciente(String correo, String contrasena) {
    Paciente p = null;

    try (Connection con = ConexionBD.getInstancia().getConexion()) {
        String sql = "SELECT * FROM pacientes WHERE email = ? AND contrasena = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, correo);
        ps.setString(2, contrasena);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            p = new Paciente();
            p.setNombres(rs.getString("nombres"));
            p.setApellidos(rs.getString("apellidos"));
            p.setTipoDocumento(rs.getString("tipo_documento"));
            p.setDocumento(rs.getString("numero_documento"));
            p.setFechaNacimiento(rs.getString("fecha_nacimiento"));
            p.setGenero(rs.getString("genero"));
            p.setTipoSangre(rs.getString("tipo_sangre"));
            p.setAlergias(rs.getString("alergias"));
            p.setEnfermedadesCronicas(rs.getString("enfermedades_cronicas"));
            p.setCelular(rs.getString("celular"));
            p.setEmail(rs.getString("email"));
            p.setOcupacion(rs.getString("ocupacion"));
            p.setDireccion(rs.getString("direccion"));
            p.setEps(rs.getString("eps"));
            p.setContrasena(rs.getString("contrasena"));
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al validar y obtener paciente: " + e.getMessage());
    }

    return p;
}

//Registro de Paciente
    
public boolean registrarPaciente(Paciente p) {
    try (Connection con = ConexionBD.getInstancia().getConexion()) {
        String sql = "INSERT INTO pacientes (nombres, apellidos, tipo_documento, numero_documento, fecha_nacimiento, genero, tipo_sangre, alergias, enfermedades_cronicas, celular, email, ocupacion, direccion, eps, contrasena) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);


        ps.setString(1, p.getNombres());
        ps.setString(2, p.getApellidos());
        ps.setString(3, p.getTipoDocumento());
        ps.setString(4, p.getDocumento());
        ps.setString(5, p.getFechaNacimiento());
        ps.setString(6, p.getGenero());
        ps.setString(7, p.getTipoSangre());
        ps.setString(8, p.getAlergias());
        ps.setString(9, p.getEnfermedadesCronicas());
        ps.setString(10, p.getCelular());
        ps.setString(11, p.getEmail());
        ps.setString(12, p.getOcupacion());
        ps.setString(13, p.getDireccion());
        ps.setString(14, p.getEps());
        ps.setString(15, p.getContrasena());

        ps.executeUpdate();
        return true;

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al registrar paciente: " + e.getMessage());
        return false;
    }
  }

// Obtener por documento para poder mostrarlo en las tablas

public Paciente obtenerPacientePorDocumento(String documento) {
    Paciente p = null;
    String sql = "SELECT * FROM pacientes WHERE numero_documento = ?";
    
    try (Connection con = ConexionBD.getInstancia().getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, documento);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            p = new Paciente();
            p.setNombres(rs.getString("nombres"));
            p.setApellidos(rs.getString("apellidos"));
            p.setTipoDocumento(rs.getString("tipo_documento"));
            p.setDocumento(rs.getString("numero_documento"));
            p.setFechaNacimiento(rs.getString("fecha_nacimiento"));
            p.setGenero(rs.getString("genero"));
            p.setTipoSangre(rs.getString("tipo_sangre"));
            p.setAlergias(rs.getString("alergias"));
            p.setEnfermedadesCronicas(rs.getString("enfermedades_cronicas"));
            p.setCelular(rs.getString("celular"));
            p.setEmail(rs.getString("email"));
            p.setOcupacion(rs.getString("ocupacion"));
            p.setDireccion(rs.getString("direccion"));
            p.setEps(rs.getString("eps"));
            p.setContrasena(rs.getString("contrasena"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return p;
}

//EliminarPaciente 

public static boolean eliminarPaciente(String documento) {
    String sql = "DELETE FROM pacientes WHERE numero_documento = ?";
    try (Connection con = ConexionBD.getInstancia().getConexion();
         PreparedStatement pstmt = con.prepareStatement(sql)) {

        pstmt.setString(1, documento);
        int filasAfectadas = pstmt.executeUpdate();

        return filasAfectadas > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

//Actualizar paciente

public boolean actualizarPaciente(Paciente paciente) {
    String sql = "UPDATE pacientes SET tipo_documento = ?, email = ?, celular = ?, numero_documento = ?, direccion = ?, ocupacion = ? WHERE numero_documento = ?";

    try (Connection con = ConexionBD.getInstancia().getConexion(); 
     PreparedStatement ps = con.prepareStatement(sql)) {

     ps.setString(1, paciente.getTipoDocumento());
     ps.setString(2, paciente.getEmail());
     ps.setString(3, paciente.getCelular());
     ps.setString(4, paciente.getDocumento()); 
     ps.setString(5, paciente.getDireccion());
     ps.setString(6, paciente.getOcupacion());

     ps.setString(7, paciente.getDocumento());

     int rowsUpdated = ps.executeUpdate();
     return rowsUpdated > 0; 
    } catch (SQLException e) {
     e.printStackTrace();
     return false;
    }
}

    public int contarPacientes() {
    String sql = "SELECT COUNT(*) FROM pacientes";
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
    
    public ColeccionPacientes obtenerPacientesNombre() {
        ColeccionPacientes coleccion = new ColeccionPacientes();
        String sql = "SELECT id, nombres FROM pacientes";  

        try (Connection con = ConexionBD.getInstancia().getConexion();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setNombres(rs.getString("nombres"));
                coleccion.agregarPaciente(paciente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

         return coleccion;
    }

    
    public int obtenerIdPacientePorNombre(String nombre) {
    int id = -1;
    String sql = "SELECT id FROM pacientes WHERE nombres = ?";
    try (Connection con = ConexionBD.getInstancia().getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            id = rs.getInt("id");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return id;
}
}
