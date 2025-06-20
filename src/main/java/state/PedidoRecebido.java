package state;

public class PedidoRecebido implements EstadoPedido {
    public void proximo(PedidoContexto contexto) {
        contexto.setEstado(new PedidoPreparando());
    }

    public String getEstado() {
        return "Recebido";
    }
}