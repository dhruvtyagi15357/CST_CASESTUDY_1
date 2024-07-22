import java.util.Date;

public class Transaction {
    private int id;
    private int accountId;
    private String transactionType;
    private double amount;
    private Date transactionDate;
    private static int counter = 1;

    public Transaction(int id, int accountId, String transactionType, double amount, Date transactionDate) {
        this.id = counter;
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        counter++;
    }

    public int getId() {
        return id;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
