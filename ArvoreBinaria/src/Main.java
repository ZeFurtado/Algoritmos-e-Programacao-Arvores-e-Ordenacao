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
        
        avBinary.EmOrdem();
    }
}