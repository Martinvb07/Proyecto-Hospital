/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Controlador.ConexionBD;
import Modelo.AccionesContacto;
import Modelo.CitaMedica;
import Modelo.Paciente;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import javax.swing.JComboBox;

/**
 *
 * @author marti
 */

public class ControladorAcciones {
    
    //Enviar mensaje al numero de WhatsApp
    
    public void enviarWhatsApp(String numero) {
        AccionesContacto.abrirWhatsApp(numero);
    }

    //Enviar un correo al correo asignado
    
    public void enviarCorreo(String correo, String asunto, String mensaje) {
        AccionesContacto.abrirCorreo(correo, asunto, mensaje);
    }
    
    //Abrir ubicación en Google Maps
    
    public void abrirUbicacion(String direccion) {
        AccionesContacto.abrirGoogleMaps(direccion);
    }
    
    //Cargar pacientes en Menu_Doctor
 
    public DefaultTableModel obtenerPacientes(){
        return PacienteDAO.obtenerPacientes();
    }
    
    //Cargar pacientes en Menu_Admin
 
    public DefaultTableModel obtenerPacientesMenuAdmin(){
        return PacienteDAO.obtenerPacientesAdmin();
    }
    
    //Validar datos del Inicio Sesion con los datos registrados en la DB
    
    public boolean validarInicioSesion(String correo, String contrasena) {
        return PacienteDAO.validarUsuario(correo, contrasena);
    }
    
    // Obtener los datos completos de un paciente por su documento
    
    public Modelo.Paciente obtenerPacientePorDocumento(String documento) {
    PacienteDAO dao = new PacienteDAO();
        return dao.obtenerPacientePorDocumento(documento);
    }
    
    // Eliminar Paciente desde la tabla del doctor
    
    public boolean eliminarPaciente(String documento) {
        return PacienteDAO.eliminarPaciente(documento);
    }
    
    // Validar el tipo de usuario (Paciente o Doctor)
    
    public String obtenerTipoUsuario(String correo , String contrasena){
    if (DoctorDAO.validarUsuario(correo , contrasena)) {
        return "doctor";
    } else if (PacienteDAO.validarUsuario(correo, contrasena)) {
        return "paciente";
    } else if (validarAdmin(correo, contrasena)) {
        return "admin";
    } else {
        return null;
    }
}
private boolean validarAdmin(String correo, String contrasena) {
    String sql = "SELECT * FROM admins WHERE email = ? AND contraseña = ?";
    try (Connection con = ConexionBD.getInstancia().getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, correo);
        ps.setString(2, contrasena);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    } catch (SQLException e) {
        System.err.println("Error al validar admin: " + e.getMessage());
    }
    return false;
}

