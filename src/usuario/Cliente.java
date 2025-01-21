package usuario;

import java.util.ArrayList;
import java.util.List;

public class    Cliente {

    private String nome;
    private String cpf;
    private List<Conta> listaDeConta;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.listaDeConta = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void                         setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Conta> getListaDeConta() {
        return listaDeConta;
    }
}
