package Easy;

import java.util.Scanner;

public class add_Digits {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter num: ");
		int num = scan.nextInt(); scan.nextLine();
		
		
		System.out.println("Output: " + addDigits(num));
		scan.close();

	}
	
	public static int addDigits(int num) {
		while (num >= 10) {
			int sum = 0;
			while (num > 0) {
				sum += num % 10;
				num /= 10;
			}
			num = sum;
		}
		return num;
	}
		
}
