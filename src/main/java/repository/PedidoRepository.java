package repository;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {
    private List<String> históricoPedidos = new ArrayList<>();

    public void salvarPedido(String pedido) {
        históricoPedidos.add(pedido);
    }

    public List<String> getPedidos() {
        return históricoPedidos;
    }
}