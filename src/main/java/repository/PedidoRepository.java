package repository;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {
    private List<String> pedidos = new ArrayList<>();

    public void salvarPedido(String pedido) {
        pedidos.add(pedido);
    }

    public List<String> getPedidos() {
        return pedidos;
    }
}