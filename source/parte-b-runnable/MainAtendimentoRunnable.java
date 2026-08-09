public class MainAtendimentoRunnable {

    public static void main(String[] args) throws InterruptedException {
        int totalClientes = 5;

        long tempoInicial = System.currentTimeMillis();

        Thread[] atendentes = new Thread[totalClientes];
        for (int i = 0; i < totalClientes; i++) {
            Runnable tarefa = new AtendimentoRunnable(i);
            atendentes[i] = new Thread(tarefa, "Atendente-" + i);
        }

        for (Thread atendente : atendentes) {
            atendente.start();
        }

        for (Thread atendente : atendentes) {
            atendente.join();
        }

        long tempoTotal = System.currentTimeMillis() - tempoInicial;
        System.out.println("Todos os atendimentos foram concluidos.");
        System.out.println("Tempo total: " + tempoTotal + "ms");
    }
}
