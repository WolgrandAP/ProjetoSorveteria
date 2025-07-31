package observer;

import model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class Cliente implements ClienteObserver {
    private String nome;


    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void atualizar(String mensagem) {
        System.out.println(nome + " recebeu notificação: " + mensagem);
    }


}