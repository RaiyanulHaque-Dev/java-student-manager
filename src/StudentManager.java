import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", CGPA: " + cgpa);
    }
}

public class StudentManager {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = input.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    System.out.println("Exiting program...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void showMenu() {
        System.out.println("\n--- Student Manager ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Enter Name: ");
        String name = input.nextLine();

        System.out.print("Enter CGPA: ");
        double cgpa = input.nextDouble();

        students.add(new Student(id, name, cgpa));
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    static void searchStudent() {
        System.out.print("Enter student ID to search: ");
        int id = input.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                s.display();
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = input.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                students.remove(s);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
