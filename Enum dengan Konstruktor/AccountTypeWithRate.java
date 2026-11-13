package handson2;

public enum AccountTypeWithRate {
    SAVINGS("SA", 1.5), 
    CREDIT("CR", 15.0),
    DEPOSIT("DP", 5.0);

    private String code;
    private double interestRate;

    // Konstruktor dengan 2 parameter
    private AccountTypeWithRate(String code, double interestRate) { 
        this.code = code; 
        this.interestRate = interestRate;
    }

    public String getCode() { return code; }
    public double getInterestRate() { return interestRate; }
}
