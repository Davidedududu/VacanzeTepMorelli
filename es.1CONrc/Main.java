package morellies1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("inserisci M: ");
        int M = scanner.nextInt();
        System.out.print("inserisci N: ");
        int N = scanner.nextInt();

        Counter counter = new Counter();
        ThreadCounter[] threads = new ThreadCounter[M];

        for (int i = 0; i < M; i++) {
            threads[i] = new ThreadCounter(counter, N);
            threads[i].start();
        }

        int totalExpected = 0;
        for (int i = 0; i < M; i++) {
            threads[i].join();
            int executed = threads[i].getExecuted();
            System.out.println("thread " + i + " ha eseguito: " + executed);
            totalExpected += executed;
        }

        System.out.println("valore atteso: " + totalExpected);
        System.out.println("valore reale del contatore: " + counter.getCount());
    }
}
