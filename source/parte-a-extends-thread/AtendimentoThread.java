public class AtendimentoThread extends Thread {

    private final int idCliente;

    public AtendimentoThread(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public void run() {
        System.out.println(getName() + " atendendo cliente " + idCliente);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getName() + " terminou o atendimento do cliente " + idCliente);
    }
}
