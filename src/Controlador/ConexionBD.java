package Controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    Connection cn = null;

    public Connection conexion() {
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital?characterEncoding=latin1&useSSL=false&serverTimezone=UTC", "root", "MartinDavidvb07");
            System.out.println("SE HIZO LA CONEXION EXITOSA");
        } catch (SQLException e) {
            System.out.println("ERROR DE CONEXIÓN: " + e);
        }
        return cn;
    }
}
