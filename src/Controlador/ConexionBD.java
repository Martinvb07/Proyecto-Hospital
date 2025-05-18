package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static ConexionBD instancia;
    private Connection cn;

    private final String URL = "jdbc:mysql://localhost:3306/Hospital?characterEncoding=latin1&useSSL=false&serverTimezone=UTC";
    private final String USUARIO = "root";
    private final String CLAVE = "MartinDavidvb07";

    // Constructor privado
    private ConexionBD() {
        conectar();
    }

    // Método Singleton
    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    // Método que se asegura de devolver una conexión válida
    public Connection getConexion() {
        try {
            if (cn == null || cn.isClosed()) {
                conectar();
            }
        } catch (SQLException e) {
            System.out.println("Error comprobando si la conexión está cerrada: " + e.getMessage());
            conectar(); // Intenta reconectar de todas formas
        }
        return cn;
    }

    // Método privado para crear una nueva conexión
    private void conectar() {
        try {
            cn = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("ERROR DE CONEXIÓN: " + e.getMessage());
        }
    }
}
