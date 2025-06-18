package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteRepository {

    private Map<String, Cliente> clientes = new HashMap<>();

    public void salvar(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

    public Cliente buscarPorId(String id) {
        return clientes.get(id);
    }

    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes.values());
    }

    public void deletar(String id) {
        clientes.remove(id);
    }

}
