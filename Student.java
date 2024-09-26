import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private List<Integer> grades;
    private int attendance;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new ArrayList<>();
        this.attendance = 0;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<Integer> getGrades() { return grades; }
    public int getAttendance() { return attendance; }

    public void setName(String name) {
        this.name = name;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public void updateAttendance(int days) {
        attendance += days; // Increment attendance by the given number of days
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return (double) total / grades.size();
    }
}
