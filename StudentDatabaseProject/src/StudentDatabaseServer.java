import java.util.List;
import java.util.Scanner;

public class StudentDatabaseServer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDatabase database = new StudentDatabase();

        while (true) {
            System.out.println("Student Database Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Get Student by ID");
            System.out.println("3. List All Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Student student = new Student(studentId, name, age);
                    database.addStudent(student);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Student ID to retrieve: ");
                    String idToRetrieve = scanner.nextLine();
                    Student retrievedStudent = database.getStudentById(idToRetrieve);
                    if (retrievedStudent != null) {
                        System.out.println("Student Information:");
                        System.out.println(retrievedStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    List<Student> allStudents = database.getAllStudents();
                    System.out.println("All Students:");
                    for (Student s : allStudents) {
                        System.out.println(s);
                    }
                    break;

                case 4:
                    System.out.println("Exiting Student Database System.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
