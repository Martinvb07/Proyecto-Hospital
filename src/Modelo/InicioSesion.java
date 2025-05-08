package Modelo;

public class InicioSesion {
    private String correo;
    private String contrasena;

    public InicioSesion(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }
}

