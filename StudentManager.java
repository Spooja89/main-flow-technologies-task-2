import java.util.HashMap;
import java.util.Map;

public class StudentManager {
    private Map<String, Student> studentMap;

    public StudentManager() {
        this.studentMap = new HashMap<>();
    }

    public void addStudent(String id, String name) {
        studentMap.put(id, new Student(id, name));
    }

    public void updateStudent(String id, String name) {
        Student student = studentMap.get(id);
        if (student != null) {
            student.setName(name);
        }
    }

    public void deleteStudent(String id) {
        studentMap.remove(id);
    }

    public Student getStudent(String id) {
        return studentMap.get(id);
    }

    public void generateStudentReport(String id) {
        Student student = studentMap.get(id);
        if (student != null) {
            System.out.println("Student Report for " + student.getName());
            System.out.println("Grades: " + student.getGrades());
            System.out.println("Average Grade: " + student.getAverageGrade());
            System.out.println("Attendance: " + student.getAttendance() + " days");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void listAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        
        System.out.println("\n--- List of Students ---");
        for (Student student : studentMap.values()) {
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Grades: " + student.getGrades());
            System.out.println("Average Grade: " + student.getAverageGrade());
            System.out.println("Attendance: " + student.getAttendance() + " days");
            System.out.println("------------------------------");
        }
    }
}
