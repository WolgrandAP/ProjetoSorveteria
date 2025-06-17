package model;

import observer.PedidoNotificador;
import observer.PedidoObserver;
import state.EstadoPedido;
import state.PedidoRecebido;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();
    private EstadoPedido estado;
    private double descontoAplicado;

    private PedidoNotificador notificador = new PedidoNotificador();

    public Pedido() {
        this.estado = new PedidoRecebido();
    }

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    public void adicionarObservador(PedidoObserver p) {
        notificador.adicionarObservador(p);
    }

    public void mudarEstado(EstadoPedido estadoNovo) {
        this.estado = estadoNovo;
        notificador.notificarObservadores("Seu pedido está em: " + estadoNovo);
    }

    public void avancarEstado() {
        estado.avancarEstado(this);
        notificador.notificarObservadores("Estado do pedido atualizado para: " + estado.getNomeEstado());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public String getEstadoAtual() {
        return estado.getNomeEstado();
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public double getDescontoAplicado() {
        return descontoAplicado;
    }

    public void aplicarDesconto(double valor) {
        this.descontoAplicado = valor;
    }


}