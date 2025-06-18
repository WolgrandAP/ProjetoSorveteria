package service;

import model.Cliente;
import model.Pedido;
import model.Sorvete;
import observer.ClienteObserver;
import repository.PedidoRepository;
import strategy.DescontoStrategy;

import java.util.List;
import java.util.UUID;

public class PedidoService {
    private PedidoRepository pedidoRepository = new PedidoRepository();
    private FilaService filaService = FilaService.getInstancia();

    public Pedido criarPedido(Cliente cliente, List<Sorvete> sorvetes, DescontoStrategy descontoStrategy) {
        double total = 0;

        for (Sorvete s : sorvetes) {
            total += s.getPreco();
        }

        if (descontoStrategy != null) {
            total = descontoStrategy.aplicarDesconto(total);
        }

        Pedido pedido = new Pedido(UUID.randomUUID().toString(), cliente, sorvetes, total);

        // Adiciona cliente como observador do pedido
        pedido.adicionarObservador(new ClienteObserver(cliente));

        pedidoRepository.salvar(pedido);
        filaService.adicionarPedido(pedido);

        return pedido;
    }
}
