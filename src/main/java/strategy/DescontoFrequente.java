package strategy;

public class DescontoFrequente implements Desconto {
    public double aplicarDesconto(double preco) {
        return preco * 0.9; // 10% de desconto
    }
}