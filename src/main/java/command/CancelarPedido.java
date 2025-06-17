package command;

import model.Pedido;

public class CancelarPedido implements PedidoCommand{

    private Pedido pedido;

    public CancelarPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executar() {
        pedido.cancelar();
    }

    @Override
    public void desfazer() {
        pedido.reabrir();
    }
}
