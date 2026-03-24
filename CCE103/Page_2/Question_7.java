package Page_2;

import java.util.Scanner;

public class Question_7 {

	public static void main(String[] args) {
		System.out.println(getBirthdate());
	}
	
	public static String getBirthdate() {
		System.out.println("Enter your birthday in the format MMDDYYYY");
        Scanner sc = new Scanner(System.in);  // Create a scanner to read input
        String birthdate = sc.next();  // Use next() to read the next token (the birthdate)
        sc.close();  // Close the scanner
        return birthdate;  // Return the entered birthdate
	}

}
