package command;

import model.Pedido;
import observer.Cliente;
import observer.ClienteObserver;
import singleton.PedidoManager;

public class RealizarPedido implements PedidoCommand {

    private Pedido pedido;
    private Cliente cliente;

    public RealizarPedido(Pedido pedido) {
        this.pedido = pedido;
        this.cliente = pedido.getCliente(); // pega o cliente do pedido
    }

    @Override
    public void executar() {
        PedidoManager.getInstance().adicionarPedido(pedido);
        cliente.atualizar("Pedido de " + cliente.getNome() + " foi realizado com sucesso!");
    }

    @Override
    public void desfazer() {
        PedidoManager.getInstance().removerPedido(pedido);
        cliente.atualizar("Pedido de " + cliente.getNome() + " foi cancelado.");
    }
}
