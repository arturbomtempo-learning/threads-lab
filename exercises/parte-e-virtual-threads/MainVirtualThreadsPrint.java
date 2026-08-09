import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Exercicio de fixação 2: imprimir Thread.currentThread() para inspecionar o tipo real da thread
public class MainVirtualThreadsPrint {

    public static void main(String[] args) throws InterruptedException {
        int total = 5;

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < total; i++) {
                int idCliente = i;
                executor.submit(() -> {
                    Thread threadAtual = Thread.currentThread();
                    System.out.println("Cliente " + idCliente + " atendido por " + threadAtual
                            + " | isVirtual=" + threadAtual.isVirtual());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }
}
