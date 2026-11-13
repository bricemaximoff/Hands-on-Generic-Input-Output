package handson1;

public enum AccountType {
    SAVINGS {
        @Override
        public String toString() {
            return "Akun Tabungan Biasa";
        }
    }, 
    CREDIT {
        @Override
        public String toString() {
            return "Akun Kredit/Pinjaman";
        }
    }, 
    DEPOSIT {
        @Override
        public String toString() {
            return "Akun Deposito Berjangka";
        }
    }
}
