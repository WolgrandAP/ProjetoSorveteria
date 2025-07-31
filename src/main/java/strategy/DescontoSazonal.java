package strategy;

public class DescontoSazonal implements Desconto {
    public double aplicarDesconto(double preco) {
        return preco * 1; // 20% de desconto
    }
}