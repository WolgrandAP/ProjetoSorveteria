package decorator;

import model.Sorvete;

public class CoberturaDecorator extends AdicionalDecorator{

    public CoberturaDecorator(Sorvete sorvete) {
        super(sorvete);
    }

    @Override
    public String getDescricao() {
        return sorvete.getDescricao() + ", cobertura de chocolate";
    }

    @Override
    public double getPreco() {
        return sorvete.getPreco() + 1.50;
    }
}
