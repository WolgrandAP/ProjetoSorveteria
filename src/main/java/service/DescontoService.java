package service;

import strategy.DescontoStrategy;

public class DescontoService {

    public double aplicarDesconto(double valor, DescontoStrategy estrategia) {
        return estrategia.aplicarDesconto(valor);
    }

}
