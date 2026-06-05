public class Main{
    public static void main(String[] args){
        ArvoreAVL avBinary = new ArvoreAVL();

        avBinary.Inserir(50); //Raiz
        avBinary.Inserir(20); //Valor á esquerda da raiz
        avBinary.Inserir(60); //Valor á direita da raiz
        avBinary.Inserir(25); //Valor á direita do nodo 20
        avBinary.Inserir(70); //Valor á direita do nodo 60
        avBinary.Inserir(55); //Valor á esquerda do nodo 60

        System.out.println("Percorre pré ordem");
        avBinary.PreOrdem();
        
    }
}