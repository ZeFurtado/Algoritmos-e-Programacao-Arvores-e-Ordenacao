public class Nodo {
    private int Valor;
    
    private Nodo ValorEsquerda;
    private Nodo ValorDireita;
    
    public Nodo(int Valor){
        this.Valor = Valor;
        this.ValorDireita = null;
        this.ValorEsquerda = null;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int valor) {
        Valor = valor;
    }

    public Nodo getValorEsquerda() {
        return ValorEsquerda;
    }

    public void setValorEsquerda(Nodo valorEsquerda) {
        ValorEsquerda = valorEsquerda;
    }

    public Nodo getValorDireita() {
        return ValorDireita;
    }

    public void setValorDireita(Nodo valorDireita) {
        ValorDireita = valorDireita;
    }
}
