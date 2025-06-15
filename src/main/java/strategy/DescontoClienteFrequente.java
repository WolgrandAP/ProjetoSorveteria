package strategy;

public class DescontoClienteFrequente implements DescontoStrategy{

    @Override
    public double aplicarDesconto(double valorTotal) {
        return valorTotal*0.9; //10% de desconto
    }
}
