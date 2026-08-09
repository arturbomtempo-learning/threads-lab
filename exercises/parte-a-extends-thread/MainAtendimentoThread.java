public class MainAtendimentoThread {

    public static void main(String[] args) throws InterruptedException {
        int totalClientes = 5;

        long tempoInicial = System.currentTimeMillis();

        AtendimentoThread[] atendimentos = new AtendimentoThread[totalClientes];
        for (int i = 0; i < totalClientes; i++) {
            atendimentos[i] = new AtendimentoThread(i);
            atendimentos[i].setName("Atendente-" + i);
        }

        for (AtendimentoThread atendimento : atendimentos) {
            atendimento.start();
        }

        for (AtendimentoThread atendimento : atendimentos) {
            atendimento.join();
        }

        long tempoTotal = System.currentTimeMillis() - tempoInicial;
        System.out.println("Todos os atendimentos foram concluidos.");
        System.out.println("Tempo total: " + tempoTotal + "ms");
    }
}
