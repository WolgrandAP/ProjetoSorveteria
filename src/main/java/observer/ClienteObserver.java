package observer;

public class ClienteObserver implements PedidoObserver{

    private String nome;

    public ClienteObserver(String nome) {
        this.nome = nome;
    }

    @Override
    public void notificar(String mensagem) {
        System.out.println("Cliente: " + nome + " - " + mensagem);
    }
}
