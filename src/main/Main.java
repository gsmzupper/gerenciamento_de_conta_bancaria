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
        Conta conta = buscarConta();
        if (conta != null) {
            System.out.println("\tDigite o valor do saque:");
            double valor = sc.nextDouble();
            if (conta.getSaldo() >= valor) {
                conta.subtrai(valor);
                System.out.println("\tSaque realizado com sucesso! Saldo atual: " + conta.getSaldo());
            } else {
                System.out.println("\tSaldo insuficiente.");
            }
        }
    }

    public static void realizarDeposito() {
        Conta conta = buscarConta();
        if (conta != null) {
            System.out.println("\tDigite o valor do depósito:");
            double valor = sc.nextDouble();
            conta.adiciona(valor);
            System.out.println("\tDepósito realizado com sucesso! Saldo atual: " + conta.getSaldo());
        }
    }

    
    public static void realizarTransferencia() {
        System.out.println("\tDigite o número da conta de origem:");
        Conta contaOrigem = buscarConta();
        if (contaOrigem != null) {
            System.out.println("\tDigite o número da conta de destino:");
            Conta contaDestino = buscarConta();
            if (contaDestino != null) {
                System.out.println("\tDigite o valor da transferência:");
                double valor = sc.nextDouble();
                if (contaOrigem.getSaldo() >= valor) {
                    contaOrigem.subtrai(valor);
                    contaDestino.adiciona(valor);
                    System.out.println("\tTransferência realizada com sucesso!");
                } else {
                    System.out.println("\tSaldo insuficiente.");
                }
            }
        }
    }

    public static void consultarSaldo() {
        Conta conta = buscarConta();
        if (conta != null) {
            System.out.println("\tSaldo atual: " + conta.getSaldo());
        }
    }


    private static Conta buscarConta() {
        System.out.println("\tDigite o número da conta (formato: XXXXXXXX-X):");
        String identificacaoConta = sc.nextLine();
        for (Conta conta : contas) {
            if (conta.getIDENTIFICACAOCONTA().equals(identificacaoConta)) {
                return conta;
            }
        }
        System.out.println("\tConta não encontrada.");
        return null;
    }
}
