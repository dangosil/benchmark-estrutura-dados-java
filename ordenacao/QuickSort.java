package ordenacao;

import estruturas.Vetor;

public class QuickSort {
    public void ordenar(Vetor vetor) {
        int n = vetor.getTamanho();
        
        quickSort(vetor, 0, n - 1);
    }

    private void quickSort(Vetor vetor, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionar(vetor, inicio, fim);

            quickSort(vetor, inicio, indicePivo - 1);
            quickSort(vetor, indicePivo + 1, fim);
        }
    }

    private int particionar(Vetor vetor, int inicio, int fim) {
        int pivo = vetor.pegarNoIndice(fim);
        
        int i = (inicio - 1);

        for (int j = inicio; j < fim; j++) {
            if (vetor.pegarNoIndice(j) <= pivo) {
                i++;
                trocar(vetor, i, j);
            }
        }
        trocar(vetor, i + 1, fim);
        return i + 1;
    }

    private void trocar(Vetor vetor, int i, int j) {
        int temp = vetor.pegarNoIndice(i);
        
        vetor.colocarNoIndice(i, vetor.pegarNoIndice(j));
        vetor.colocarNoIndice(j, temp);
    }
}
