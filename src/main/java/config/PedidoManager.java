package config;

public class PedidoManager {
    private static PedidoManager instancia;

    private PedidoManager() {}

    public static PedidoManager getInstancia() {
        if (instancia == null) {
            instancia = new PedidoManager();
        }
        return instancia;
    }
}