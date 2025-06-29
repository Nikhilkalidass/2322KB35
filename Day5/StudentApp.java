package Day5;

import java.io.*;
import java.util.*;

public class StudentApp {
    static ArrayList<String> studentNames = new ArrayList<>();
    static HashMap<String, ArrayList<String>> studentCourses = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int choice;

        do {
            System.out.println("\n=== Student Management Menu ===");
            System.out.println("1. Add Student & Courses");
            System.out.println("2. Search Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Save Courses to File (Optional)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: searchStudent(); break;
                case 3: deleteStudent(); break;
                case 4: saveToFile(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();

        studentNames.add(name);
        ArrayList<String> courses = new ArrayList<>();

        System.out.print("Enter number of courses: ");
        int count = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            System.out.print("Enter course " + (i + 1) + ": ");
            courses.add(sc.nextLine());
        }

        studentCourses.put(id, courses);
        System.out.println("Student added successfully.");
    }

    static void searchStudent() {
        System.out.print("Enter student ID to search: ");
        String id = sc.nextLine();

        if (studentCourses.containsKey(id)) {
            System.out.println("Courses for ID " + id + ":");
            for (String course : studentCourses.get(id)) {
                System.out.println("- " + course);
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        String id = sc.nextLine();

        if (studentCourses.containsKey(id)) {
            studentCourses.remove(id);
            System.out.println("Student record deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

    static void saveToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("courses_output.txt"));
            for (Map.Entry<String, ArrayList<String>> entry : studentCourses.entrySet()) {
                writer.write("ID: " + entry.getKey() + " → " + entry.getValue());
                writer.newLine();
            }
            writer.close();
            System.out.println("Courses saved to courses_output.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}

