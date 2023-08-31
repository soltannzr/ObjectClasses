package BoxingGame;

public class Main {
    public static void main(String[] args) {
        Fighter f1 = new Fighter("Ali", 20, 100, 90, 40);
        Fighter f2 = new Fighter("Tyson", 30, 100, 90, 30);
        Match m = new Match(f1, f2, 50, 90);
        m.run();
    }
}
