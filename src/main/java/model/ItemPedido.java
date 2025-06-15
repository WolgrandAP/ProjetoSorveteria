package model;

public class ItemPedido {
    private Sorvete sorvete;
    private int quantidade;

    public ItemPedido(Sorvete sorvete, int quantidade) {
        this.sorvete = sorvete;
        this.quantidade = quantidade;
    }

    public Sorvete getSorvete() {
        return sorvete;
    }

    public void setSorvete(Sorvete sorvete) {
        this.sorvete = sorvete;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}