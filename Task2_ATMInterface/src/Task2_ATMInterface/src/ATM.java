import java.util.Scanner;

public class ATM {

    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void start() {

        int choice;

        do {

            System.out.println("\n==============================");
            System.out.println("🏧 ATM MENU");
            System.out.println("==============================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
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
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }

    private void checkBalance() {

        System.out.println("Current Balance: ₹" + account.getBalance());
    }

    private void depositMoney() {

        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();

        account.deposit(amount);
    }

    private void withdrawMoney() {

        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();

        account.withdraw(amount);
    }
}
