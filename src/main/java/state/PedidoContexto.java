package state;

public class PedidoContexto {
    private EstadoPedido estado;

    public PedidoContexto() {
        estado = new PedidoRecebido();
    }

    public void proximoEstado() {
        estado.proximo(this);
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public String getEstadoAtual() {
        return estado.getEstado();
    }
}