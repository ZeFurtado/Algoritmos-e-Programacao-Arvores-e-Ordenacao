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
        
        return r; //retorno de r para evitar erro de compilação
    }
    
    public void PreOrdem(){
        PercorrePreOrdem(this.raiz);
    }
    
    //Percurso PréOrdem (VLR) imprime o valor do Nodo raiz e em seguida percorre
    //á esquerda do nodo, caso não haja nenhum nodo há esquerda percorre a direita
    //do Nodo raiz
    private Nodo PercorrePreOrdem(Nodo r){
        if(r == null){ //Caso nodo não exista ele retorna  nulo para sair da recursão
            return null;
        }else{
            System.out.println(r.getValor()); //Imprime o valor do nodo raiz
            //Verifica se o nodo á esquerda é vazio e procura á direita do nodo raiz
            if(PercorrePreOrdem(r.getValorEsquerda()) == null){ 
                return PercorrePreOrdem(r.getValorDireita());
            }
            return r; //retorno de r para evitar erro de compilação
        }
    }
    
    public void PosOrdem(){
        PercorrePosOrdem(this.raiz);
    }
    
    private Nodo PercorrePosOrdem(Nodo r){
        if(r == null) return null;
        
        if(r.getValorEsquerda() != null){
            PercorrePosOrdem(r.getValorEsquerda());
        }
        
        if(r.getValorDireita() != null){
            PercorrePosOrdem(r.getValorDireita());
        }

        System.out.println(r.getValor());
        return r;
    }
    
    
    
}
