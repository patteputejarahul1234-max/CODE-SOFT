import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double usdToInr = 83.12;
        double inrToUsd = 0.012;
        double usdToEur = 0.92;
        double eurToUsd = 1.08;
        double inrToEur = 0.011;
        double eurToInr = 90.45;
        System.out.println("=================================");
        System.out.println("💱 CURRENCY CONVERTER");
        System.out.println("=================================");
        System.out.println("Available Currencies:");
        System.out.println("1. USD");
        System.out.println("2. INR");
        System.out.println("3. EUR");
        System.out.print("\nSelect Base Currency: ");
        int baseChoice = scanner.nextInt();
        System.out.print("Select Target Currency: ");
        int targetChoice = scanner.nextInt();
        if (baseChoice == targetChoice) {
            System.out.println("Both currencies are same.");
            return;
        }
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        double convertedAmount = 0;
        String targetCurrency = "";
        if (baseChoice == 1 && targetChoice == 2) {
            convertedAmount = amount * usdToInr;
            targetCurrency = "INR";
        } else if (baseChoice == 1 && targetChoice == 3) {
            convertedAmount = amount * usdToEur;
            targetCurrency = "EUR";
        }
        else if (baseChoice == 2 && targetChoice == 1) {
            convertedAmount = amount * inrToUsd;
            targetCurrency = "USD";
        }
        else if (baseChoice == 2 && targetChoice == 3) {
            convertedAmount = amount * inrToEur;
            targetCurrency = "EUR";
        }
        else if (baseChoice == 3 && targetChoice == 1) {
            convertedAmount = amount * eurToUsd;
            targetCurrency = "USD";
        }
        else if (baseChoice == 3 && targetChoice == 2) {
            convertedAmount = amount * eurToInr;
            targetCurrency = "INR";
        }else {
            System.out.println("Conversion not available.");
            return;
        }
        System.out.println("\n=================================");
        System.out.println("💰 CONVERSION RESULT");
        System.out.println("=================================");
        System.out.println("Converted Amount: " + convertedAmount + " " + targetCurrency);
        System.out.println("=================================");
        scanner.close();
    }
}