package Modelo;

public class SesionAdmin {
    private static String nombreAdmin;

    public static String getNombreAdmin() {
        return nombreAdmin;
    }

    public static void setNombreAdmin(String nombreAdmin) {
        SesionAdmin.nombreAdmin = nombreAdmin;
    }

    public static void cerrarSesion() {
        nombreAdmin = null;
    }
}
