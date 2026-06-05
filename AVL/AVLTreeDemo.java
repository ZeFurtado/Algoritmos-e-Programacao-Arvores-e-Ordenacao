// Classe principal para testar e executar o programa
public class AVLTreeDemo {
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();

        System.out.println("1. Inserindo elementos na árvore AVL...");
        // Inserções sucessivas que causariam desbalanceamento em uma árvore comum
        avl.insert(10, "Produto A");
        avl.insert(20, "Produto B");
        avl.insert(30, "Produto C"); // Força rotação simples à esquerda
        avl.insert(40, "Produto D");
        avl.insert(50, "Produto E"); // Força outra rotação à esquerda
        avl.insert(25, "Produto F"); // Força rotação dupla

        avl.printTree();
        avl.inorder();

        System.out.println("\n2. Editando o valor da chave 30...");
        boolean editSuccess = avl.update(30, "Produto C Alterado");
        if (editSuccess) {
            System.out.println("Sucesso! Novo valor para chave 30 aplicado.");
        } else {
            System.out.println("Erro: Chave não encontrada.");
        }
        avl.printTree();

        System.out.println("\n3. Buscando a chave 40...");
        AVLNode searchResult = avl.search(40);
        if (searchResult != null) {
            System.out.println("Encontrado: " + searchResult.key + " -> " + searchResult.value);
        } else {
            System.out.println("Chave não encontrada na busca.");
        }

        System.out.println("\n4. Removendo a chave 30 (raiz atual)...");
        avl.delete(30);
        avl.printTree();
        
        System.out.println("Percurso Final:");
        avl.levelOrder();
    }
}