package main;

import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import gerador.GeradorDeContas;
import gerenciadores.GerenciadorConta;
import usuario.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Conta> contas = new ArrayList<>();
    private static final List<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        int opicao;
        do {
            menu();
            opicao = sc.nextInt();
            sc.nextLine();
            gerenciaOpcao(opicao);
        } while (opicao != 6);

        sc.close();
    }

    public static void menu() {
        String mensagem = """
                \tBem-vindo ao nosso banco!
                \tDigite (1) para criar conta;
                \tDigite (2) para sacar;
                \tDigite (3) para realizar depósito;
                \tDigite (4) para realizar transferência;
                \tDigite (5) para ver saldo;
                \tDigite (6) para sair do APP.
                \tQual é a sua escolha?
                """;
        System.out.println(mensagem);

    }

    public static void gerenciaOpcao(int escolha) {
        switch (escolha) {
            case 1:
                criarConta();
                break;
            case 2:
                realizarSaque();
                break;
            case 3:
                realizarDeposito();
                break;
            case 4:
                realizarTransferencia();
                break;
            case 5:
                consultarSaldo();
                break;
            case 6:
                System.out.println("\tAté a próxima!");
                break;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }

    public static void criarConta() {
        System.out.println("\tDigite o seu nome: ");
        String nome = sc.nextLine();

        System.out.println("\tDigite o seu CPF: ");
        String cpf = sc.nextLine();

        Usuario usuario = new Usuario(nome, cpf);

        usuarios.add(usuario);

        System.out.println("\tDigite (1) para criar conta corrente ou digite (2) para criar conta boubança: ");
        int escolha = sc.nextInt();

        int numeroConta = GeradorDeContas.numeroDaConta();
        int numeroDigito = GeradorDeContas.numeroDigito();

        switch (escolha) {
            case 1:
                System.out.println("\tDigite a taxa de manutenção:");
                double taxaManutencao = sc.nextDouble();
                System.out.println("\tDigite o valor do cheque especial:");
                double chequeEspecial = sc.nextDouble();

                ContaCorrente cr = GerenciadorConta.criarConta(numeroConta, numeroDigito, taxaManutencao, chequeEspecial);

                contas.add(cr);

                System.out.println("\tConta corrente criada com sucesso! Número: " + cr.getIDENTIFICACAOCONTA());
                break;
            case 2:
                System.out.println("\tDigite a taxa de rendimento:");
                double taxaRendimento = sc.nextDouble();

                ContaPoupanca cp = GerenciadorConta.criarConta(numeroConta, numeroDigito, taxaRendimento);

                contas.add(cp);

                System.out.println("\tConta poupança criada com sucesso! Número: " + cp.getIDENTIFICACAOCONTA());
                break;
            default:
                System.out.println("\tDigite uma opção válida.");
        }
    }

    public static void realizarSaque() {
        System.out.println("\tDigite o número da conta (formato: NUMERO-DIGITO): ");
        String numeroConta = sc.nextLine();

        System.out.println("\tDigite o valor do saque: ");
        double valor = sc.nextDouble();

        Conta conta = buscarConta(numeroConta);

        if (conta != null) {
            new operacoes.Sacar(valor, conta).operacao();
        } else {
            System.out.println("\tConta não encontrada.");
        }

    }

    public static void realizarDeposito() {
        System.out.println("\tDigite o número da conta (formato: NUMERO-DIGITO): ");
        String numeroConta = sc.nextLine();

        System.out.println("\tDigite o valor do depósito: ");
        double valor = sc.nextDouble();

        Conta conta = buscarConta(numeroConta);

        if (conta != null) {
            new operacoes.Depositar(valor, conta).operacao();
        } else {
            System.out.println("\tConta não encontrada.");
        }
    }

    public static void realizarTransferencia() {
        System.out.println("\tDigite o número da conta de origem (formato: NUMERO-DIGITO): ");
        String numeroOrigem = sc.nextLine();

        System.out.println("\tDigite o número da conta de destino (formato: NUMERO-DIGITO): ");
        String numeroDestino = sc.nextLine();

        System.out.println("\tDigite o valor da transferência: ");
        double valor = sc.nextDouble();

        Conta contaOrigem = buscarConta(numeroOrigem);
        Conta contaDestino = buscarConta(numeroDestino);

        if (contaOrigem != null && contaDestino != null) {
            new operacoes.Transferir(valor, contaOrigem, contaDestino).operacao();
        } else {
            System.out.println("\tConta de origem ou destino não encontrada.");
        }
    }

    public static void consultarSaldo() {
        System.out.println("\tDigite o número da conta (formato: NUMERO-DIGITO): ");
        String numeroConta = sc.nextLine();

        Conta conta = buscarConta(numeroConta);

        if (conta != null) {
            System.out.println("\tSaldo da conta " + conta.getIDENTIFICACAOCONTA() + ": " + conta.getSaldo());
        } else {
            System.out.println("\tConta não encontrada.");
        }
    }

    private static Conta buscarConta(String numeroConta) {
        for (Conta conta : contas) {
            if (conta.getIDENTIFICACAOCONTA().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }
}
