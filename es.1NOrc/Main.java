package morellies1ma2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci M (numero thread): ");
        int M = scanner.nextInt();

        System.out.print("Inserisci N (numero operazioni per thread): ");
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
            System.out.println("Thread " + i + " ha eseguito: " + executed);
            totalExpected += executed;
        }

        System.out.println("Valore atteso: " + totalExpected);
        System.out.println("Valore reale del contatore: " + counter.getCount());
    }
}

