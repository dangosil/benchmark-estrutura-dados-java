# Análise de Desempenho de Estruturas de Dados em Java

Este projeto implementa e compara o desempenho de diferentes estruturas de dados (**Vetor**, **Árvore Binária de Busca** e **Árvore AVL**) e algoritmos de ordenação (**Selection Sort** e **QuickSort**).

O objetivo é analisar o comportamento dessas estruturas em cenários de inserção, busca e ordenação com diferentes volumes de dados (100, 1.000 e 10.000 elementos).

## 📂 Estrutura do Projeto

O código está organizado nos seguintes pacotes:

* `estruturas/`: Implementação das estruturas de dados (`Vetor`, `ArvoreBinaria`, `ArvoreAVL`).
* `ordenacao/`: Algoritmos de ordenação (`SelectionSort`, `QuickSort`).
* `util/`: Classes auxiliares para geração de dados (`GeradorDados`) e medição de tempo (`TempoExecucao`).
* `Benchmark.java`: Classe principal que executa as baterias de testes.

## 🚀 Como Executar

Certifique-se de ter o Java (JDK) instalado.

1.  **Compilar:**
    Abra o terminal na pasta raiz do projeto e execute:
    ```bash
    javac Benchmark.java
    ```

2.  **Executar:**
    Após a compilação, inicie o benchmark:
    ```bash
    java Benchmark
    ```

## 📊 Resultados do Benchmark

Abaixo estão os resultados obtidos na última execução dos testes (tempos em nanosegundos):

```text
>>> 1. TEMPO DE INSERCAO (Medio de 5 execucoes) <<<
Qtd      | Cenario    | Vetor (ns)   | ABB (ns)     | AVL (ns)     
--------------------------------------------------------------------------
100      | Aleatorio  | 8260         | 73480        | 110560       
100      | Ordenado   | 6640         | 28880        | 32400        
100      | Inverso    | 7420         | 34840        | 36940        
--------------------------------------------------------------------------
1000     | Aleatorio  | 64240        | 108060       | 300520       
1000     | Ordenado   | 47500        | 1096660      | 140520       
1000     | Inverso    | 28520        | 1449900      | 71620        
--------------------------------------------------------------------------
10000    | Aleatorio  | 182020       | 785240       | 978780       
10000    | Ordenado   | 41020        | 105314040    | 640720       
10000    | Inverso    | 25660        | 154659180    | 626420       
--------------------------------------------------------------------------


>>> 2. TESTES DE ORDENACAO (Selection vs QuickSort) <<<
Tamanho    | Cenario      | Selection(ns)   | QuickSort(ns)  
----------------------------------------------------------------------
100        | Aleatorio    | 215420          | 59300          
100        | Ordenado     | 211860          | 70680          
100        | Inverso      | 174660          | 22500          
----------------------------------------------------------------------
1000       | Aleatorio    | 1294520         | 51520          
1000       | Ordenado     | 443620          | 352060         
1000       | Inverso      | 307760          | 315700         
----------------------------------------------------------------------
10000      | Aleatorio    | 25209340        | 413920         
10000      | Ordenado     | 24508820        | 33175760       
10000      | Inverso      | 28516120        | 22383420       
----------------------------------------------------------------------


>>> 3. TESTES DE BUSCA (Vetor vs ABB vs AVL) <<<
Qtd      | Alvo         | Vet(Sequencial)  | Vet(Binaria) | ABB        | AVL        
---------------------------------------------------------------------------------------
100      | Primeiro     | 520              | 520          | 440        | 520        
100      | Meio         | 920              | 340          | 3500       | 320        
100      | Ultimo       | 2260             | 380          | 2100       | 120        
100      | Aleat. 1     | 1920             | 280          | 760        | 1160       
100      | Aleat. 2     | 320              | 340          | 140        | 120        
100      | Aleat. 3     | 1200             | 420          | 480        | 120        
100      | Inexistente  | 1720             | 340          | 100        | 120        
---------------------------------------------------------------------------------------
1000     | Primeiro     | 60               | 340          | 60         | 120        
1000     | Meio         | 6420             | 380          | 2420       | 160        
1000     | Ultimo       | 13280            | 380          | 7460       | 140        
1000     | Aleat. 1     | 7740             | 360          | 2380       | 120        
1000     | Aleat. 2     | 3740             | 380          | 1200       | 120        
1000     | Aleat. 3     | 12160            | 300          | 3860       | 240        
1000     | Inexistente  | 13180            | 360          | 100        | 140        
---------------------------------------------------------------------------------------
10000    | Primeiro     | 280              | 500          | 720        | 2260       
10000    | Meio         | 65120            | 540          | 10820      | 720        
10000    | Ultimo       | 71380            | 540          | 17480      | 180        
10000    | Aleat. 1     | 17940            | 600          | 14820      | 220        
10000    | Aleat. 2     | 22700            | 740          | 17580      | 240        
10000    | Aleat. 3     | 7900             | 500          | 8120       | 140        
10000    | Inexistente  | 16780            | 420          | 120        | 220        
---------------------------------------------------------------------------------------
