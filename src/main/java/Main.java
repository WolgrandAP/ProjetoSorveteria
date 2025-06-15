import factory.SorveteFactory;
import factory.TipoSorvete;
import model.Sorvete;

public class Main {

    public static void main(String[] args) {

        Sorvete s1 = SorveteFactory.criarSorvete(TipoSorvete.MASSA);
        System.out.println(s1.getDescricao() + " - R$" + s1.getPreco());

    }

}
