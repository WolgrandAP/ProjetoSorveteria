package state;

public class PedidoEntregue implements EstadoPedido {
    public void proximo(PedidoContexto contexto) {
        System.out.println("Pedido já foi entregue.");
    }

    public String getEstado() {
        return "Entregue";
    }
}