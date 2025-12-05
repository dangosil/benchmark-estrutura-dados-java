package util;

public class TempoExecucao {
    private long inicio;

    // Inicia o cronômetro
    public void iniciar() {
        this.inicio = System.nanoTime();
    }

    // devolve o tempo passado
    public long parar() {
        return System.nanoTime() - this.inicio;
    }

    public double converterParaMs(long nanosegundos) {
        return nanosegundos / 1_000_000.0;
    }
}
