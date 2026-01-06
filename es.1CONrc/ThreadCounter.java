package morellies1;

import java.util.Random;

public class ThreadCounter extends Thread {
    private Counter counter;
    private int n;
    private int executed;

    public ThreadCounter(Counter counter, int n) {
        this.counter = counter;
        this.n = n;
    }

    public int getExecuted() {
        return executed;
    }

    @Override
    public void run() {
        Random rand = new Random();
        executed = rand.nextInt(n / 2, n + 1);
        for (int i = 0; i < executed; i++) {
            counter.next();
        }
    }
}
