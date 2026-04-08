package Recursion;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		System.out.println(n + "! = " + factorial(n));
		scan.close();
	}
	
	public static long factorial(int n) {
		long i = 1;
		long f = 1;
		while(i <= n) {
			f *= i;
			i++;
		} 
		return f;
	}

}
