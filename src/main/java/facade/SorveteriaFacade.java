package facade;

import factory.SorveteFactory;
import model.Sorvete;
import strategy.Desconto;
import strategy.DescontoFrequente;

public class SorveteriaFacade {
    public double fazerPedido(String tipoSorvete, boolean clienteFrequente) {
        Sorvete sorvete = SorveteFactory.criarSorvete(tipoSorvete);
        Desconto desconto = clienteFrequente ? new DescontoFrequente() : preco -> preco;
        double precoFinal = desconto.aplicarDesconto(sorvete.getPreco());
        System.out.println("Pedido: " + sorvete.getDescricao() + " | Preço final: R$" + precoFinal);
        return precoFinal;
    }
}