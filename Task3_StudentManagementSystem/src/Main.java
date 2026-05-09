import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=================================");
            System.out.println("🎓 STUDENT MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    system.addStudent();
                    break;

                case 2:
                    system.displayStudents();
                    break;

                case 3:
                    system.searchStudent();
                    break;

                case 4:
                    system.updateStudent();
                    break;

                case 5:
                    system.deleteStudent();
                    break;

                case 6:
                    System.out.println("Exiting Student Management System...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
        scanner.close();
    }
}