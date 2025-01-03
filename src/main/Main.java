package main;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

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
                \tDigite (1) para cadastrar cliente;
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
//                falta preenxer.
                break;
            case 2:
//                falta preenxer.
                break;
            case 3:
//                falta preenxer.
                break;
            case 4:
//                falta preenxer.
                break;
            case 5:
//                falta preenxer.
                break;
            case 6:
                System.out.println("\tAté a próxima!");
                break;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
