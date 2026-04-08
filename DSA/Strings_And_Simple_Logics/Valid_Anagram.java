package Strings_And_Simple_Logics;

import java.util.Scanner;

public class Valid_Anagram {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter String 1: ");
        String str1 = scan.nextLine();

        System.out.print("Enter String 2: ");
        String str2 = scan.nextLine();

        // Step 1: Length check
        if (str1.length() != str2.length()) {
            System.out.println("Not anagrams");
            scan.close();
            return;
        }

        boolean anagram = true;

        // To mark characters of str2 that are already used
        boolean[] used = new boolean[str2.length()];

        for (int i = 0; i < str1.length(); i++) {
            boolean found = false;

            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j) && !used[j]) {
                    used[j] = true;   // mark as used
                    found = true;
                    break;
                }
            }

            // if character from str1 not found in str2
            if (!found) {
                anagram = false;
                break;
            }
        }

        if (anagram) {
            System.out.println("Anagrams");
        } else {
            System.out.println("Not anagrams");
        }

        scan.close();
    }
}