package facade;

import factory.SorveteFactory;
import model.Sorvete;
import strategy.Desconto;
import strategy.DescontoFrequente;
import strategy.DescontoSazonal;

public class SorveteriaFacade {
    private Sorvete sorveteAtual;

    public Sorvete fazerPedido(String tipoSorvete) {
        sorveteAtual = SorveteFactory.criarSorvete(tipoSorvete);
        System.out.println("Pedido: " + sorveteAtual.getDescricao() + " | Preço: R$" + sorveteAtual.getPreco());
        return sorveteAtual;
    }

    public Sorvete getSorveteAtual() {
        return sorveteAtual;
    }
}
