/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author marti
 */


public class DoctorDAO {

    public static boolean validarUsuario(String correo, String contrasena) {
        String sql = "SELECT * FROM doctores WHERE email = ? AND contrasena = ?";

        try (Connection con = new ConexionBD().conexion();
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
}

