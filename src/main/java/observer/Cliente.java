package observer;

public class Cliente implements ClienteObserver {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public void atualizar(String mensagem) {
        System.out.println(nome + " recebeu notificação: " + mensagem);
    }

    public String getNome() {
        return nome;
    }
}