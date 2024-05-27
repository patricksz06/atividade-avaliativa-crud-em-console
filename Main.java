import java.util.*;

public class Main {
    private static ProdutoDAO produtoDAO = new ProdutoDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha
            switch (opcao) {
                case 1:
                    criarProduto();
                    break;
                case 2:
                    lerProduto();
                    break;
                case 3:
                    atualizarProduto();
                    break;
                case 4:
                    deletarProduto();
                    break;
                case 5:
                    listarProdutos();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Criar Produto");
        System.out.println("2. Ler Produto");
        System.out.println("3. Atualizar Produto");
        System.out.println("4. Deletar Produto");
        System.out.println("5. Listar Produtos");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void criarProduto() {
        System.out.print("ID do Produto: ");
        String id = scanner.nextLine();
        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();
        System.out.print("Preço do Produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();  // Consumir a nova linha

        Produto produto = new Produto(id, nome, preco);
        produtoDAO.adicionarProduto(produto);
        System.out.println("Produto criado com sucesso!");
    }

    private static void lerProduto() {
        System.out.print("ID do Produto: ");
        String id = scanner.nextLine();
        Produto produto = produtoDAO.lerProduto(id);
        if (produto != null) {
            System.out.println(produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void atualizarProduto() {
        System.out.print("ID do Produto: ");
        String id = scanner.nextLine();
        Produto produto = produtoDAO.lerProduto(id);
        if (produto != null) {
            System.out.print("Novo Nome do Produto: ");
            String nome = scanner.nextLine();
            System.out.print("Novo Preço do Produto: ");
            double preco = scanner.nextDouble();
            scanner.nextLine();  // Consumir a nova linha

            produto.setNome(nome);
            produto.setPreco(preco);
            produtoDAO.atualizarProduto(produto);
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void deletarProduto() {
        System.out.print("ID do Produto: ");
        String id = scanner.nextLine();
        Produto produto = produtoDAO.lerProduto(id);
        if (produto != null) {
            produtoDAO.deletarProduto(id);
            System.out.println("Produto deletado com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void listarProdutos() {
        List<Produto> produtos = produtoDAO.listarProdutos();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }
}
