package usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeClientes { // Lista para armazenar os clientes

    private static ArrayList<String> clientes = new ArrayList<>();


    public static ArrayList<String> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<String> clientes) {
        ListaDeClientes.clientes = clientes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {// Exibe o menu de opções


            System.out.println("\nMenu:");
            System.out.println("1. Adicionar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Remover cliente");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");        // Lê a opção escolhida pelo usuário


            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) {
                case 1:// Adicionar cliente

                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    clientes.add(nome);
                    System.out.println("Cliente adicionado com sucesso!");
                    break;

                case 2:// Listar clientes
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        System.out.println("Lista de clientes:");
                        for (int i = 0; i < clientes.size(); i++) {
                            System.out.println((i + 1) + ". " + clientes.get(i));
                        }
                    }
                    break;

                case 3:// Remover cliente

                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente para remover.");
                    } else {
                        System.out.println("Digite o número do cliente que deseja remover:");
                        for (int i = 0; i < clientes.size(); i++) {
                            System.out.println((i + 1) + ". " + clientes.get(i));
                        }
                        int indice = scanner.nextInt();
                        scanner.nextLine(); // Limpa o buffer do scanner
                        if (indice > 0 && indice <= clientes.size()) {
                            String removido = clientes.remove(indice - 1);
                            System.out.println("Cliente " + removido + " removido com sucesso!");
                        } else {
                            System.out.println("Número inválido.");
                        }
                    }
                    break;

                case 4:// Sair

                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}