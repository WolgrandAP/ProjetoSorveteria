package facade;

import factory.SorveteFactory;
import model.Sorvete;
import strategy.Desconto;
import strategy.DescontoFrequente;
import strategy.DescontoSazonal;

public class SorveteriaFacade {
    private Sorvete sorveteAtual;

    public Sorvete fazerPedido(String tipoSorvete, boolean clienteFrequente) {
        sorveteAtual = SorveteFactory.criarSorvete(tipoSorvete);
        Desconto desconto = clienteFrequente ? new DescontoFrequente() : new DescontoSazonal();
        double precoFinal = desconto.aplicarDesconto(sorveteAtual.getPreco());
        System.out.println("Pedido: " + sorveteAtual.getDescricao() + " | Preço final: R$" + precoFinal);
        return sorveteAtual;
    }

    public Sorvete getSorveteAtual() {
        return sorveteAtual;
    }
}
