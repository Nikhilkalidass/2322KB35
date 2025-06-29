package Day4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Filewrite {
    public static void main(String[] args) {
        try {
            // Create a FileWriter with the file name
            FileWriter fileWriter = new FileWriter("sample.txt");

            // Wrap it with BufferedWriter for better performance
            BufferedWriter writer = new BufferedWriter(fileWriter);

            // Write lines to the file
            writer.write("Hello, this is the first line.");
            writer.newLine();  // Adds a new line
            writer.write("This is the second line.");
            writer.newLine();
            writer.write("This is the third line.");

            // Close the writer
            writer.close();

            System.out.println("Data written to file successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }
}
