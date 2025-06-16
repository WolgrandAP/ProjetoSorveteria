package decorator;

import model.Sorvete;

public class ChantillyDecorator extends AdicionalDecorator{

    public ChantillyDecorator(Sorvete sorvete) {
        super(sorvete);
    }

    @Override
    public String getDescricao() {
        return sorvete.getDescricao() + ", chantilly";
    }

    @Override
    public double getPreco() {
        return sorvete.getPreco() + 1.20;
    }
}
