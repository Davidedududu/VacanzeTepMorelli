package morellies2;

public class Buffer {
    private int valore;
    private boolean pieno = false;

    public synchronized void metti(int numero) throws InterruptedException {
        while (pieno) wait();
        valore = numero;
        pieno = true;
        notifyAll();
    }

    public synchronized int prendi(int minimo, int massimo) throws InterruptedException {
        while (!pieno || valore < minimo || valore > massimo) wait();
        int risultato = valore;
        pieno = false;
        notifyAll();
        return risultato;
    }
}
