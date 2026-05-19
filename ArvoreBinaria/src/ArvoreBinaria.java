public class ArvoreBinaria { 
    
    private Nodo raiz;
    
    public ArvoreBinaria(){
    }
    
    public void Inserir(int valor){
        this.raiz = InserirRecursivo(valor);
    }

    private Nodo InserirRecursivo(int valor){
        return new Nodo(valor);
    }
    
}
