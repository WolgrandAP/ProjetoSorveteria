package strategy;

public class DescontoSazonal implements Desconto {
    public double aplicarDesconto(double preco) {
        return preco * 0.8; // 20% de desconto
    }
}