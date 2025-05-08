package Modelo;

public class Paciente {
    private String nombres, apellidos, tipoDocumento, documento, fechaNacimiento;
    private String genero, tipoSangre, alergias, enfermedadesCronicas;
    private String celular, email, ocupacion, direccion, eps, contrasena;

    // Constructor vacío (necesario para setear luego)
    public Paciente() {
    }

    // Constructor con todos los campos (opcional)
    public Paciente(String nombres, String apellidos, String tipoDocumento, String documento,
                    String fechaNacimiento, String genero, String tipoSangre, String alergias,
                    String enfermedadesCronicas, String celular, String email,
                    String ocupacion, String direccion, String eps, String contrasena) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.tipoSangre = tipoSangre;
        this.alergias = alergias;
        this.enfermedadesCronicas = enfermedadesCronicas;
        this.celular = celular;
        this.email = email;
        this.ocupacion = ocupacion;
        this.direccion = direccion;
        this.eps = eps;
        this.contrasena = contrasena;
    }

    // Getters
    public String getNombres()              { return nombres; }
    public String getApellidos()            { return apellidos; }
    public String getTipoDocumento()        { return tipoDocumento; }
    public String getDocumento()            { return documento; }
    public String getFechaNacimiento()      { return fechaNacimiento; }
    public String getGenero()               { return genero; }
    public String getTipoSangre()           { return tipoSangre; }
    public String getAlergias()             { return alergias; }
    public String getEnfermedadesCronicas() { return enfermedadesCronicas; }
    public String getCelular()              { return celular; }
    public String getEmail()                { return email; }
    public String getOcupacion()            { return ocupacion; }
    public String getDireccion()            { return direccion; }
    public String getEps()                  { return eps; }
    public String getContrasena()           { return contrasena; }

    // Setters
    public void setNombres(String nombres)                      { this.nombres = nombres; }
    public void setApellidos(String apellidos)                  { this.apellidos = apellidos; }
    public void setTipoDocumento(String tipoDocumento)          { this.tipoDocumento = tipoDocumento; }
    public void setDocumento(String documento)                  { this.documento = documento; }
    public void setFechaNacimiento(String fechaNacimiento)      { this.fechaNacimiento = fechaNacimiento; }
    public void setGenero(String genero)                        { this.genero = genero; }
    public void setTipoSangre(String tipoSangre)                { this.tipoSangre = tipoSangre; }
    public void setAlergias(String alergias)                    { this.alergias = alergias; }
    public void setEnfermedadesCronicas(String enfermedades)    { this.enfermedadesCronicas = enfermedades; }
    public void setCelular(String celular)                      { this.celular = celular; }
    public void setEmail(String email)                          { this.email = email; }
    public void setOcupacion(String ocupacion)                  { this.ocupacion = ocupacion; }
    public void setDireccion(String direccion)                  { this.direccion = direccion; }
    public void setEps(String eps)                              { this.eps = eps; }
    public void setContrasena(String contrasena)                { this.contrasena = contrasena; }
}
