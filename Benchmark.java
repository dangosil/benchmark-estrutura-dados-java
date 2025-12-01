import estruturas.Vetor;
import util.GeradorDados;

import java.util.Arrays;
public class Benchmark {
    public static void main(String[] args) {
        System.out.println("Hello world");

        System.out.println("TESTE 01: insercao e busca sequencial (aleatorios)");

        int tamanho = 10;
        int[] aleatorios = GeradorDados.gerarAleatorio(tamanho);

        Vetor vetorAleatorio = new Vetor();
        for(int valor : aleatorios) {
            vetorAleatorio.adicionar(valor);
        }

        System.out.println("Gerado: " + Arrays.toString(aleatorios));

        int busca1 = aleatorios[0];
        int busca2 = -999;

        System.out.println("Buscando " + busca1 + ": Indice encontrado = " + vetorAleatorio.buscaSequencial(busca1));
        System.out.println("Buscando " + busca2 + ": Indice encontrado = " + vetorAleatorio.buscaSequencial(busca2));

        System.out.println("\n--------------------------------------------------\n");
    
        System.out.println("TESTE 2: Busca Binaria (Dados Ordenados)");

        int[] dadosOrdenados = GeradorDados.gerarOrdenado(tamanho);

        Vetor vetorOrdenado = new Vetor();
        for (int valor : dadosOrdenados) {
            vetorOrdenado.adicionar(valor);
        }

        System.out.println("Gerado: " + Arrays.toString(dadosOrdenados));

        int valorBusca = 7;
        int resultadoBinaria = vetorOrdenado.pesquisaBinaria(valorBusca);
        
        System.out.println("Busca Binaria por " + valorBusca + ": indice encontrado = " + resultadoBinaria);
        
        if (resultadoBinaria == valorBusca) {
            System.out.println("SUCESSO: A busca binaria funcionou corretamente!");
        } else {
            System.out.println("ERRO: A busca binaria falhou.");
        }
    }
}
