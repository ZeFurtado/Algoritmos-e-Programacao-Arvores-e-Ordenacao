

public class Teste{
    
    public static void main(String[] args) {
        ArvoreBinaria ab = new ArvoreBinaria();

        System.out.println("Inserindo valores: 50, 30, 20, 40, 70, 60, 80");
        
        ab.inserir(50);
        ab.inserir(30);
        ab.inserir(20);
        ab.inserir(40);
        ab.inserir(70);
        ab.inserir(60);
        ab.inserir(80);

        System.out.print("Percurso Em-ordem: ");
        ab.inorder();

        System.out.print("Percurso Pré-ordem: ");
        ab.preorder();

        System.out.print("Percurso Pós-ordem: ");
        ab.postorder();

        System.out.print("Percurso por Nível: ");
        ab.levelOrder();

        System.out.println("\nBuscando valor 40: " + (ab.procurar(40) ? "Encontrado" : "Não encontrado"));

        System.out.println("\nRemovendo nó 70...");
        ab.remover(70);
        
        System.out.print("Percurso Em-ordem após remoção: ");
        ab.inorder();
    }    
}