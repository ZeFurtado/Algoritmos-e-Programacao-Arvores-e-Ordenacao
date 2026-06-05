import java.util.LinkedList;
import java.util.Queue;

// Implementação da Árvore AVL auto-balanceável
class AVLTree {
    private AVLNode root;

    // Obtem a altura de um nó de forma segura
    private int height(AVLNode node) {
        return (node == null) ? 0 : node.height;
    }

    // Calcula o Fator de Balanceamento do nó
    private int getBalance(AVLNode node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    // Rotação simples à direita
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Executa a rotação
        x.right = y;
        y.left = T2;

        // Atualiza as alturas
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Retorna a nova raiz local
        return x;
    }

    // Rotação simples à esquerda
    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Executa a rotação
        y.left = x;
        x.right = T2;

        // Atualiza as alturas
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Retorna a nova raiz local
        return y;
    }

    // Interface pública de inserção
    public void insert(int key, String value) {
        root = insertRecursive(root, key, value);
    }

    private AVLNode insertRecursive(AVLNode node, int key, String value) {
        // 1. Executa a inserção padrão de uma BST
        if (node == null) {
            return new AVLNode(key, value);
        }

        if (key < node.key) {
            node.left = insertRecursive(node.left, key, value);
        } else if (key > node.key) {
            node.right = insertRecursive(node.right, key, value);
        } else {
            // Se a chave já existe, atualiza apenas o valor (Edição implícita)
            node.value = value;
            return node;
        }

        // 2. Atualiza a altura deste nó ancestral
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // 3. Obtém o fator de balanceamento deste nó para verificar se ficou desbalanceado
        int balance = getBalance(node);

        // Caso Esquerda-Esquerda (LL)
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        // Caso Direita-Direita (RR)
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        // Caso Esquerda-Direita (LR)
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Caso Direita-Esquerda (RL)
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Interface pública de remoção
    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    private AVLNode deleteRecursive(AVLNode node, int key) {
        // 1. Executa a remoção padrão de uma BST
        if (node == null) {
            return node;
        }

        if (key < node.key) {
            node.left = deleteRecursive(node.left, key);
        } else if (key > node.key) {
            node.right = deleteRecursive(node.right, key);
        } else {
            // Encontrou o nó a ser removido
            if ((node.left == null) || (node.right == null)) {
                AVLNode temp = (node.left != null) ? node.left : node.right;

                // Caso sem filhos
                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    // Caso com um filho
                    node = temp; // Copia os dados do filho não nulo
                }
            } else {
                // Caso com dois filhos: obtém o sucessor em-ordem (menor da subárvore direita)
                AVLNode temp = minValueNode(node.right);

                // Copia os dados do sucessor em-ordem para este nó
                node.key = temp.key;
                node.value = temp.value;

                // Remove o sucessor em-ordem
                node.right = deleteRecursive(node.right, temp.key);
            }
        }

        // Se a árvore tinha apenas um nó, retorna
        if (node == null) {
            return node;
        }

        // 2. Atualiza a altura do nó atual
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // 3. Obtém o fator de balanceamento deste nó
        int balance = getBalance(node);

        // Caso Esquerda-Esquerda (LL)
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }

        // Caso Esquerda-Direita (LR)
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Caso Direita-Direita (RR)
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }

        // Caso Direita-Esquerda (RL)
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Interface pública de busca
    public AVLNode search(int key) {
        return searchRecursive(root, key);
    }

    private AVLNode searchRecursive(AVLNode node, int key) {
        if (node == null || node.key == key) {
            return node;
        }

        if (key < node.key) {
            return searchRecursive(node.left, key);
        }
        return searchRecursive(node.right, key);
    }

    // Interface pública para edição do valor
    public boolean update(int key, String newValue) {
        AVLNode node = search(key);
        if (node != null) {
            node.value = newValue;
            return true; // Edição realizada com sucesso
        }
        return false; // Chave não encontrada
    }

    // Exibe a árvore de forma gráfica (rotacionada 90 graus no terminal)
    public void printTree() {
        System.out.println("\n--- Estrutura Atual da Árvore AVL ---");
        printTreeHelper(root, 0);
        System.out.println("--------------------------------------");
    }

    private void printTreeHelper(AVLNode curr, int space) {
        int count = 8; // Espaçamento entre os níveis
        if (curr == null) {
            return;
        }

        space += count;

        // Processa o lado direito primeiro (topo da exibição lateral)
        printTreeHelper(curr.right, space);

        System.out.println();
        for (int i = count; i < space; i++) {
            System.out.print(" ");
        }
        // Exibe chave, valor associado e fator de balanceamento (FB)
        int fb = getBalance(curr);
        System.out.println("[" + curr.key + ":" + curr.value + " (fb=" + fb + ")]");

        // Processa o lado esquerdo (base da exibição lateral)
        printTreeHelper(curr.left, space);
    }

    // Métodos clássicos de percurso
    public void inorder() {
        System.out.print("Em-ordem: ");
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(AVLNode node) {
        if (node != null) {
            inorderRecursive(node.left);
            System.out.print(node.key + ":" + node.value + " | ");
            inorderRecursive(node.right);
        }
    }

    public void levelOrder() {
        System.out.print("Por Nível: ");
        if (root == null) {
            System.out.println("Árvore Vazia");
            return;
        }
        Queue<AVLNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            AVLNode tempNode = queue.poll();
            System.out.print(tempNode.key + ":" + tempNode.value + " | ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        System.out.println();
    }
}