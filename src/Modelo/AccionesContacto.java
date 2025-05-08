/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.awt.Desktop;
import java.net.URI;

/**
 *
 * @author marti
 */
public class AccionesContacto {
    
    public static void abrirWhatsApp(String numero) {
        try {
            String url = "https://wa.me/" + numero;
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
     public static void abrirCorreo(String correo, String asunto, String mensaje) {
        try {
            String url = "mailto:" + correo + "?subject=" + asunto.replace(" ", "%20") + "&body=" + mensaje.replace(" ", "%20");
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
     
     public static void abrirGoogleMaps(String direccion) {
        try {
            String url = "https://www.google.com/maps/search/?api=1&query=" + direccion.replace(" ", "%20");
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
