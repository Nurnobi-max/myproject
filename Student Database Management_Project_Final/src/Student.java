import java.util.HashMap;
import java.util.Map;


class Student {
    private int studentId;
    private String name;
    private String department;
    private Map<String, Integer> subjectMarks;

    public Student(int studentId, String name, String department) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.subjectMarks = new HashMap<>();
    }

    public void addSubjectMark(String subject, int mark) {

        subjectMarks.put(subject, mark);
    }

    public boolean isPassed() {
        for (int mark : subjectMarks.values()) {
            if (mark < 50) {
                return false; // If any subject has a mark less than 50, the student failed.
            }
        }
        return true; // All subjects have marks greater than or equal to 50, the student passed.
    }

    // using Getter
    public int getStudentId() {

        return studentId;
    }

    public String getName() {

        return name;
    }

    public String getDepartment() {

        return department;
    }

    public Map<String, Integer> getSubjectMarks() {

        return subjectMarks;
    }
}



