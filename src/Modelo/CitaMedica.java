package Modelo;

public class CitaMedica {
    private int id;
    private String fecha;
    private String hora;
    private String medico;
    private String especialidad;
    private String documentoPaciente;
    private String diagnostico;

    // Constructor privado para obligar el uso del builder
    private CitaMedica(Builder builder) {
        this.id = builder.id;
        this.fecha = builder.fecha;
        this.hora = builder.hora;
        this.medico = builder.medico;
        this.especialidad = builder.especialidad;
        this.documentoPaciente = builder.documentoPaciente;
        this.diagnostico = builder.diagnostico;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getMedico() {
        return medico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getDocumentoPaciente() {
        return documentoPaciente;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    // Builder
    public static class Builder {
        private int id;
        private String fecha;
        private String hora;
        private String medico;
        private String especialidad;
        private String documentoPaciente;
        private String diagnostico;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setFecha(String fecha) {
            this.fecha = fecha;
            return this;
        }

        public Builder setHora(String hora) {
            this.hora = hora;
            return this;
        }

        public Builder setMedico(String medico) {
            this.medico = medico;
            return this;
        }

        public Builder setEspecialidad(String especialidad) {
            this.especialidad = especialidad;
            return this;
        }

        public Builder setDocumentoPaciente(String documentoPaciente) {
            this.documentoPaciente = documentoPaciente;
            return this;
        }

        public Builder setDiagnostico(String diagnostico) {
            this.diagnostico = diagnostico;
            return this;
        }

        public CitaMedica build() {
            return new CitaMedica(this);
        }
    }
}
