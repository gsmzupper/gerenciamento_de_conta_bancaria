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

import java.util.List;

    public class GerenciadorPessoas {
        private List<Pessoa> pessoas = new ArrayList<>();

        public void adicionarPessoa(Pessoa pessoa) {
            pessoas.add(pessoa);
        }

        public void removerPessoa(Pessoa pessoa) {
            pessoas.remove(pessoa);
        }

        public void listarPessoas() {
            for (Pessoa pessoa : pessoas) {
                System.out.println(pessoa);
            }
        }

        public static void main(String[] args) {
            GerenciadorPessoas gerenciador = new GerenciadorPessoas();

            Pessoa pessoa1 = new Pessoa("alex", 30);
            Pessoa pessoa2 = new Pessoa("Maria", 25);

            gerenciador.adicionarPessoa(pessoa1);
            gerenciador.adicionarPessoa(pessoa2);

            gerenciador.listarPessoas();

            // Removendo a pessoa1
            gerenciador.removerPessoa(pessoa1);

            System.out.println("\nApós a remoção:");
            gerenciador.listarPessoas();
        }
    }
























}


