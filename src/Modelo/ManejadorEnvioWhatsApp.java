package Modelo;

import java.awt.Desktop;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ManejadorEnvioWhatsApp implements ManejadorContacto {

    private final String numeroDestino = "573102474429"; 

    @Override
    public void procesarContacto(String nombre, String correo, String celular, String mensaje) {
        try {
            String texto = "Nombre: " + nombre + "\n"
                         + "Correo: " + correo + "\n"
                         + "Celular: " + celular + "\n"
                         + "Mensaje: " + mensaje;

            String textoCodificado = URLEncoder.encode(texto, StandardCharsets.UTF_8.toString());

            String url = "https://api.whatsapp.com/send?phone=" + numeroDestino + "&text=" + textoCodificado;

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                System.err.println("No se puede abrir el navegador desde la aplicación.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
