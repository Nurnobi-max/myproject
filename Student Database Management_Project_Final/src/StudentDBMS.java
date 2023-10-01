import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class StudentDBMS {
    private Map<Integer, Student> studentDatabase;
    private Map<String, Department> departments;

    public StudentDBMS() {
        this.studentDatabase = new HashMap<>();
        this.departments = new HashMap<>();
    }

    public void addStudent(int studentId, String name, String department) {
        if (!studentDatabase.containsKey(studentId)) {
            Student student = new Student(studentId, name, department);
            studentDatabase.put(studentId, student);

            if (!departments.containsKey(department)) {
                departments.put(department, new Department(department));
            }

            Department dept = departments.get(department);
            dept.addStudent(student);
        } else {
            System.out.println("Student with ID " + studentId + " already exist.");
        }
    }

    public void addSubjectMark(int studentId, String subject, int mark) {
        Student student = studentDatabase.get(studentId);
        if (student != null) {
            student.addSubjectMark(subject, mark);
        } else {
            System.out.println("Student with ID " + studentId + " does not exist.");
        }
    }

    public void displayStudentInfo(int studentId) {
        Student student = studentDatabase.get(studentId);
        if (student != null) {
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Name: " + student.getName());
            System.out.println("Department: " + student.getDepartment());
            System.out.println("Subjects & Marks & Result:");
            for (Map.Entry<String, Integer> entry : student.getSubjectMarks().entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("Result: " + (student.isPassed() ? "Passed" : "Failed"));
        } else {
            System.out.println("Student with ID " + studentId + " does not exist.");
        }
    }

    public void displayStudentsByDepartment(String department) {
        if (departments.containsKey(department)) {
            List<Student> students = departments.get(department).getStudents();
            System.out.println("Students in Department " + department + ":");
            for (Student student : students) {
                System.out.println(student.getName() + " (ID: " + student.getStudentId() + ")");
            }
        } else {
            System.out.println("Department " + department + " does not exist.");
        }
    }

    public static void main(String[] args) {
        StudentDBMS dbms = new StudentDBMS();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Database Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Add Subject Mark");
            System.out.println("3. Display Student Info");
            System.out.println("4. Display Students by Department");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    dbms.addStudent(studentId, name, department);
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Subject: ");
                    String subject = scanner.nextLine();
                    System.out.print("Enter Mark: ");
                    int mark = scanner.nextInt();
                    dbms.addSubjectMark(id, subject, mark);
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    int idToShow = scanner.nextInt();
                    dbms.displayStudentInfo(idToShow);
                    break;
                case 4:
                    System.out.print("Enter Department: ");
                    String deptToShow = scanner.nextLine();
                    dbms.displayStudentsByDepartment(deptToShow);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

