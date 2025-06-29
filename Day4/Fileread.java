package Day4;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fileread {
    public static void main(String[] args) {
        try {
            File file = new File("sample.txt"); // The file to read
            Scanner reader = new Scanner(file);

            System.out.println("File content:");

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line); // Display each line
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
}

