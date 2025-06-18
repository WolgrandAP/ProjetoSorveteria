package service;

import model.Pedido;

import java.util.LinkedList;
import java.util.Queue;

public class FilaService {

    private static FilaService instancia;
    private Queue<Pedido> fila = new LinkedList<>();

    private FilaService() {}

    public static FilaService getInstancia() {
        if (instancia == null) {
            instancia = new FilaService();
        }
        return instancia;
    }

    public void adicionarPedido(Pedido pedido) {
        fila.add(pedido);
    }

    public Pedido proximoPedido() {
        return fila.poll();
    }

    public boolean estaVazia() {
        return fila.isEmpty();
    }
}
