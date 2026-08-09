public class AtendimentoRunnable implements Runnable {

    private final int idCliente;

    public AtendimentoRunnable(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " atendendo cliente " + idCliente);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " terminou o atendimento do cliente " + idCliente);
    }
}
