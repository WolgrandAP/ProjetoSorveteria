package model.tipoSorvete;

import model.Sorvete;

public class Milkshake implements Sorvete {

    @Override
    public String getDescricao() {
        return "Milkshake";
    }

    @Override
    public double getPreco() {
        return 9.0;
    }
}
