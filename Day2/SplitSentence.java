package Day2;

import java.util.Scanner;

public class SplitSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept sentence from user
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        // Trim and split sentence into words (handles multiple spaces)
        String[] words = sentence.trim().split("\\s+");

        // Display each word
        System.out.println("\nThe words in the sentence are:");
        for(String word : words) {
            System.out.println(word);
        }

        // Display word count
        System.out.println("\nTotal number of words: " + words.length);

        sc.close();
    }
}


