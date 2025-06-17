package state;

import model.Pedido;

public class PedidoPronto implements EstadoPedido {

    @Override
    public void avancarEstado(Pedido pedido) {
        pedido.setEstado(new PedidoEntregue());
    }

    @Override
    public String getNomeEstado() {
        return "Pedido pronto";
    }
}
