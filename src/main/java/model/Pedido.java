package model;

import observer.Cliente;
import state.PedidoContexto;

public class Pedido {

    private Sorvete sorvete;
    private Cliente cliente;
    private PedidoContexto contexto;

    public Pedido(Sorvete sorvete, Cliente cliente) {
        this.sorvete = sorvete;
        this.cliente = cliente;
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

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() +
                "\nPedido: " + sorvete.getDescricao() +
                "\nPreço: R$" + sorvete.getPreco() +
                "\nEstado: " + contexto.getEstadoAtual();
    }
}


