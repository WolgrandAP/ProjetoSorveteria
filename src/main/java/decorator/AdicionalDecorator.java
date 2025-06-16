package decorator;

import model.Sorvete;

public abstract class AdicionalDecorator implements Sorvete {

    protected Sorvete sorvete;

    public AdicionalDecorator(Sorvete sorvete) {
        this.sorvete = sorvete;
    }

    public abstract String getDescricao();
    public abstract double getPreco();

}
