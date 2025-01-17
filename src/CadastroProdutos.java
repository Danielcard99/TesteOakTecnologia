import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class CadastroProdutos {
    private static ArrayList<Produto> produtos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                System.out.println("\nNenhuma opção inserida. Tente novamente.");
                continue;
            }

            int opcao = 0;

            try {
                opcao = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número válido.");
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    listarProdutos();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    System.out.println("Encerrando o programa...");
                    return;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nMenu Pricipal");
        System.out.println("1. Cadastrar Produto");
        System.out.println("2. Listar Produtos");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarProduto() {
        System.out.println("\nCadastro de Produto:");
        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();

        System.out.println("Descrição do Produto: ");
        String descricao = scanner.nextLine();

        System.out.println("Valor do Produto: ");
        double valor;
        try {
            valor = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido. Operação cancelada.");
            return;
        }

        System.out.println("Disponivel para venda (sim/não): ");
        String disponivelInput = scanner.nextLine();
        boolean disponivel = disponivelInput.equalsIgnoreCase("sim");

        Produto produto = new Produto(nome, descricao, valor, disponivel);
        produtos.add(produto);

        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("\nNenhum produto cadastrado.");
            return;
        }

        System.out.println("\nListagem de Produtos (ordenados por valor crescente):");
        produtos.stream().sorted(Comparator.comparingDouble(Produto::getValor)).forEach(System.out::println);

        System.out.println("\nPressione Enter para voltar ao menu principal...");
        scanner.nextLine();
    }

}
