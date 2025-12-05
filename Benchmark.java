import java.util.Random;

import estruturas.Vetor;
import util.GeradorDados;
import ordenacao.SelectionSort;
import util.TempoExecucao;
public class Benchmark {

    private static final int[] TAMANHOS = { 100, 1000, 10000 };
    private static final int REPETICOES = 5;
    public static void main(String[] args) {
        System.out.println("=== BENCHMARK: ESTRUTURAS DE DADOS ===");

        executarBateriaOrdenacao();

        System.out.println("\n");

        executarBateriaBusca();
    }

    private static void executarBateriaOrdenacao() {
        System.out.println(">>> 1. TESTES DE ORDENACAO (Selection Sort) <<<");
        System.out.printf("%-10s | %-15s | %-15s\n", "Tamanho", "Cenario", "Tempo Medio");
        System.out.println("---------------------------------------------------------");

        String[] cenarios = {"Aleatorio", "Ordenado", "Inverso"};

        for (int tamanho : TAMANHOS) {
            for (String cenario : cenarios) {
                long media = medirOrdenacao(tamanho, cenario);
                System.out.printf("%-10d | %-15s | %-15d ns\n", tamanho, cenario, media);
            }
            System.out.println("---------------------------------------------------------");
        }
    }

    private static void executarBateriaBusca() {
        System.out.println(">>> 2. TESTES DE BUSCA (Vetor Ordenado) <<<");
        System.out.printf("%-10s | %-15s | %-20s | %-15s\n", "Tamanho", "Tipo", "Alvo", "Tempo Medio");
        System.out.println("--------------------------------------------------------------------------------------");

        Random random = new Random();

        for (int tamanho : TAMANHOS) {
            int[] dados = GeradorDados.gerarOrdenado(tamanho);
             
            int indexRand1 = random.nextInt(tamanho);
            int indexRand2 = random.nextInt(tamanho);
            int indexRand3 = random.nextInt(tamanho);

            int[] alvos = { 
                dados[0],
                dados[tamanho / 2],
                dados[tamanho - 1],
                dados[indexRand1], 
                dados[indexRand2],
                dados[indexRand3],
                -1337
            };

            String[] nomes = { 
                "Primeiro", 
                "Meio", 
                "Ultimo", 
                "Aleatorio A (" + dados[indexRand1] + ")", 
                "Aleatorio B (" + dados[indexRand2] + ")", 
                "Aleatorio C (" + dados[indexRand3] + ")", 
                "Inexistente" 
            };

            for (int i = 0; i < alvos.length; i++) {
                long mediaBinaria = medirBusca(tamanho, alvos[i], true);
                System.out.printf("%-10d | %-15s | %-20s | %-15d ns\n", tamanho, "Binaria", nomes[i], mediaBinaria);

                long mediaSequencial = medirBusca(tamanho, alvos[i], false);
                System.out.printf("%-10d | %-15s | %-20s | %-15d ns\n", tamanho, "Sequencial", nomes[i], mediaSequencial);
            }
            System.out.println("--------------------------------------------------------------------------------------");
        }
    }

    private static long medirOrdenacao(int tamanho, String cenario) {
        long soma = 0;
        TempoExecucao timer = new TempoExecucao();

        for (int i = 0; i < REPETICOES; i++) {
            Vetor vetor = new Vetor();
            int[] dados = obterDadosPorCenario(tamanho, cenario);
            for (int v : dados) vetor.adicionar(v);
            
            SelectionSort sort = new SelectionSort();

            timer.iniciar();
            sort.ordenar(vetor);
            soma += timer.parar();
        }
        return soma / REPETICOES;
    }

    private static long medirBusca(int tamanho, int alvo, boolean isBinaria) {
        long soma = 0;
        TempoExecucao timer = new TempoExecucao();

        // vetor ordenado uma vez fora do loop
        Vetor vetor = new Vetor();
        int[] dados = GeradorDados.gerarOrdenado(tamanho);
        for(int v : dados) vetor.adicionar(v);

        for (int i = 0; i < REPETICOES; i++) {
            timer.iniciar();
            if (isBinaria) vetor.pesquisaBinaria(alvo);
            else vetor.buscaSequencial(alvo);
            soma += timer.parar();
        }
        return soma / REPETICOES;
    }

    private static int[] obterDadosPorCenario(int tamanho, String cenario) {
        switch (cenario) {
            case "Ordenado": return GeradorDados.gerarOrdenado(tamanho);
            case "Inverso": return GeradorDados.gerarInversamenteOrdenado(tamanho);
            default: return GeradorDados.gerarAleatorio(tamanho);
        }
    }
}