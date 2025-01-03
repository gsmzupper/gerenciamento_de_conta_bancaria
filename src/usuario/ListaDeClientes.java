package usuario;

import java.util.List;

public class ListaDeClientes {
    private List<Cliente> listaDeClientes;

    public ListaDeClientes(List<Cliente> listaDeClientes) {
        this.listaDeClientes = listaDeClientes;
    }

    public void adicionaCliente(Cliente cliente){

        listaDeClientes.add(cliente);
    }
}
