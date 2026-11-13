package handson3;

public class Main {
    public static void main(String[] args) {
        Cell<Integer> intCell = new Cell<>();
        intCell.setValue(100);
        System.out.println("Isi data: " + intCell.getValue());
        intCell.displayType();

        System.out.println("--------------------");

        Cell<String> stringCell = new Cell<>();
        stringCell.setValue("Pemrograman Java");
        System.out.println("Isi data: " + stringCell.getValue());
        stringCell.displayType();
    }
}
