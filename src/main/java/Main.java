import command.PedidoCommand;
import command.RealizarPedido;
import decorator.Calda;
import decorator.Granulado;
import decorator.SorveteDecorator;
import facade.SorveteriaFacade;
import model.Sorvete;
import model.Pedido;
import observer.Cliente;
import observer.PedidoNotifier;
import repository.PedidoRepository;

public class Main {
    public static void main(String[] args) {

        SorveteriaFacade facade = new SorveteriaFacade();

        // Cliente 1
        Cliente cliente1 = new Cliente("Maria");

        Sorvete sorveteBase1 = facade.fazerPedido("massa");
        Sorvete sorveteDecorado1 = new Granulado(new Calda(sorveteBase1));

        Pedido pedido1 = new Pedido(sorveteDecorado1, cliente1, true);

        //  Cliente 2
        Cliente cliente2 = new Cliente("João");

        Sorvete sorveteBase2 = facade.fazerPedido("milkshake");
        Sorvete sorveteDecorado2 = new Granulado(sorveteBase2);

        Pedido pedido2 = new Pedido(sorveteDecorado2, cliente2, false);

        //Comandos
        PedidoCommand comando1 = new RealizarPedido(pedido1);
        PedidoCommand comando2 = new RealizarPedido(pedido2);

        comando1.executar();
        comando2.executar();

        System.out.println();

        // Estados do pedido ded Maria
        System.out.println(pedido1.getEstadoAtual());
        pedido1.avancarEstado();
        System.out.println(pedido1.getEstadoAtual());
        pedido1.avancarEstado();
        System.out.println(pedido1.getEstadoAtual());

        System.out.println();

        // Resumo dos pedidos
        System.out.println("Resumo dos Pedidos:");
        System.out.println(pedido1);
        System.out.println("--------------------");
        System.out.println(pedido2);

        System.out.println();


        comando1.desfazer();


        System.out.println();


        PedidoRepository repo = new PedidoRepository();
        repo.salvarPedido("Pedido finalizado: " + pedido1.getSorvete().getDescricao() + " - R$" + pedido1.aplicarDesconto(pedido1.getSorvete().getPreco()));
    }
}
