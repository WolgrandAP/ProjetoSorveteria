package command;

import model.Pedido;
import model.Sorvete;

public class AdicionarItem implements PedidoCommand{

    private Pedido pedido;
    private Sorvete sorvete;

    public AdicionarItem(Pedido pedido, Sorvete sorvete) {
        this.pedido = pedido;
        this.sorvete = sorvete;
    }

    @Override
    public void executar() {
        pedido.adicionarSorvete(sorvete);
    }

    @Override
    public void desfazer() {
        pedido.removerSorvete(sorvete);
    }
}
