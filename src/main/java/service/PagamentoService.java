package service;

import model.Pedido;

public class PagamentoService {

    public boolean processarPagamento(Pedido pedido, double valorPago) {
        if (valorPago >= pedido.getTotal()) {
            // Simula pagamento aprovado
            return true;
        }
        return false;
    }
}
