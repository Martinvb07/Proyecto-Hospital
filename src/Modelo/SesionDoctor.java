package Modelo;

public class SesionDoctor implements Cloneable {
    private static String nombreDoctor;
    private static String apellidoDoctor;
    private static int documentoDoctor;

    public static void setNombreDoctor(String nombre) {
        nombreDoctor = nombre;
    }

    public static String getNombreDoctor() {
        return nombreDoctor;
    }
    
    public static void setApellidoDoctor(String apellido) {
       apellidoDoctor = apellido;
    }
    
    public static String getApellidoDoctor() {
       return apellidoDoctor;  
    }

    public static void setDocumentoDoctor(int documento){
       documentoDoctor = documento;
    }
    
    public static int getDocumentoDoctor(){
       return documentoDoctor;
    }
    
    // Método para clonar el objeto
    @Override
    public SesionDoctor clone() {
        try {
            return (SesionDoctor) super.clone(); // Llamada al método clone() de la clase Object
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
