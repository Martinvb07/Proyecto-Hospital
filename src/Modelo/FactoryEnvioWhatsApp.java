package Modelo;

public class FactoryEnvioWhatsApp implements FactoryManejadorContacto {
    @Override
    public ManejadorContacto crearManejador() {
        return new ManejadorEnvioWhatsApp();
    }
}
