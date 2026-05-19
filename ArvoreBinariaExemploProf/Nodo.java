/**
 * Representa um nó na árvore binária.
 */
public class Nodo {
    private int valor;
    private Nodo esq, dir;

    public Nodo(int item) {
        valor = item;
        esq = dir = null;
    }
    
    public Nodo getEsquerda(){
        return esq;
    }
    
    public Nodo getDireita(){
        return dir;
    }
    
    public int getValor(){
        return valor;
    }
    
    public void setEsquerda(Nodo n){
        esq = n;
    }
    
    public void setDireita(Nodo n){
        dir = n;
    }
    
    public void setValor(int v){
        valor = v;
    }
}