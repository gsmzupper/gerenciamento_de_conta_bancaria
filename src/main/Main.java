package main;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        do {
menu();
op = sc.nextInt();
sc.nextLine();
gerenciaOpcao(op);
        } while (op != 6);

        sc.close();
    }

    public static void menu() {
        System.out.println("\tBem-vindo ao nosso banco!");
        System.out.println("\tDigite (1) para cadastrar cliente;");
        System.out.println("\tDigite (2) para sacar;");
        System.out.println("\tDigite (3) para realisar depósito;");
        System.out.println("\tDigite (4) para realisar transferencia;");
        System.out.println("\tDigite (5) para ver saldo;");
        System.out.println("\tDigite (6) para sair do APP.");
        System.out.println("\tQual é a sua escolha? ");

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
