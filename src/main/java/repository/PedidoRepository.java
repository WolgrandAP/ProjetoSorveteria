package repository;

import model.Pedido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PedidoRepository {

    private Map<String, Pedido> pedidos = new HashMap<>();

    public void salvar(Pedido pedido) {
        pedidos.put(pedido.getId(), pedido);
    }

    public Pedido buscarPorId(String id) {
        return pedidos.get(id);
    }

    public List<Pedido> listarTodos() {
        return new ArrayList<>(pedidos.values());
    }

    public void deletar(String id) {
        pedidos.remove(id);
    }

}
