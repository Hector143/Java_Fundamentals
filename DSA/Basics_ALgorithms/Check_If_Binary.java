package Basics_ALgorithms;

import java.util.Scanner;

public class Check_If_Binary {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		
		if (isBinary(s)) {
			System.out.println(s + " is Binary.");
		} else {
			System.out.println(s + " is not Binary.");
		}
		scan.close();
	}
	
	public static boolean isBinary(String s) {
        boolean isTrue = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!='0' && s.charAt(i)!='1') {
                isTrue = false;
            }
        }
        return isTrue;
        
    }
}
