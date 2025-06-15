package strategy;

public class DescontoSazonal implements DescontoStrategy {

    @Override
    public double aplicarDesconto(double valorTotal) {
        return valorTotal * 0.85;
    }
}
