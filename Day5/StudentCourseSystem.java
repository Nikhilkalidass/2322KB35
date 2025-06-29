package Day5;

import java.util.*;

public class StudentCourseSystem {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        HashMap<String, ArrayList<String>> studentCourses = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Course Enrollment System ---");
            System.out.println("1. Add Student with Courses");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students and Courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter student name: ");
                String name = sc.nextLine();
                students.add(name);

                ArrayList<String> courses = new ArrayList<>();
                System.out.print("How many courses to enroll: ");
                int count = sc.nextInt();
                sc.nextLine();

                for (int i = 0; i < count; i++) {
                    System.out.print("Enter course " + (i + 1) + ": ");
                    courses.add(sc.nextLine());
                }

                studentCourses.put(name, courses);
                System.out.println("Student added with courses.");
            }

            else if (choice == 2) {
                System.out.print("Enter student name to remove: ");
                String name = sc.nextLine();
                if (students.remove(name)) {
                    studentCourses.remove(name);
                    System.out.println("Student removed.");
                } else {
                    System.out.println("Student not found.");
                }
            }

            else if (choice == 3) {
                System.out.println("\nStudent and Enrolled Courses:");
                Iterator<String> it = students.iterator();
                while (it.hasNext()) {
                    String student = it.next();
                    System.out.println("Student: " + student);
                    ArrayList<String> courses = studentCourses.get(student);

                    Iterator<String> courseIt = courses.iterator();
                    while (courseIt.hasNext()) {
                        System.out.println(" - " + courseIt.next());
                    }
                }
            }

        } while (choice != 4);

        System.out.println("Exited.");
        sc.close();
    }
}
