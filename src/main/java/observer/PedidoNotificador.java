package observer;

import java.util.ArrayList;
import java.util.List;

public class PedidoNotificador implements PedidoSubject{

    private List<PedidoObserver> observadores = new ArrayList<>();

    @Override
    public void adicionarObservador(PedidoObserver p) {
        observadores.add(p);
    }

    @Override
    public void removerObservador(PedidoObserver p) {
        observadores.remove(p);
    }

    @Override
    public void notificarObservadores(String mensagem) {
        for (PedidoObserver p : observadores) {
            p.notificar(mensagem);
        }
    }
}
