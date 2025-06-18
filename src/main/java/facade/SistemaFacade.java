package facade;

import command.ControleCommand;
import model.Cliente;
import model.Pedido;
import model.Sorvete;
import strategy.DescontoStrategy;

import java.util.List;

public class SistemaFacade {
    private PedidoService pedidoService;
    private DescontoService descontoService;
    private FilaService filaService;
    private ControleCommand controleCommand;

    public SistemaFacade() {
        this.pedidoService = new PedidoService;
        this.descontoService = new DescontoService();
        this.filaService = FilaService.getInstance(); // Singleton
        this.controleCommand = new ControleCommand();
    }

    public Pedido realizarPedido(Cliente cliente, List<Sorvete> itens) {
        Pedido pedido = pedidoService.criarPedido(cliente);

        for (Sorvete s : itens) {
            ControleCommand cmd = new AdicionarItemComando(pedido, s);
            controleCommand.executarComando(cmd);
        }

        pedidoService.salvarPedido(pedido);
        filaService.adicionarPedido(pedido);

        return pedido;
    }

    public void aplicarDesconto(Pedido pedido, DescontoStrategy strategy) {
        double valorFinal = descontoService.aplicarDesconto(pedido, strategy);
        pedido.setValorTotal(valorFinal);
    }

    public void cancelarPedido(Pedido pedido) {
        ControleCommand cmd = new CancelarPedidoComando(pedido);
        controleCommand.executarComando(cmd);
    }

    public String acompanharStatus(Pedido pedido) {
        return pedido.getEstado().getNomeEstado(); // Estado atual do pedido
    }

    public void desfazerUltimaAcao() {
        controleCommand.desfazerUltimoComando();
    }
}
