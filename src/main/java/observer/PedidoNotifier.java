package observer;

import java.util.ArrayList;
import java.util.List;

public class PedidoNotifier {
    private List<ClienteObserver> clientes = new ArrayList<>();

    public void adicionarCliente(ClienteObserver cliente) {
        clientes.add(cliente);
    }

    public void notificar(String mensagem) {
        for (ClienteObserver c : clientes) {
            c.atualizar(mensagem);
        }
    }
}

//Essa é a classe que gerencia os observadores. Ela é a "sujeita" no padrão Observer — ou seja,
// quem notifica os outros.