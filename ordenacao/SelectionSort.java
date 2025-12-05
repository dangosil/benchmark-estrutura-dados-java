package ordenacao;

import estruturas.Vetor;

public class SelectionSort {
    public void ordenar(Vetor vetor) {
        int n = vetor.getTamanho();

        for (int i = 0; i < n - 1; i++) {

            // Encontrar o menor elemento
            int indiceMenor = i;

            for (int j = i + 1; j < n; j++) {
                if (vetor.pegarNoIndice(j) < vetor.pegarNoIndice(indiceMenor)) {
                    indiceMenor = j;
                }
            }

            if (indiceMenor != i) {
                int temp = vetor.pegarNoIndice(indiceMenor);

                // Faz a troca
                vetor.colocarNoIndice(indiceMenor, vetor.pegarNoIndice(i));
                vetor.colocarNoIndice(i, temp);
            }
        }

    }
}
