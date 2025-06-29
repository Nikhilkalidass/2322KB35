package Day5;

import java.util.ArrayList;
import java.util.Iterator;

// Student class
class Student {
    String name;
    int roll;

    Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }
}

// Main class
public class StudentList {
    public static void main(String[] args) {
        // Create ArrayList of Students
        ArrayList<Student> students = new ArrayList<>();

        // Add students
        students.add(new Student("Nikhil", 101));
        students.add(new Student("Anita", 102));
        students.add(new Student("Ravi", 103));

        // Use Iterator to display student details
        System.out.println("Student List:");
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            System.out.println("Name: " + s.name + ", Roll: " + s.roll);
        }
    }
}

