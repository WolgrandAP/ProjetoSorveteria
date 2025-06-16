package decorator;

import model.Sorvete;

public class CaldaDecorator extends AdicionalDecorator{

    public CaldaDecorator(Sorvete sorvete) {
        super(sorvete);
    }

    @Override
    public String getDescricao() {
        return sorvete.getDescricao() + ", calda de morango";
    }

    @Override
    public double getPreco() {
        return sorvete.getPreco() + 1.00;
    }


}
