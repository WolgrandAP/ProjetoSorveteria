package strategy;

public class SemDesconto implements DescontoStrategy{

    @Override
    public double aplicarDesconto(double valorTotal) {
        return valorTotal;
    }
}
