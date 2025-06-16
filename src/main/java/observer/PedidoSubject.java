package observer;

public interface PedidoSubject {
    void adicionarObservador(PedidoObserver p);
    void removerObservador(PedidoObserver p);
    void notificarObservadores(String mensagem);
}
