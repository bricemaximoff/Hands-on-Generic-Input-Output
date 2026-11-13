package handson2;

public class MainEnumConstructor {
    public static void main(String[] args) {
        for (AccountTypeWithRate type : AccountTypeWithRate.values()) {
            System.out.println("Nama: " + type.name() + 
                               " | Kode: " + type.getCode() + 
                               " | Suku Bunga: " + type.getInterestRate() + "%");
        }
    }
}