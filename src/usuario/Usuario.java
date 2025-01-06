package usuario;

public class Usuario {
    private final String NOME;
    private final String CPF;

    public Usuario(String NOME, String CPF) {
        verificaNome(NOME);
        verificaCpf(CPF);
        this.NOME = NOME;
        this.CPF = CPF;
    }

    private static void verificaNome(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("O nome não pode ser nulo");
        }
    }

    private static void verificaCpf(String cpf) {
        if (cpf == null) {
            throw new IllegalArgumentException("O CPF não pode ser nulo.");
        }
    }

    public String getNOME() {
        return NOME;
    }

    public String getCPF() {
        return CPF;
    }


}
