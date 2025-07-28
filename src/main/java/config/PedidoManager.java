package config;

import java.util.ArrayList;
import java.util.List;

public class PedidoManager {
    private static PedidoManager instancia;
    private List<String> pedidos;

    private PedidoManager() {
        pedidos = new ArrayList<>();
    }

    public static PedidoManager getInstance() {
        if (instancia == null) {
            instancia = new PedidoManager();
        }
        return instancia;
    }

    public void adicionarPedido(String pedido) {
        pedidos.add(pedido);
    }

    public void listarPedidos() {
        System.out.println("Fila de pedidos:");
        for (String pedido : pedidos) {
            System.out.println("- " + pedido);
        }
    }
}
