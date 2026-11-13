package handson4;

public class Main {
    public static void main(String[] args) {

        Pair<Integer, String> pair1 = new Pair<>(1, "Satu");
        Pair<Double, Boolean> pair2 = new Pair<>(3.14, true);

        pair1.showTypes();
        pair2.showTypes();

        System.out.println("\nSebelum ditukar:");
        pair1.displayValues();

        Pair<String, Integer> swappedPair1 = pair1.swap();
        System.out.println("Setelah ditukar:");
        swappedPair1.displayValues();
    }
}
