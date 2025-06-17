package command;

import model.Pedido;

public class EditarPedido implements PedidoCommand{

    private Pedido pedidoOriginal;
    private Pedido pedidoNovo;

    public EditarPedido(Pedido pedidoOriginal) {
        this.pedidoOriginal = pedidoOriginal;
    }

    @Override
    public void executar() {
        pedidoNovo = pedidoOriginal.clone(); // Supondo que Pedido implementa Cloneable
        System.out.println("Pedido refeito");
    }

    @Override
    public void desfazer() {
        pedidoNovo = null;
        System.out.println("Edição de pedido desfeito");
    }

    public Pedido getPedidoNovo() {
        return pedidoNovo;
    }

}
