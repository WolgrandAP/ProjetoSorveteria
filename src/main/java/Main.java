import config.FilaPedidos;
import decorator.CaldaDecorator;
import decorator.ChantillyDecorator;
import decorator.CoberturaDecorator;
import decorator.SorveteSimples;
import factory.SorveteFactory;
import factory.TipoSorvete;
import model.Sorvete;

public class Main {

    public static void main(String[] args) {

        //Exemplo com factory
        Sorvete s1 = SorveteFactory.criarSorvete(TipoSorvete.MASSA);
        System.out.println(s1.getDescricao() + " - R$" + s1.getPreco());

        //Exemplo com singlenton
        //FilaPedidos fila = FilaPedidos.getInstance();
        //fila.adicionarPedido();


        //Exemplo com decorator
        Sorvete meuSorvete = new SorveteSimples();
        meuSorvete = new CaldaDecorator(meuSorvete);
        meuSorvete = new CoberturaDecorator(meuSorvete);
        meuSorvete = new ChantillyDecorator(meuSorvete);

        System.out.println("Pedido: " + meuSorvete.getDescricao());
        System.out.println("Total: R$" + meuSorvete.getPreco());

    }

}
