public class NodoAVL {
    private int Valor;
    private NodoAVL ValorDireita;
    private NodoAVL ValorEsquerda;
    
    
    public NodoAVL(int valor){
        this.Valor = valor;
        this.ValorEsquerda = null;
        this.ValorDireita = null;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int valor) {
        Valor = valor;
    }

    public NodoAVL getValorEsquerda() {
        return ValorEsquerda;
    }

    public void setValorEsquerda(NodoAVL valorEsquerda) {
        ValorEsquerda = valorEsquerda;
    }

    public NodoAVL getValorDireita() {
        return ValorDireita;
    }

    public void setValorDireita(NodoAVL valorDireita) {
        ValorDireita = valorDireita;
    }
    
    public int getAltura(){
        return Math.max(altura(this.ValorEsquerda), altura(this.ValorDireita));
    }
    
    
    private int altura(NodoAVL r){
        if(r == null){
            return 0;
        }else{
            int alturaEsquerda = altura(r.ValorEsquerda);
            int alturaDireita = altura(r.ValorDireita);
            
            return Math.max(alturaEsquerda, alturaDireita) + 1;
        }
    }
    
    public int getFatorBalanceamento(){
        return altura(ValorEsquerda) - altura(ValorDireita);
    }
    
   
}
