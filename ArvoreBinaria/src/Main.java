//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        
        ArvoreBinaria avBinary = new ArvoreBinaria();
        
        avBinary.Inserir(50); //Raiz
        avBinary.Inserir(20); //Valor á esquerda da raiz
        avBinary.Inserir(60); //Valor á direita da raiz
        avBinary.Inserir(25); //Valor á direita do nodo 20
        avBinary.Inserir(70); //Valor á direita do nodo 60
        avBinary.Inserir(55); //Valor á esquerda do nodo 60
        
        System.out.println("Percorrendo Em Ordem: ");
        avBinary.EmOrdem();

        System.out.println("-----------");

        System.out.println("Percorrendo Pré Ordem");
        avBinary.PreOrdem();

        System.out.println("------------");

        System.out.println("Percorrendo Pós Ordem");
        avBinary.PosOrdem();

        System.out.println("------------");

        System.out.println("Procurando valor 55");
        System.out.println("55 é " + avBinary.Procurar(55));

        System.out.println("Procurando valor 72");
        System.out.println("72 é " + avBinary.Procurar(72));

        System.out.println("------------");
        System.out.println("Removendo nodo 60");
        avBinary.Remover(60);
        System.out.println("Árvore após a remoção:");
        avBinary.PreOrdem();
    }
}