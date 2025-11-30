package util;

import java.util.Random;

public class GeradorDados {

    // vetor ordenado
    public static int[] gerarOrdenado(int tamanho) {
        int[] vetor = new int[tamanho];
        for(int i = 0 ; i< tamanho; i++) {
            vetor[i] = i;
        }
        return vetor;
    }

    // vetor inversamente ordenado
    public static int[] gerarInversamenteOrdenado(int tamanho) {
        int[] vetor = new int[tamanho];
        for(int i = 0; i < tamanho; i++) {
            vetor[i] = tamanho - i;
        }
        return vetor;
    }

    // vetor aleatório
    public static int[] gerarAleatorio(int tamanho) {
        int[] vetor = new int[tamanho];
        Random random = new Random();

        for(int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(tamanho * 2);
        }
        return vetor;
    }
}
