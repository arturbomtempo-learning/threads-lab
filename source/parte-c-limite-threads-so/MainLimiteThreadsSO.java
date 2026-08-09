// Parte C - custo real de criar muitas threads nativas do Sistema Operacional
public class MainLimiteThreadsSO {

    public static void main(String[] args) throws InterruptedException {
        int total = 10_000;

        long tempoInicial = System.currentTimeMillis();

        Thread[] threads = new Thread[total];
        for (int i = 0; i < total; i++) {
            threads[i] = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long tempoTotal = System.currentTimeMillis() - tempoInicial;
        System.out.println(total + " threads de SO criadas e finalizadas em " + tempoTotal + "ms");
    }
}
