package Strings_And_Simple_Logics;

import java.util.Scanner;

public class Length_of_Last_Word {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();

        // Remove trailing spaces
        sentence = sentence.trim();

        // Split words by spaces
        String[] words = sentence.split("\\s+"); // \\s+ matches 1 or more spaces

        // Last word
        String lastWord = words[words.length - 1];

        System.out.println("Length of last word: " + lastWord.length());
        
        sc.close();
        // BRUTE FORCE SOLUTION
        
//        System.out.println("Enter a sentence:");
//        String s = sc.nextLine();
//
//        int length = 0;
//        boolean foundLetter = false;
//
//        // Start from the end
//        for (int i = s.length() - 1; i >= 0; i--) {
//            char c = s.charAt(i);
//
//            if (c != ' ') {
//                length++;
//                foundLetter = true;
//            } else if (foundLetter) {
//                // space after last word
//                break;
//            }
//        }
//
//        System.out.println("Length of last word: " + length);
//        
//        //EFFICIENT / SIMPLE SOLUTION
//        
//        System.out.println("Enter a sentence:");
//        String s = sc.nextLine();
//
//        int length = 0;
//        int i = s.length() - 1;
//
//        // Skip trailing spaces
//        while (i >= 0 && s.charAt(i) == ' ') {
//            i--;
//        }
//
//        // Count letters of last word
//        while (i >= 0 && s.charAt(i) != ' ') {
//            length++;
//            i--;
//        }
//
//        System.out.println("Length of last word: " + length);
	}

}
