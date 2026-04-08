package Strings_And_Simple_Logics;

import java.util.Scanner;

public class First_Non_Repeating_Character {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        int[] freq = new int[256];

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        char result = '\0';

        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] == 1) {
                result = str.charAt(i);
                break;
            }
        }

        if (result != '\0')
            System.out.println("First non-repeating character: " + result);
        else
            System.out.println("No non-repeating character");

        sc.close();
    }
}