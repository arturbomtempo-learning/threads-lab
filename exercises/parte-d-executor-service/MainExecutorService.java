import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainExecutorService {

    public static void main(String[] args) throws InterruptedException {
        int totalClientes = 10;

        long tempoInicial = System.currentTimeMillis();

        ExecutorService pool = Executors.newFixedThreadPool(4);

        for (int i = 0; i < totalClientes; i++) {
            int idCliente = i;
            pool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " atendendo cliente " + idCliente);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);

        long tempoTotal = System.currentTimeMillis() - tempoInicial;
        System.out.println("Todos os atendimentos foram concluidos.");
        System.out.println("Tempo total: " + tempoTotal + "ms");
    }
}
