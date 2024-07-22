// import java.util.*;


public class Account {
    private int id;
    private int customerId;
    private double balance;
    private String accountType;
    private static int counter = 1;

    public Account(int id, int customerId, double balance, String accountType) {
        this.id = counter;
        this.customerId = customerId;
        this.balance = balance;
        this.accountType = accountType;
        counter++;
    }

    public Account(int customerId, double balance, String accountType) {
        this.id = counter;
        this.customerId = customerId;
        this.balance = balance;
        this.accountType = accountType;
        counter++;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
