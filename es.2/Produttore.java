package morellies2;

import java.util.Random;

public class Produttore extends Thread {
    private Buffer buffer;
    private Random casuale = new Random();

    public Produttore(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            int numero = casuale.nextInt(10) + 1;
            try {
                buffer.metti(numero);
                System.out.println("produttore ha generato: " + numero);
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
    }
}
