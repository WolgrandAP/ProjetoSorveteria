package config;

import model.Pedido;

import java.util.LinkedList;
import java.util.Queue;

public class FilaPedidos {

    private static FilaPedidos instace;
    private Queue<Pedido> pedidos = new LinkedList<>();

    public static FilaPedidos getInstance() {
        if(instace == null) {
            instace = new FilaPedidos();
        }
        return instace;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public Pedido proximoPedido() {
        return pedidos.poll(); //Remove o primeiro da fila(n entendi seu uso)
    }

    public Pedido visualizarProximoPedido() {
        return pedidos.peek();
    }

    public boolean filaVazia() {
        return pedidos.isEmpty();
    }

    public int sizeFila() {
        return pedidos.size();
    }

}