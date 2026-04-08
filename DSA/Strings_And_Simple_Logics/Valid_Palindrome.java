package Strings_And_Simple_Logics;

import java.util.Scanner;

public class Valid_Palindrome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();

        String cleaned = "";

        // Step 1: Clean the string
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                cleaned = cleaned + Character.toLowerCase(ch);
            }
        }

        // Step 2: Reverse the cleaned string
        String reversed = "";
        for (int i = cleaned.length() - 1; i >= 0; i--) {
            reversed = reversed + cleaned.charAt(i);
        }

        // Step 3: Compare
        if (cleaned.equals(reversed)) {
            System.out.println("Valid Palindrome");
        } else {
            System.out.println("Not a Valid Palindrome");
        }
        sc.close();
        
        // ALTERNATIVE SOLUTION // BRUTE FORCE APPROACH
        
//        Scanner sc1 = new Scanner(System.in);
//        System.out.println("Enter a sentence:");
//        String sentence1 = sc1.nextLine();
//
//        String cleaned1 = "";
//
//        for (int i = 0; i < sentence1.length(); i++) {
//            char ch = sentence1.charAt(i);
//
//            if (Character.isLetterOrDigit(ch)) {
//                cleaned1 += Character.toLowerCase(ch);
//            }
//        }
//
//        String reversed1 = new StringBuilder(cleaned1).reverse().toString();
//
//        if (cleaned1.equals(reversed1)) {
//            System.out.println("Valid Palindrome");
//        } else {
//            System.out.println("Not a Valid Palindrome");
//        }
//        sc1.close();
        
        
        // CODE EFFICIENT but simple
        
//        Scanner sc2 = new Scanner(System.in);
//        System.out.println("Enter a sentence:");
//        String s = sc2.nextLine();
//
//        int left = 0;
//        int right = s.length() - 1;
//
//        boolean isPalindrome = true;
//
//        while (left < right) {
//
//            char l = s.charAt(left);
//            char r = s.charAt(right);
//
//            if (!Character.isLetterOrDigit(l)) {
//                left++;
//            } 
//            else if (!Character.isLetterOrDigit(r)) {
//                right--;
//            } 
//            else {
//                if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
//                    isPalindrome = false;
//                    break;
//                }
//                left++;
//                right--;
//            }
//        }
//
//        if (isPalindrome) {
//            System.out.println("Valid Palindrome");
//        } else {
//            System.out.println("Not a Valid Palindrome");
//        }
    }
}
