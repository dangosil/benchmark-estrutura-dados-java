package estruturas;

public class Vetor {
    private int[] elementos;
    private int tamanho;

    public Vetor() {
        this.elementos = new int[10];
        this.tamanho = 0;
    }

    // adiciona um elemento no final do vetor
    public void adicionar(int elemento) {
        if(tamanho == elementos.length) {
            this.aumentaTamanho();
        }

        elementos[tamanho] = elemento;
        tamanho++;
    }

    // dobra o tamanho do array atual
    private void aumentaTamanho() {
        int[] novosElementos = new int[elementos.length * 2];

        for(int i = 0; i < elementos.length; i++) {
            novosElementos[i] = elementos[i];
        }
        elementos = novosElementos;
    }

    // busca sequencial para qualquer vetor
    public int buscaSequencial(int valor) {
        for(int i = 0; i < tamanho; i++) {
            if(elementos[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    // pesquisa binária (vetor precisa estar ordenado)
    public int pesquisaBinaria(int valor) {
        if(tamanho == 0) {
            return -1;
        }

        int menor = 0;
        int maior = tamanho -1;

        while(menor <= maior) {
            int meio = (menor + maior) / 2;
            int chute = elementos[meio];

            if(chute == valor) {
                return meio;
            } 
            if(chute > valor) {
                maior = meio - 1;
            } else {
                menor = meio + 1;
            }
        }
        return -1;
    }

    public int getTamanho() {
        return tamanho;
    }

    // verifica o elemento no índice i
    public int pegarNoIndice(int indice) {
        if(indice < 0 || indice >= tamanho) {
            throw new IllegalArgumentException("Índice inválido");
        } else {
            return elementos[indice];
        }
    }

    public void colocarNoIndice(int indice, int valor) {
        if(indice < 0 || indice >= tamanho) {
            throw new IllegalArgumentException("Índice inválido");
        } else {
            elementos[indice] = valor;
        }

    }
}
