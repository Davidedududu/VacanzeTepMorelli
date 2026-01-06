package morellies2;

public class Consumatore extends Thread {
    private Buffer buffer;
    private int minimo, massimo;

    public Consumatore(Buffer buffer, int minimo, int massimo) {
        this.buffer = buffer;
        this.minimo = minimo;
        this.massimo = massimo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int numero = buffer.prendi(minimo, massimo);
                System.out.println("Consumatore [" + minimo + "-" + massimo + "] ha preso: " + numero);
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
    }
}
