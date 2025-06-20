import command.PedidoCommand;
import command.RealizarPedido;
import facade.SorveteriaFacade;
import observer.Cliente;
import observer.PedidoNotifier;
import repository.PedidoRepository;
import state.PedidoContexto;

public class Main {
    public static void main(String[] args) {
        SorveteriaFacade facade = new SorveteriaFacade();
        double preco = facade.fazerPedido("massa", true);

        Cliente cliente = new Cliente("Ana");
        PedidoNotifier notifier = new PedidoNotifier();
        notifier.adicionarCliente(cliente);
        notifier.notificar("Seu pedido está sendo preparado!");

        PedidoCommand cmd = new RealizarPedido();
        cmd.executar();
        cmd.desfazer();

        PedidoContexto contexto = new PedidoContexto();
        System.out.println("Estado atual: " + contexto.getEstadoAtual());
        contexto.proximoEstado();
        System.out.println("Estado atual: " + contexto.getEstadoAtual());
        contexto.proximoEstado();
        System.out.println("Estado atual: " + contexto.getEstadoAtual());

        PedidoRepository repo = new PedidoRepository();
        repo.salvarPedido("Pedido de sorvete massa com desconto aplicado: R$" + preco);
    }
}