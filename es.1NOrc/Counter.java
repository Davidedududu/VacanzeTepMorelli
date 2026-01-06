package morellies1ma2;

public class Counter {
    private int count = 0;

    public synchronized void next() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
