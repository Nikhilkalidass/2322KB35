package Day4;

import java.io.*;
import java.util.Scanner;

public class ResultProcessor {
    public static void main(String[] args) {
        try {
            // Step 1: Read from marks.txt
            File inputFile = new File("marks.txt");
            Scanner sc = new Scanner(inputFile);

            // Step 2: Prepare to write to result.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"));

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(" ");

                String name = data[0];
                int m1 = Integer.parseInt(data[1]);
                int m2 = Integer.parseInt(data[2]);
                int m3 = Integer.parseInt(data[3]);

                int total = m1 + m2 + m3;
                String result = (m1 >= 35 && m2 >= 35 && m3 >= 35) ? "Pass" : "Fail";

                String outputLine = name + " Total: " + total + " Result: " + result;

                // Write to result.txt
                writer.write(outputLine);
                writer.newLine();
            }

            // Close everything
            writer.close();
            sc.close();

            System.out.println("Results processed and written to result.txt");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
