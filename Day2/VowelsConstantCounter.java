package Day2;

import java.util.Scanner;

public class VowelsConstantCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Convert to lowercase
        str = str.toLowerCase();

        int vowels = 0;
        int consonants = 0;

        // Loop through each character
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Check if it's a letter
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        // Display results
        System.out.println("Vowels     : " + vowels);
        System.out.println("Consonants : " + consonants);

        sc.close();
    }
}
