import decorator.Calda;
import decorator.Granulado;
import decorator.SorveteDecorator;
import facade.SorveteriaFacade;
import model.Sorvete;
import model.Pedido;
import observer.Cliente;
import observer.PedidoNotifier;
import repository.PedidoRepository;
import config.PedidoManager;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        PedidoNotifier notifier = new PedidoNotifier();

        // Primeiro Cliente
        Cliente cliente1 = new Cliente("Maria");
        notifier.adicionarCliente(cliente1);

        // Criando o sorvete
        SorveteriaFacade facade = new SorveteriaFacade();
        Sorvete sorveteBase1 = facade.fazerPedido("massa", true);

        // Adicionando calda e granulado
        SorveteDecorator sorvete1Adc1 = new Calda(sorveteBase1);
        SorveteDecorator sorvete1Adc2 = new Granulado(sorvete1Adc1);

        // Criando o pedido e associando ao cliente
        Pedido pedido1 = new Pedido(sorvete1Adc2, cliente1);


        //----------------------------------------------------------------------------------------------------------------------------------

        System.out.println("oi");
        // Segundo Cliente
        Cliente cliente2 = new Cliente("João");
        notifier.adicionarCliente(cliente2);

        Sorvete sorveteBase2 = facade.fazerPedido("milkshake",false);

        SorveteDecorator sorvete2Adc1 = new Granulado(sorveteBase2);

        Pedido pedido2 = new Pedido(sorvete2Adc1,cliente2);

        System.out.println("oi");
        //-----------------------------------------------------------------------------------------------------------------------------------

        // Notificando o cliente
        notifier.notificar("Seu pedido foi recebido e está sendo preparado\n");

        // Registrando na fila de pedidos
        PedidoManager pedidoManager = PedidoManager.getInstance();
        pedidoManager.adicionarPedido(pedido1);
        pedidoManager.adicionarPedido(pedido2);
        pedidoManager.listarPedidos();
        System.out.println();

        // Estados do pedido
        System.out.println("Estados do pedido:");
        System.out.println(pedido1.getEstadoAtual());
        pedido1.avancarEstado();
        System.out.println(pedido1.getEstadoAtual());
        pedido1.avancarEstado();
        System.out.println(pedido1.getEstadoAtual() + "\n");

        // Imprimindo resumo completo
        System.out.println("Resumo dos Pedidos:");
        System.out.println(pedido1);
        System.out.println("--------------------");
        System.out.println(pedido2);

        PedidoRepository repo = new PedidoRepository();
        repo.salvarPedido("Pedido finalizado: " + pedido1.getSorvete().getDescricao() + " - R$" + pedido1.getSorvete().getPreco());

    }
}
