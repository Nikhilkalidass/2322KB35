package Day3;



//Student class
class Student {
String name;
int rollNumber;
int marks;

// Method to set student data
void setDetails(String studentName, int roll, int studentMarks) {
   name = studentName;
   rollNumber = roll;
   marks = studentMarks;
}

// Method to display student result
void displayResult() {
   System.out.println("Student Name: " + name);
   System.out.println("Roll Number: " + rollNumber);
   System.out.println("Marks: " + marks);
   
   // Display result
   if (marks >= 35) {
       System.out.println("Result: Pass");
   } else {
       System.out.println("Result: Fail");
   }
}
}

//Main class
public class Studentcal {
public static void main(String[] args) {
   // Create student object
   Student student1 = new Student();

   // Set student data
   student1.setDetails("Nikhil", 101, 78);

   // Display result
   student1.displayResult();
}
}
