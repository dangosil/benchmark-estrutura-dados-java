package estruturas;

public class No {
    public int valor;
    public No esquerda;
    public No direita;
    public int altura; 

    public No(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.altura = 1;
    }
}
