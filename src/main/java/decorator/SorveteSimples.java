package decorator;

import model.Sorvete;

public class SorveteSimples implements Sorvete {

    @Override
    public String getDescricao() {
        return "Sorvete Simples";
    }

    @Override
    public double getPreco() {
        return 5.0;
    }
}
