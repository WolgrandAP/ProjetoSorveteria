package state;

public interface EstadoPedido {
    void proximo(PedidoContexto contexto);
    String getEstado();
}