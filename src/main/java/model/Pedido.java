package model;

import observer.Cliente;
import state.PedidoContexto;
import strategy.Desconto;
import strategy.DescontoFrequente;
import strategy.DescontoSazonal;

public class Pedido {

    private Sorvete sorvete;
    private Cliente cliente;
    private DescontoFrequente descontoFreq = new DescontoFrequente();
    private DescontoSazonal descontoSaz = new DescontoSazonal();
    private boolean isDescontoFrequente;
    private PedidoContexto contexto;

    public Pedido(Sorvete sorvete, Cliente cliente, boolean isDescontoFrequente) {
        this.sorvete = sorvete;
        this.cliente = cliente;
        this.isDescontoFrequente = isDescontoFrequente;
        this.contexto = new PedidoContexto(); // estado inicial: Recebido
    }

    public Sorvete getSorvete() {
        return sorvete;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public PedidoContexto getContexto() {
        return contexto;
    }

    public void avancarEstado() {
        contexto.proximoEstado();
    }

    public String getEstadoAtual() {
        return "Estado do pedido " + cliente.getNome() + ": " + contexto.getEstadoAtual();
    }

    public String nomeCliente() {
        return cliente.getNome();
    }

    public String sorvetePedido() {
        return sorvete.getDescricao();
    }

    public double aplicarDesconto(Double valor) {
        if (isDescontoFrequente) {
            return descontoFreq.aplicarDesconto(valor);
        } else {
            return descontoSaz.aplicarDesconto(valor);
        }
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() +
                "\nPedido: " + sorvete.getDescricao() +
                "\nPreço: R$" + aplicarDesconto(sorvete.getPreco()) +
                "\nEstado: " + contexto.getEstadoAtual();
    }
}


