package state;

import model.Pedido;

public class PedidoRecebido implements EstadoPedido {

    @Override
    public void avancarEstado(Pedido pedido) {
        pedido.setEstado(new PedidoPreparando());
    }

    @Override
    public String getNomeEstado() {
        return "Pedido recebido";
    }
}
