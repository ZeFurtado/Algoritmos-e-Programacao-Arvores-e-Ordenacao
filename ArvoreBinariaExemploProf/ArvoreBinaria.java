import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinaria {
    private Nodo raiz;

    // Construtor
    public ArvoreBinaria() {
        raiz = null;
    }

    /**
     * Insere uma nova chave na árvore.
     */
    public void inserir(int v) {
        raiz = inserirRecursivo(raiz, v);
    }

    private Nodo inserirRecursivo(Nodo r, int v) {
        // Se a árvore estiver vazia, retorna um novo nó
        if (r == null) {
            r = new Nodo(v);
            return r;
        }

        // Caso contrário, percorre a árvore
        if (v < r.getValor())
            r.setEsquerda(inserirRecursivo(r.getEsquerda(), v));
        else if (v > r.getValor())
            r.setDireita(inserirRecursivo(r.getDireita(), v));

        return r;
    }

    /**
     * Busca uma chave específica na árvore.
     */
    public boolean procurar(int v) {
        return procurarRecursivo(raiz, v) != null;
    }

    private Nodo procurarRecursivo(Nodo r, int v) {
        // Caso base: raiz é nula ou a chave está presente na raiz
        if (r == null || r.getValor() == v)
            return r;

        // Valor é maior que a chave da raiz
        if (r.getValor() < v)
            return procurarRecursivo(r.getDireita(), v);

        // Valor é menor que a chave da raiz
        return procurarRecursivo(r.getEsquerda(), v);
    }

    /**
     * Remove um nó da árvore.
     */
    public void remover(int  v) {
        raiz = removerRecursivo(raiz, v);
    }

    private Nodo removerRecursivo(Nodo r, int v) {
        if (r == null) return r;

        // Percorrer a árvore para encontrar o nó
        if (v < r.getValor())
            r.setEsquerda(removerRecursivo(r.getEsquerda(), v));
        else if (v > r.getValor())
            r.setDireita(removerRecursivo(r.getDireita(),v));
        else {
            // Nó encontrado!             
            // Caso 1 e 2: Nó com um ou nenhum filho
            if (r.getEsquerda() == null)
                return r.getDireita();
            else if (r.getDireita() == null)
                return r.getEsquerda();

            // Caso 3: Nó com dois filhos
            // Obtém o sucessor em-ordem (menor valor na subárvore direita)
            r.setValor(minValor(r.getDireita()));

            // Deleta o sucessor em-ordem
            r.setDireita(removerRecursivo(r.getDireita(), r.getValor()));
        }
        return r;
    }

    private int minValor(Nodo r) {
        int minv = r.getValor();
        while (r.getEsquerda() != null) {
            minv = r.getEsquerda().getValor();
            r = r.getEsquerda();
        }
        return minv;
    }

    public void inorder() { 
        inorderRecursivo(raiz); 
        System.out.println(); 
    }
    
    private void inorderRecursivo(Nodo r) {
        if (r != null) {
            inorderRecursivo(r.getEsquerda());
            System.out.print(r.getValor() + " ");
            inorderRecursivo(r.getDireita());
        }
    }

    public void preorder() { 
        preorderRecursivo(raiz); 
        System.out.println(); 
    }
    private void preorderRecursivo(Nodo r) {
        if (r != null) {
            System.out.print(r.getValor() + " ");
            preorderRecursivo(r.getEsquerda());
            preorderRecursivo(r.getDireita());
        }
    }

    public void postorder() { 
        postorderRecursivo(raiz); 
        System.out.println(); 
    }
    private void postorderRecursivo(Nodo r) {
        if (r != null) {
            postorderRecursivo(r.getEsquerda());
            postorderRecursivo(r.getDireita());
            System.out.print(r.getValor() + " ");
        }
    }

    /**
     * Percurso por nível usando uma fila (Queue).
     */
    public void levelOrder() {
        if (raiz == null) return;
        Queue<Nodo> queue = new LinkedList<>();
        queue.add(raiz);
        while (!queue.isEmpty()) {
            Nodo tempNodo = queue.poll();
            System.out.print(tempNodo.getValor() + " ");
            if (tempNodo.getEsquerda() != null) queue.add(tempNodo.getEsquerda());
            if (tempNodo.getDireita() != null) queue.add(tempNodo.getDireita());
        }
        System.out.println();
    }    
}