import java.util.Random;
import estruturas.Vetor;
import estruturas.ArvoreBinaria;
import estruturas.ArvoreAVL;
import util.GeradorDados;
import ordenacao.QuickSort;
import ordenacao.SelectionSort;
import util.TempoExecucao;

public class Benchmark {

    private static final int[] TAMANHOS = { 100, 1000, 10000 };
    private static final int REPETICOES = 5;

    public static void main(String[] args) {
        System.out.println("=== BENCHMARK: ESTRUTURAS DE DADOS ===");

        executarBateriaInsercao();

        System.out.println("\n");

        executarBateriaOrdenacao();

        System.out.println("\n");

        executarBateriaBusca();
    }

    private static void executarBateriaInsercao() {
        System.out.println(">>> 1. TEMPO DE INSERCAO (Medio de 5 execucoes) <<<");
        System.out.printf("%-8s | %-10s | %-12s | %-12s | %-12s\n", "Qtd", "Cenario", "Vetor (ns)", "ABB (ns)",
                "AVL (ns)");
        System.out.println("--------------------------------------------------------------------------");

        String[] cenarios = { "Aleatorio", "Ordenado", "Inverso" };
        TempoExecucao timer = new TempoExecucao();

        for (int tamanho : TAMANHOS) {
            for (String cenario : cenarios) {
                long somaVetor = 0, somaABB = 0, somaAVL = 0;

                for (int i = 0; i < REPETICOES; i++) {
                    int[] dados = obterDadosPorCenario(tamanho, cenario);

                    // Teste Vetor
                    Vetor vetor = new Vetor();
                    timer.iniciar();
                    for (int v : dados)
                        vetor.adicionar(v);
                    somaVetor += timer.parar();

                    // Teste ABB
                    ArvoreBinaria abb = new ArvoreBinaria();
                    timer.iniciar();
                    for (int v : dados)
                        abb.inserir(v);
                    somaABB += timer.parar();

                    // Teste AVL
                    ArvoreAVL avl = new ArvoreAVL();
                    timer.iniciar();
                    for (int v : dados)
                        avl.inserir(v);
                    somaAVL += timer.parar();
                }

                System.out.printf("%-8d | %-10s | %-12d | %-12d | %-12d\n",
                        tamanho, cenario, (somaVetor / REPETICOES), (somaABB / REPETICOES), (somaAVL / REPETICOES));
            }
            System.out.println("--------------------------------------------------------------------------");
        }
    }

    private static void executarBateriaOrdenacao() {
        System.out.println(">>> 2. TESTES DE ORDENACAO (Selection vs QuickSort) <<<");
        System.out.printf("%-10s | %-12s | %-15s | %-15s\n", "Tamanho", "Cenario", "Selection(ns)", "QuickSort(ns)");
        System.out.println("----------------------------------------------------------------------");

        String[] cenarios = { "Aleatorio", "Ordenado", "Inverso" };
        TempoExecucao timer = new TempoExecucao();

        for (int tamanho : TAMANHOS) {
            for (String cenario : cenarios) {
                long somaSelection = 0;
                long somaQuick = 0;

                for (int i = 0; i < REPETICOES; i++) {
                    int[] dadosBase = obterDadosPorCenario(tamanho, cenario);

                    // Teste Selection Sort
                    Vetor v1 = new Vetor();
                    for (int v : dadosBase)
                        v1.adicionar(v);

                    SelectionSort selSort = new SelectionSort();
                    timer.iniciar();
                    selSort.ordenar(v1);
                    somaSelection += timer.parar();

                    // Teste QuickSort
                    Vetor v2 = new Vetor();
                    for (int v : dadosBase)
                        v2.adicionar(v);

                    QuickSort qSort = new QuickSort();
                    timer.iniciar();
                    try {
                        qSort.ordenar(v2);
                    } catch (StackOverflowError e) {
                        System.out.println("[Estouro de Pilha]");
                    }
                    somaQuick += timer.parar();
                }

                System.out.printf("%-10d | %-12s | %-15d | %-15d\n",
                        tamanho, cenario, (somaSelection / REPETICOES), (somaQuick / REPETICOES));
            }
            System.out.println("----------------------------------------------------------------------");
        }
    }

    private static void executarBateriaBusca() {
        System.out.println(">>> 3. TESTES DE BUSCA (Vetor vs ABB vs AVL) <<<");
        System.out.printf("%-8s | %-12s | %-16s | %-12s | %-10s | %-10s\n",
                "Qtd", "Alvo", "Vet(Sequencial)", "Vet(Binaria)", "ABB", "AVL");
        System.out.println("---------------------------------------------------------------------------------------");

        Random random = new Random();
        TempoExecucao timer = new TempoExecucao();

        for (int tamanho : TAMANHOS) {
            int[] dados = GeradorDados.gerarOrdenado(tamanho);

            Vetor vetor = new Vetor();
            ArvoreBinaria abb = new ArvoreBinaria();
            ArvoreAVL avl = new ArvoreAVL();

            for (int v : dados) {
                vetor.adicionar(v);
                abb.inserir(v);
                avl.inserir(v);
            }

            int idxRand1 = random.nextInt(tamanho);
            int idxRand2 = random.nextInt(tamanho);
            int idxRand3 = random.nextInt(tamanho);

            int[] alvos = {
                    dados[0],
                    dados[tamanho / 2],
                    dados[tamanho - 1],
                    dados[idxRand1],
                    dados[idxRand2],
                    dados[idxRand3],
                    -1337
            };

            String[] nomes = { "Primeiro", "Meio", "Ultimo", "Aleat. 1", "Aleat. 2", "Aleat. 3", "Inexistente" };

            for (int i = 0; i < alvos.length; i++) {
                int alvo = alvos[i];
                long tSeq = 0, tBin = 0, tABB = 0, tAVL = 0;

                for (int r = 0; r < REPETICOES; r++) {
                    // Vetor Sequencial
                    timer.iniciar();
                    vetor.buscaSequencial(alvo);
                    tSeq += timer.parar();

                    // Vetor Binária
                    timer.iniciar();
                    vetor.pesquisaBinaria(alvo);
                    tBin += timer.parar();

                    // Arvore Binária
                    timer.iniciar();
                    abb.buscar(alvo);
                    tABB += timer.parar();

                    // Arvore AVL
                    timer.iniciar();
                    avl.buscar(alvo);
                    tAVL += timer.parar();
                }

                System.out.printf("%-8d | %-12s | %-16d | %-12d | %-10d | %-10d\n",
                        tamanho, nomes[i], (tSeq / REPETICOES), (tBin / REPETICOES), (tABB / REPETICOES),
                        (tAVL / REPETICOES));
            }
            System.out
                    .println("---------------------------------------------------------------------------------------");
        }
    }

    private static int[] obterDadosPorCenario(int tamanho, String cenario) {
        switch (cenario) {
            case "Ordenado":
                return GeradorDados.gerarOrdenado(tamanho);
            case "Inverso":
                return GeradorDados.gerarInversamenteOrdenado(tamanho);
            default:
                return GeradorDados.gerarAleatorio(tamanho);
        }
    }
}