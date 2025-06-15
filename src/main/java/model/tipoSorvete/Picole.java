package model.tipoSorvete;

import model.Sorvete;

public class Picole implements Sorvete {

    @Override
    public String getDescricao() {
        return "Picolé";
    }

    @Override
    public double getPreco() {
        return 5.0;
    }
}
