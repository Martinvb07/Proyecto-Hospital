package Modelo;

import java.util.Date;

public class HistoriaClinicaDTO {
    private int id;
    private Date fecha;
    private String hora;
    private String paciente;

    // Campos adicionales para la tabla nueva
    private int idPaciente;
    private String descripcionDiagnostico;

    // Getters y Setters existentes
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    public String getPaciente() { return paciente; }
    public void setPaciente(String paciente) { this.paciente = paciente; }

    // Getters y Setters nuevos
    public int getIdPaciente() { return idPaciente; }
    public void setIdPaciente(int idPaciente) { this.idPaciente = idPaciente; }

    public String getDescripcionDiagnostico() { return descripcionDiagnostico; }
    public void setDescripcionDiagnostico(String descripcionDiagnostico) {
        this.descripcionDiagnostico = descripcionDiagnostico;
    }
}
