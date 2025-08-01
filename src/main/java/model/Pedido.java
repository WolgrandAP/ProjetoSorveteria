package model;

import observer.Cliente;
import state.PedidoContexto;
import strategy.Desconto;
import strategy.DescontoFrequente;
import strategy.DescontoSazonal;

public class Pedido {

    private Sorvete sorvete;
    private Cliente cliente;
    private Desconto desconto; // Pode ser null (sem desconto)
    private PedidoContexto contexto;

    //Sem desconto
    public Pedido(Sorvete sorvete, Cliente cliente) {
        this(sorvete, cliente, null);
    }

    //Com desconto
    public Pedido(Sorvete sorvete, Cliente cliente, boolean isDescontoFrequente) {
        this(sorvete, cliente, isDescontoFrequente ? new DescontoFrequente() : new DescontoSazonal());
    }

    private Pedido(Sorvete sorvete, Cliente cliente, Desconto desconto) {
        this.sorvete = sorvete;
        this.cliente = cliente;
        this.desconto = desconto;
        this.contexto = new PedidoContexto();
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

    public double aplicarDesconto(double valor) {
        return (desconto != null) ? desconto.aplicarDesconto(valor) : valor;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() +
                "\nPedido: " + sorvete.getDescricao() +
                String.format("\nPreço: R$%.2f", aplicarDesconto(sorvete.getPreco())) +
                "\nEstado: " + contexto.getEstadoAtual();
    }
}
