/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author marti
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColeccionPacientes implements Iterable<Paciente> {
    private List<Paciente> pacientes;

    public ColeccionPacientes() {
        this.pacientes = new ArrayList<>();
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    @Override
    public Iterator<Paciente> iterator() {
        return pacientes.iterator();
    }
}

