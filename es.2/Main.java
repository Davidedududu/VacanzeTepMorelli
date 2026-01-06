package morellies2;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        new Produttore(buffer).start();
        new Consumatore(buffer, 1, 5).start();
        new Consumatore(buffer, 6, 10).start();
    }
}
