import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainVirtualThreads {

    public static void main(String[] args) throws InterruptedException {
        int total = 100_000;

        long tempoInicial = System.currentTimeMillis();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < total; i++) {
                executor.submit(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
        
        long tempoTotal = System.currentTimeMillis() - tempoInicial;
        System.out.println(total + " atendimentos concluidos com Virtual Threads em " + tempoTotal + "ms");
    }
}
