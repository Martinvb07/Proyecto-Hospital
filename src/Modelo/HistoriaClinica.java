/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author marti
 */
public class HistoriaClinica {
    private String nombre;
    private String fechaNacimiento;
    private String tipoSangre;
    private String alergias;
    private String enfermedadesCronicas;

    public HistoriaClinica(String nombre, String fechaNacimiento, String tipoSangre, String alergias, String enfermedadesCronicas) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.alergias = alergias;
        this.enfermedadesCronicas = enfermedadesCronicas;
    }

    public String getNombre() { return nombre; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public String getTipoSangre() { return tipoSangre; }
    public String getAlergias() { return alergias; }
    public String getEnfermedadesCronicas() { return enfermedadesCronicas; }
}
