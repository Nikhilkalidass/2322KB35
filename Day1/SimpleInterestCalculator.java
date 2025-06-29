package Day1;
import java.util.Scanner;

public class SimpleInterestCalculator {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	
	System.out.println("Enter Principal amount:");
	double principal=sc.nextDouble();
	
	System.out.println("Enter Rate of interest(per year):");
	double rate=sc.nextDouble();
	
	System.out.println("Enter time (In years):");
	double time =sc.nextDouble();
	
	if(principal>0 && rate>0 && time>0) {
		double simpleinterest=(principal * rate * time)/100;
		System.out.println("Simple interest="+simpleinterest);
		
	}
	else {
		System.out.println("Please enter valid(positive) values");
	}
	
	sc.close();









}
}
