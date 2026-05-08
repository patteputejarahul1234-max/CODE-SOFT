import java.util.ArrayList;
import java.util.Scanner;
public class ATM {
    private BankAccount account;
    private Scanner scanner;
    private final int ATM_PIN = 1234;
    private ArrayList<String> transactions = new ArrayList<>();
    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }
    public void start() {
        boolean pinVerified = false;
        for (int attempts = 1; attempts <= 3; attempts++) {
            System.out.print("Enter ATM PIN: ");
            int enteredPin = scanner.nextInt();
        if (enteredPin == ATM_PIN) {
            pinVerified = true;
            break;
        } else {
            System.out.println("Incorrect PIN.");
        if (attempts < 3) {
            System.out.println("Attempts remaining: " + (3 - attempts));
        }
    }
}
        if (!pinVerified) {
            System.out.println("Too many incorrect attempts.");
            System.out.println("ATM access blocked.");
            return;
        }
        int choice;
        do {
            System.out.println("\n==============================");
            System.out.println("🏧 ATM MENU");
            System.out.println("==============================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    showTransactions();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
    private void checkBalance() {
        System.out.println("Current Balance: ₹" + account.getBalance());
    }
    private void depositMoney() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        transactions.add("Deposited ₹" + amount);
    }
    private void withdrawMoney() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
        transactions.add("Withdrawn ₹" + amount);
    }
    private void showTransactions() {
        System.out.println("\n===== Transaction History =====");
        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }
}