package command;

public class RealizarPedido implements PedidoCommand {
    public void executar() {
        System.out.println("Pedido realizado.");
    }

    public void desfazer() {
        System.out.println("Pedido cancelado.");
    }
}