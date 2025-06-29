package Day2;

import java.util.Scanner;

public class StringAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept sentence
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        // Split into words
        String[] words = sentence.trim().split("\\s+");

        // Word count
        int wordCount = words.length;

        // Character count (excluding spaces)
        int charCount = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) != ' ') {
                charCount++;
            }
        }

        // Reverse the sentence
        String reversed = "";
        for (int i = sentence.length() - 1; i >= 0; i--) {
            reversed += sentence.charAt(i);
        }

        // Find longest word
        String longestWord = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > longestWord.length()) {
                longestWord = words[i];
            }
        }

        // Display results
        System.out.println("\n--- String Analysis ---");
        System.out.println("Original Sentence: " + sentence);
        System.out.println("Word Count       : " + wordCount);
        System.out.println("Character Count  : " + charCount);
        System.out.println("Reversed Sentence: " + reversed);
        System.out.println("Longest Word     : " + longestWord);

        sc.close();
    }
}
