package Strings_And_Simple_Logics;

import java.util.Scanner;

public class Count_Vowels_in_a_String {

	public static void main(String[] args) {
		// Beginner-Friendly Solution
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String s = sc.nextLine();

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }

        System.out.println("Number of vowels: " + count);
        sc.close();
        
        //Brute Force Solution
        
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a string:");
//        String s = sc.nextLine();
//
//        int count = 0;
//
//        // Convert full string to lowercase first
//        s = s.toLowerCase();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
//                count++;
//            }
//        }
//
//        System.out.println("Number of vowels: " + count);
        
        // Efficient / Simple Solution
        
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a string:");
//        String s = sc.nextLine();
//
//        int count = 0;
//        String vowels = "aeiou";
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = Character.toLowerCase(s.charAt(i));
//            if (vowels.indexOf(c) != -1) {
//                count++;
//            }
//        }
//
//        System.out.println("Number of vowels: " + count);
	}

}
