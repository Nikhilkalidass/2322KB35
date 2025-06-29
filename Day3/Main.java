package Day3;

//Person class
class Person {
 String name;
 int age;
}

//Employee class extends Person
class Employee extends Person {
 double salary;

 // Method to calculate salary with bonus
 double calculateSalary(double bonus) {
     return salary + bonus;
 }
}

//Main class to run the program
public class Main {
 public static void main(String[] args) {
     // Create an Employee object
     Employee emp = new Employee();
     emp.name = "Nikhil";
     emp.age = 25;
     emp.salary = 30000;

     // Calculate salary
     double totalSalary = emp.calculateSalary(5000); // Bonus ₹5000

     // Print details
     System.out.println("Name: " + emp.name);
     System.out.println("Age: " + emp.age);
     System.out.println("Basic Salary: ₹" + emp.salary);
     System.out.println("Total Salary (with bonus): ₹" + totalSalary);
 }
}
