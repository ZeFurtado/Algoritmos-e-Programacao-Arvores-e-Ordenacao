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
    
   
}
