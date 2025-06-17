package command;

import java.util.Stack;

public class ControleCommand {

    private Stack<PedidoCommand> historico = new Stack<>();

    public void executarComando(PedidoCommand comando) {
        comando.executar();
        historico.push(comando);
    }

    public void desfazerUltimoComando() {
        if (!historico.isEmpty()) {
            PedidoCommand comando = historico.pop();
            comando.desfazer();
        }
    }
}
