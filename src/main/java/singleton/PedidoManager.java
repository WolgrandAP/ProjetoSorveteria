package singleton;

import model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoManager {
    private static PedidoManager instancia;
    private List<Pedido> pedidos;

    private PedidoManager() {
        pedidos = new ArrayList<>();
    }

    public static PedidoManager getInstance() {
        if (instancia == null) {
            instancia = new PedidoManager();
        }
        return instancia;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void listarPedidos() {
        System.out.println("Fila de pedidos:");
        for (Pedido pedido : pedidos) {
            System.out.println("Cliente: " + pedido.nomeCliente() + "/ Sorvete: " + pedido.sorvetePedido());
        }
    }
}
