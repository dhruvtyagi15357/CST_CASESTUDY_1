import java.util.*;

public class BankingSystem {
    private HashMap<Integer, Account> accounts = new HashMap<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private int transactionCounter = 0;

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
        System.out.println("Account added: " + account);
    }

    public void removeAccount(int accountId) {
        if (accounts.containsKey(accountId)) {
            accounts.remove(accountId);
            System.out.println("Account removed: " + accountId);
        } else {
            System.out.println("Account not found: " + accountId);
        }
    }

    public void updateAccount(int accountId, Account updatedAccount) {
        if (accounts.containsKey(accountId)) {
            accounts.put(accountId, updatedAccount);
            System.out.println("Account updated: " + updatedAccount);
        } else {
            System.out.println("Account not found: " + accountId);
        }
    }

    public void depositFunds(int accountId, double amount) {
        if (accounts.containsKey(accountId)) {
            Account account = accounts.get(accountId);
            account.setBalance(account.getBalance() + amount);
            transactions.add(new Transaction(++transactionCounter, accountId, "Deposit", amount, new Date()));
            System.out.println("Funds deposited: " + amount + " to account " + accountId);
        } else {
            System.out.println("Account not found: " + accountId);
        }
    }

    public void withdrawFunds(int accountId, double amount) {
        if (accounts.containsKey(accountId)) {
            Account account = accounts.get(accountId);
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                transactions.add(new Transaction(++transactionCounter, accountId, "Withdrawal", amount, new Date()));
                System.out.println("Funds withdrawn: " + amount + " from account " + accountId);
            } else {
                System.out.println("Insufficient balance: " + accountId);
            }
        } else {
            System.out.println("Account not found: " + accountId);
        }
    }

    public void transferFunds(int fromAccountId, int toAccountId, double amount) {
        if (accounts.containsKey(fromAccountId) && accounts.containsKey(toAccountId)) {
            Account fromAccount = accounts.get(fromAccountId);
            Account toAccount = accounts.get(toAccountId);
            if (fromAccount.getBalance() >= amount) {
                fromAccount.setBalance(fromAccount.getBalance() - amount);
                toAccount.setBalance(toAccount.getBalance() + amount);
                transactions
                        .add(new Transaction(++transactionCounter, fromAccountId, "Transfer Out", amount, new Date()));
                transactions.add(new Transaction(++transactionCounter, toAccountId, "Transfer In", amount, new Date()));
                System.out.println("Funds transferred: " + amount + " from account " + fromAccountId + " to account "
                        + toAccountId);
            } else {
                System.out.println("Insufficient balance in account: " + fromAccountId);
            }
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    public void printAllAccounts() {
        System.out.println("All accounts:");
        for (Account account : accounts.values()) {
            System.out.println(account);
        }
    }

    public static void main(String[] args) {
        BankingSystem system = new BankingSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Account");
            System.out.println("2. Remove Account");
            System.out.println("3. Update Account");
            System.out.println("4. Deposit Funds");
            System.out.println("5. Withdraw Funds");
            System.out.println("6. Transfer Funds");
            System.out.println("7. Print All Accounts");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer ID: ");
                    int customerId = scanner.nextInt();
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextDouble();
                    System.out.print("Enter account type: ");
                    String accountType = scanner.next();
                    system.addAccount(new Account(customerId, balance, accountType));
                    break;
                case 2:
                    System.out.print("Enter account ID to remove: ");
                    int removeId = scanner.nextInt();
                    system.removeAccount(removeId);
                    break;
                case 3:
                    System.out.print("Enter account ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new balance: ");
                    double newBalance = scanner.nextDouble();
                    System.out.print("Enter new account type: ");
                    String newAccountType = scanner.next();
                    system.updateAccount(updateId, new Account(updateId, system.accounts.get(updateId).getCustomerId(),
                            newBalance, newAccountType));
                    break;
                case 4:
                    System.out.print("Enter account ID to deposit to: ");
                    int depositId = scanner.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    system.depositFunds(depositId, depositAmount);
                    break;
                case 5:
                    System.out.print("Enter account ID to withdraw from: ");
                    int withdrawId = scanner.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    system.withdrawFunds(withdrawId, withdrawAmount);
                    break;
                case 6:
                    System.out.print("Enter source account ID: ");
                    int fromAccountId = scanner.nextInt();
                    System.out.print("Enter destination account ID: ");
                    int toAccountId = scanner.nextInt();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    system.transferFunds(fromAccountId, toAccountId, transferAmount);
                    break;
                
                case 7:
                    system.printAllAccounts();
                    break;

                case 8:
                    System.out.println("Exiting system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);
        scanner.close();
    }
}
