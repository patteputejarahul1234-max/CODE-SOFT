import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int studentCounter = 1;

    private final String FILE_NAME = "students.txt";
    public StudentManagementSystem() {

        loadStudentsFromFile();
    }
    public void addStudent() {
        System.out.println("\n===== Add Student =====");
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        while (name.trim().isEmpty()) {
            System.out.print("Name cannot be empty. Enter again: ");
            name = scanner.nextLine();
        }
        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine();
        while (marks < 0 || marks > 100) {
            System.out.print("Invalid marks. Enter between 0 and 100: ");
            marks = scanner.nextDouble();
            scanner.nextLine();
        }
        Student student = new Student(studentCounter, name, rollNumber, marks);
        students.add(student);
        saveStudentsToFile();
        System.out.println("Student added successfully.");
        studentCounter++;
    }
    public void displayStudents() {
        System.out.println("\n===== Student Records =====");
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student student : students) {
            student.displayStudent();
        }
    }
    public void searchStudent() {
        System.out.print("\nEnter Student ID to search: ");
        int studentId = scanner.nextInt();
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                System.out.println("Student found:");
                student.displayStudent();
                return;
            }
        }
        System.out.println("Student not found.");
    }
    public void updateStudent() {
        System.out.print("\nEnter Student ID to update: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                System.out.print("Enter New Name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter New Roll Number: ");
                int newRoll = scanner.nextInt();
                System.out.print("Enter New Marks: ");
                double newMarks = scanner.nextDouble();
                student.setName(newName);
                student.setRollNumber(newRoll);
                student.setMarks(newMarks);
                saveStudentsToFile();
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }
    public void deleteStudent() {
        System.out.print("\nEnter Student ID to delete: ");
        int studentId = scanner.nextInt();
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                students.remove(student);
                saveStudentsToFile();
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }
    private void saveStudentsToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            for (Student student : students) {
                writer.write(
                    student.getStudentId() + "," +
                    student.getName() + "," +
                    student.getRollNumber() + "," +
                    student.getMarks()
                );
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving student data.");
        }
    }
    private void loadStudentsFromFile() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                return;
            }
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int roll = Integer.parseInt(data[2]);
                double marks = Double.parseDouble(data[3]);
                Student student = new Student(id, name, roll, marks);
                students.add(student);
                if (id >= studentCounter) {
                    studentCounter = id + 1;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading student data.");
        }
    }
}