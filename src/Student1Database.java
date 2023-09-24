import java.util.ArrayList;
import java.util.List;

class Student1Database {

    private List<Student> students;

    public Student1Database(){

        students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public Student getStudentById(String studentId){

        for (Student student : students){
            if (student.getStudentId().equals(studentId)){
            return student;
        }


        }return null;

    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
}