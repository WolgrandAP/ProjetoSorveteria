package decorator;

import model.Sorvete;

public class Granulado extends SorveteDecorator{
    public Granulado(Sorvete sorvete) {
        super(sorvete);
    }

    public String getDescricao() {
        return sorvete.getDescricao() + ", com Granulado";
    }

    public double getPreco() {
        return sorvete.getPreco() + 0.75;
    }
}
