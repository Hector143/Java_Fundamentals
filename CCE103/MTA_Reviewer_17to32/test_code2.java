package MTA_Reviewer_17to32;

import java.util.Scanner;

public class test_code2 {

	public static void main(String[] args) {
		String birthday = getBirthdate(); // invoke the getBirthdate behavior
		System.out.println(birthday);
	}
	
	public static String getBirthdate() {
		Scanner sc = new Scanner(System.in); // Object of Scanner
		System.out.println("Enter your birthday in the format of MM:DD:YYYY : "); // prompt enter
		String birthdate = sc.next(); // allows User to input in console
		sc.close(); // safely close the scanner 
		return birthdate; // return String value of birthdate.
	}

}
