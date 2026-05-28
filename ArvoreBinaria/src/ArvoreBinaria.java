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
    
    public boolean Procurar(int valor){
        return ProcurarRecursivo(this.raiz, valor) != null;
    }
    //Método ProcuraRecursivo busca se o valor existe na árvore
    private Nodo ProcurarRecursivo(Nodo r, int valor){
        //Verificação se o valor é nulo ou igual ao valor passado no método
        if(r != null && r.getValor() != valor ){
    //Operador verfica se valor é maior que o nodo  //Caso seja verdade ele procura á direita    //Caso seja falso ele procura á esquerdac
            return valor > r.getValor() ? ProcurarRecursivo(r.getValorDireita(), valor) : ProcurarRecursivo(r.getValorEsquerda(), valor);
        }else{
            //Caso seja nulo ou igual o método ele retorna o nodo raiz 
            return r; 
        }
    }
    
    private int MinValor(Nodo r){
        int valor;
        for(valor = r.getValor(); r.getValorEsquerda() != null;r = r.getValorEsquerda()){
            valor = r.getValorEsquerda().getValor();
        }
        return valor;
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
    
    //Percurso PósOrdem(LRV) verifica se o nodo raiz possui nodos á esquerda e 
    //depois á direita, caso não tenha o nodo é impresso na tela;
    private Nodo PercorrePosOrdem(Nodo r){
        if(r == null) return null; //Retorna nulo para sair da recursão
        
        
        //Verifica nodo á esquerda e se este existe passa ele como argumento
        //para nova chamada da função PercorrePosOrdem
        if(r.getValorEsquerda() != null){ 
            PercorrePosOrdem(r.getValorEsquerda());
        }

        //Verifica nodo á direita e se este existe passa ele como argumento
        //para nova chamada da função PercorrePosOrdem
        if(r.getValorDireita() != null){
            PercorrePosOrdem(r.getValorDireita());
        }
        
        //Caso não exista nenhum nodo á esquerda e a direita o nodo 
        //é impresso na tela
        System.out.println(r.getValor());
        return r; //Retorno de r para evitar erro de compilação
    }
    
    
    
}
