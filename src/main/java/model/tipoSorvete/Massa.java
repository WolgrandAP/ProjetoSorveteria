package model.tipoSorvete;

import model.Sorvete;

public class Massa implements Sorvete {

    @Override
    public String getDescricao() {
        return "Sorvete de massa tradicional";
    }

    @Override
    public double getPreco() {
        return 7.0;
    }
}
