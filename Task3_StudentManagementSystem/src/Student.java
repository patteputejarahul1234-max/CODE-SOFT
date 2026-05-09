public class Student {
    private int studentId;
    private String name;
    private int rollNumber;
    private double marks;
    private String grade;

    public Student(int studentId, String name, int rollNumber, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
        calculateGrade();
    }
    private void calculateGrade() {
        if (marks >= 90) {
            grade = "A+";
        } else if (marks >= 80) {
            grade = "A";
        } else if (marks >= 70) {
            grade = "B";
        } else if (marks >= 60) {
            grade = "C";
        } else if (marks >= 50) {
            grade = "D";
        } else {
            grade = "Fail";
        }
    }
    public int getStudentId() {
        return studentId;
    }
    public String getName() {
        return name;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public double getMarks() {
        return marks;
    }
    public String getGrade() {
        return grade;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
    public void setMarks(double marks) {
        this.marks = marks;
        calculateGrade();
    }
    public void displayStudent() {
        System.out.println("\n==============================");
        System.out.println("Student ID   : " + studentId);
        System.out.println("Name         : " + name);
        System.out.println("Roll Number  : " + rollNumber);
        System.out.println("Marks        : " + marks);
        System.out.println("Grade        : " + grade);
        System.out.println("==============================");
    }
}