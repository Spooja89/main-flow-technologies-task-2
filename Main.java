import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Generate Student Report");
            System.out.println("5. List All Students");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            int choice;

            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    if (choice >= 1 && choice <= 6) {
                        break;
                    }
                } else {
                    scanner.next();
                }
                System.out.print("Invalid option. Please select again: ");
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.next();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.next();
                    
                    // Input for grades
                    System.out.print("Enter number of grades: ");
                    int numGrades = scanner.nextInt();
                    for (int i = 0; i < numGrades; i++) {
                        System.out.print("Enter grade " + (i + 1) + ": ");
                        int grade = scanner.nextInt();
                        manager.addStudent(id, name);
                        manager.getStudent(id).addGrade(grade);
                    }
                    
                    // Input for attendance
                    System.out.print("Enter attendance days: ");
                    int attendanceDays = scanner.nextInt();
                    manager.getStudent(id).updateAttendance(attendanceDays);
                    
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Student ID to update: ");
                    id = scanner.next();
                    System.out.print("Enter new name: ");
                    name = scanner.next();
                    manager.updateStudent(id, name);
                    System.out.println("Student updated successfully!");
                    break;

                case 3:
                    System.out.print("Enter Student ID to delete: ");
                    id = scanner.next();
                    manager.deleteStudent(id);
                    System.out.println("Student deleted successfully!");
                    break;

                case 4:
                    System.out.print("Enter Student ID for report: ");
                    id = scanner.next();
                    manager.generateStudentReport(id);
                    break;

                case 5:  // New option to list all students
                    manager.listAllStudents();
                    break;

                case 6:
                    System.out.println("Exiting the program.");
                    System.exit(0);
            }
        }
    }
}
