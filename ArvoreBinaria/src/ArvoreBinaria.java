import java.text.BreakIterator;

public class ArvoreBinaria { 
    
    private Nodo raiz;
    
    public ArvoreBinaria(){
    }
    
    public void Inserir(int valor){
        this.raiz = InserirRecursivo(this.raiz, valor);
    }

    private Nodo InserirRecursivo(Nodo r, int valor){
        if(r == null){
            return new Nodo(valor);
        }else{
            if(valor > r.getValor()){
                r.setValorDireita(InserirRecursivo(r.getValorDireita(), valor));
            }else if(valor <= r.getValor()){
                r.setValorEsquerda(InserirRecursivo(r.getValorEsquerda(), valor));
            }
        }
        
        return r;
    }
    
    public void EmOrdem(){
        PercorreEmOrdem(this.raiz);
    }
    
    //Percurso em Ordem (LVR) verificar todos o nodos a esquerda do nodo raiz
    //caso não haja nenhum nodo á esquerda ele imprime o nodo raiz e continua
    //a busca á direita do nodo raiz
    private Nodo PercorreEmOrdem(Nodo r){
        if(r == null) return null; //Caso nodo seja vazio retorna nulo para 
                                    //encerrar a recursão
        
        //Caso nodo não exista á esquerda imprime o valor e continua a busca
        //á direita do nodo
        if(PercorreEmOrdem(r.getValorEsquerda()) == null){
            System.out.println(r.getValor()); 
            return PercorreEmOrdem(r.getValorDireita());
        }
        
        return r;
    }
    
    
}