public String obtenerNombreAdmin(String correo) {
    String sql = "SELECT nombre FROM admins WHERE email = ?";
    try (Connection con = ConexionBD.getInstancia().getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, correo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getString("nombre");
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener nombre del admin: " + e.getMessage());
    }
    return null;
}

    
    // Agendar Cita desde Menu paciente
    
    public boolean agendarCita(CitaMedica cita) {
        return CitaDAO.guardarCita(cita);
    }
    
    //
    
    public List<CitaMedica> obtenerCitasDelPaciente(String documentoPaciente) {
        return CitaDAO.obtenerCitasPorPaciente(documentoPaciente);
    }

    
    
    //
    
    public DefaultTableModel obtenerModeloCitasDelPaciente(String documentoPaciente) {
    DefaultTableModel modelo = new DefaultTableModel(
        new Object[]{"Fecha", "Hora", "Médico", "Especialidad", "👤", "ID", "❌"}, 0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 4 || column == 6;
        }
    };

    List<CitaMedica> citas = obtenerCitasDelPaciente(documentoPaciente);
    for (CitaMedica cita : citas) {
        modelo.addRow(new Object[]{
            cita.getFecha(),
            cita.getHora(),
            cita.getMedico(),
            cita.getEspecialidad(),
            "👤",
            cita.getId(),
            "❌"
        });
    }

    return modelo;
    }
    
    public int obtenerIdPacientePorDocumento(String documento) {
    int id = -1;
    String sql = "SELECT id FROM pacientes WHERE numero_documento = ?";

    try (Connection con = ConexionBD.getInstancia().getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, documento);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            id = rs.getInt("id");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return id;
}

    
    public DefaultTableModel obtenerModeloMedicamentosDelPaciente(String documentoPaciente) {
    DefaultTableModel modelo = new DefaultTableModel(
        new Object[]{"Medicamentos", "Dosis", "Desde", "Hasta"}, 0
    );

    int idPaciente = obtenerIdPacientePorDocumento(documentoPaciente);
    if (idPaciente == -1) {
        System.out.println("No se encontró el paciente con documento: " + documentoPaciente);
        return modelo;
    }

    String sql = "SELECT medicamentos, dosis, desde, hasta FROM historiaclinica WHERE id_paciente = ?";
    
    try (Connection con = ConexionBD.getInstancia().getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, idPaciente);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getString("medicamentos"),
                rs.getString("dosis"),
                rs.getDate("desde"),
                rs.getDate("hasta")
            });
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return modelo;
}


    
    //Cargar Historia clinica
    public DefaultTableModel CargarModeloHistoriaDelPaciente(String documentoPaciente) {
    DefaultTableModel modelo1 = new DefaultTableModel(
        new Object[]{"Fecha", "Hora", "Médico", "Especialidad", "Diagnóstico"}, 0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 4; // Solo la columna "Diagnóstico" es editable
        }
    };

    List<CitaMedica> citas = obtenerCitasDelPaciente(documentoPaciente);

    if (citas != null && !citas.isEmpty()) {
        for (CitaMedica cita : citas) {
            modelo1.addRow(new Object[]{
                cita.getFecha() != null ? cita.getFecha() : "",
                cita.getHora() != null ? cita.getHora() : "",
                cita.getMedico() != null ? cita.getMedico() : "",
                cita.getEspecialidad() != null ? cita.getEspecialidad() : "",
                cita.getDiagnostico() != null ? cita.getDiagnostico() : ""  // Aquí asignamos el diagnóstico
            });
        }
    } else {
        System.out.println("No se encontraron citas para el paciente");
    }

    return modelo1;
}

    
    // Mostrar los datos mediante el ID en la BD
    
    public CitaMedica obtenerCitaPorId(int idCita) {
        CitaDAO dao = new CitaDAO();
        return dao.obtenerCitaPorId(idCita);
    }
    
    //
    
    

    public List<CitaMedica> obtenerCitasPorDoctor(String nombreMedico) {
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

    
    
    public String obtenerNombreDoctor(String correo) {
        String nombreDoctor = null;
        try (Connection con = ConexionBD.getInstancia().getConexion()) {
            String sql = "SELECT nombres FROM doctores WHERE email = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nombreDoctor = rs.getString("nombres");  // Suponiendo que el nombre está en la columna 'nombres'
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return nombreDoctor;
    }
    
    public String obtenerApellidoDoctor(String correo) {
    String apellido = "";
    try (Connection con = ConexionBD.getInstancia().getConexion()) {
        String sql = "SELECT apellidos FROM doctores WHERE email = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, correo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            apellido = rs.getString("apellidos");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return apellido;
    } 
    
    

    public static void marcarCitaComoVista(int idCita) {
        CitaDAO.actualizarEstadoCita(idCita, "vista");
    }
    
    public static void marcarCitaComoNoAsistida(int idCita) {
        CitaDAO.actualizarEstadoCita(idCita, "no asistió");
    }
    
    public boolean eliminarCita(int idCita) {
        return CitaDAO.eliminarCita(idCita);
    }
    
    public boolean eliminarCitaMedico(int idCita) {
        return CitaDAO.eliminarCitaMedico(idCita);
    }


    
    public boolean actualizarPaciente(Paciente paciente) {
         PacienteDAO dao = new PacienteDAO();
         return dao.actualizarPaciente(paciente);
    }
    
    public List<CitaMedica> obtenerCitasPorMedico(String nombreMedico) {
        CitaDAO dao = new CitaDAO();
        return dao.obtenerCitasPorMedico(nombreMedico);
    }
    
    public static void cargarMedicosEnComboBox(JComboBox<String> cbMedicos) {
        List<String> medicos = DoctorDAO.obtenerNombresYApellidos();
        for (String medico : medicos) {
            cbMedicos.addItem(medico);
        }
    }
    
    public void actualizarHoraCita(int idCita, String nuevaHora) {
    new CitaDAO().actualizarHora(idCita, nuevaHora);
}

public void actualizarFechaCita(int idCita, String nuevaFecha) {
    new CitaDAO().actualizarFecha(idCita, nuevaFecha);
}
}
