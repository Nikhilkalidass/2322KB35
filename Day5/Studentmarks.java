package Day5;

import java.util.HashMap;
import java.util.Map;

public class Studentmarks {
    public static void main(String[] args) {
        // Create HashMap to store name → marks
        HashMap<String, Integer> marksMap = new HashMap<>();

        // Add some students and their marks
        marksMap.put("Nikhil", 85);
        marksMap.put("Anita", 90);
        marksMap.put("Ravi", 76);

        int total = 0;

        System.out.println("Student Marks:");
        for (Map.Entry<String, Integer> entry : marksMap.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
            total += entry.getValue();
        }

        // Calculate average
        double average = (double) total / marksMap.size();
        System.out.println("Average Marks: " + average);
    }
}

