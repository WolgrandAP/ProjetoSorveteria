package state;

import model.Pedido;

public class PedidoPreparando implements EstadoPedido{

    @Override
    public void avancarEstado(Pedido pedido) {
        pedido.setEstado(new PedidoPronto());
    }

    @Override
    public String getNomeEstado() {
        return "Preparando pedido";
    }

}
