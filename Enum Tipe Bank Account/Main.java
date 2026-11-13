package handson1;

public class Main {
    public static void main(String[] args) {
        for (AccountType type : AccountType.values()) {
            System.out.println("Tipe: " + type.name() + " - Deskripsi: " + type.toString());
        }
    }
}
