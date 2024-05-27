import java.io.*;
import java.util.*;

public class ProdutoDAO {
    private static final String FILE_NAME = "produtos.txt";
    private Map<String, Produto> produtos = new HashMap<>();

    public ProdutoDAO() {
        carregarProdutos();
    }

    public void adicionarProduto(Produto produto) {
        produtos.put(produto.getId(), produto);
        salvarProdutos();
    }

    public Produto lerProduto(String id) {
        return produtos.get(id);
    }

    public List<Produto> listarProdutos() {
        return new ArrayList<>(produtos.values());
    }

    public void atualizarProduto(Produto produto) {
        produtos.put(produto.getId(), produto);
        salvarProdutos();
    }

    public void deletarProduto(String id) {
        produtos.remove(id);
        salvarProdutos();
    }

    private void carregarProdutos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            produtos = (Map<String, Produto>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Arquivo não existe, então começamos com uma lista vazia
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void salvarProdutos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(produtos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
