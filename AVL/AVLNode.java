// Representa o nó da Árvore AVL
class AVLNode {
    int key;            // Chave utilizada para busca e ordenação
    String value;       // Valor armazenado no nó (pode ser editado)
    int height;         // Altura do nó para cálculo de balanceamento
    AVLNode left;
    AVLNode right;

    AVLNode(int key, String value) {
        this.key = key;
        this.value = value;
        this.height = 1;
    }
}