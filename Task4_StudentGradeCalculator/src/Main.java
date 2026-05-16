import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=================================");
        System.out.println("🎓 STUDENT GRADE CALCULATOR");
        System.out.println("=================================");
        System.out.print("Enter number of subjects: ");
        int subjects = scanner.nextInt();
        while (subjects <= 0) {
            System.out.print("Please enter a valid number of subjects: ");
            subjects = scanner.nextInt();
        }
        double totalMarks = 0;
        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks for Subject " + i + ": ");
            double marks = scanner.nextDouble();
            while (marks < 0 || marks > 100) {
                System.out.print("Invalid marks. Enter between 0 and 100: ");
                marks = scanner.nextDouble();
            }
            totalMarks += marks;
        }
        double averagePercentage = totalMarks / subjects;
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "Fail";
        }
        System.out.println("\n=================================");
        System.out.println("📋 RESULT");
        System.out.println("=================================");
        System.out.println("Total Marks        : " + totalMarks);
        System.out.println("Average Percentage : " + averagePercentage + "%");
        System.out.println("Grade              : " + grade);
        System.out.println("=================================");
        scanner.close();
    }
}