package state;

public class PedidoPreparando implements EstadoPedido {
    public void proximo(PedidoContexto contexto) {
        contexto.setEstado(new PedidoEntregue());
    }

    public String getEstado() {
        return "Preparando";
    }
}