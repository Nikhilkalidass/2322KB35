package Day1;

import java.util.Scanner;

public class SimpleGrading {

    // This function gives grade
    public static String getGrade(int marks) {
        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else if (marks >= 40) {
            return "E";
        } else {
            return "Fail";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter your marks (out of 100): ");
        int marks = sc.nextInt();

        // Getting grade
        String grade = getGrade(marks);

        // Printing result
        System.out.println("Your Grade is: " + grade);
    
    sc.close();
    }
    
}

