package state;

import model.Pedido;

public interface EstadoPedido {
    void avancarEstado(Pedido pedido);
    String getNomeEstado();
}
