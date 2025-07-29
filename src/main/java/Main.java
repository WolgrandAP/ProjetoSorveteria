import decorator.Calda;
import decorator.SorveteDecorator;
import facade.SorveteriaFacade;
import model.Sorvete;
import observer.Cliente;
import observer.PedidoNotifier;
import repository.PedidoRepository;
import config.PedidoManager;
import state.PedidoContexto;
import strategy.Desconto;
import strategy.DescontoFrequente;
import strategy.DescontoSazonal;

public class Main {
    public static void main(String[] args) {

        SorveteriaFacade facade = new SorveteriaFacade();
        Sorvete sorveteBase = facade.fazerPedido("massa", true); // retorna Sorvete agora
        double precoBase = sorveteBase.getPreco();
        System.out.println("Preço base do pedido: R$" + precoBase + "\n");

        /*System.out.println("Aplicando descontos");
        Desconto desconto1 = new DescontoFrequente();
        Desconto desconto2 = new DescontoSazonal();*/
        /*double precoComDesconto1 = desconto1.aplicarDesconto(precoBase);
        double precoComDesconto2 = desconto2.aplicarDesconto(precoBase);*/
        /*System.out.println("Cliente frequente: R$" + precoComDesconto1);
        System.out.println("Desconto sazonal: R$" + precoComDesconto2 + "\n");*/

        System.out.println("Adicionando calda ao pedido"); //Tirar essa parte
        SorveteDecorator sorveteComCalda = new Calda(sorveteBase);
        System.out.println("Pedido com calda: " + sorveteComCalda.getDescricao());
        System.out.println("Novo preço: R$" + sorveteComCalda.getPreco() + "\n");

        Cliente cliente = new Cliente("Ana");
        PedidoNotifier notifier = new PedidoNotifier();
        notifier.adicionarCliente(cliente);
        notifier.notificar("Seu pedido foi recebido e está sendo preparado\n");

        PedidoManager pedidoManager = PedidoManager.getInstance();
        pedidoManager.adicionarPedido("Nome: " + cliente.getNome() + " /Pedido: " + sorveteComCalda.getDescricao());
        pedidoManager.listarPedidos();
        System.out.println();


        System.out.println("Estados do pedido:");
        PedidoContexto contexto = new PedidoContexto();
        System.out.println("Estado atual: " + contexto.getEstadoAtual());
        contexto.proximoEstado();
        System.out.println("Estado atual: " + contexto.getEstadoAtual());
        contexto.proximoEstado();
        System.out.println("Estado atual: " + contexto.getEstadoAtual() + "\n");

        PedidoRepository repo = new PedidoRepository();
        repo.salvarPedido("Pedido finalizado: Sorvete massa com calda - R$" + sorveteComCalda.getPreco());

    }
}
