package state;

import model.Pedido;

public class PedidoEntregue implements EstadoPedido{

    @Override
    public void avancarEstado(Pedido pedido) {
        System.out.println("Pedido já foi entregue.");
    }

    @Override
    public String getNomeEstado() {
        return "Pedido entregue";
    }
}
