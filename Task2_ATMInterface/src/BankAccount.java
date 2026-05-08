public class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("\nTransaction Successful");
            System.out.println("Deposited Amount: ₹" + amount);
            System.out.println("Available Balance: ₹" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("\nTransaction Successful");
            System.out.println("Withdrawn Amount: ₹" + amount);
            System.out.println("Available Balance: ₹" + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }
    public double getBalance() {
        return balance;
    }
}