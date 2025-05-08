/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author marti
 */

public class Sesion {
    private static Paciente paciente;

    public static void setPaciente(Paciente p) {
        paciente = p;
    }

    public static Paciente getPaciente() {
        return paciente;
    }

    public static void cerrarSesion() {
        paciente = null;
    }
}
