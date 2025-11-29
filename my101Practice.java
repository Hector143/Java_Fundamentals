package anotherprojecthek;

import java.util.Scanner;

public class my101Practice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String school = "Hunterville College";
		int tuitionfee = 20000;
		double totalfee;
		double tuitionAddRate;
		double tuitionPercentage = 3;
		System.out.print("Enter the Added tuition fee per year: ");
		double increasedtuitionRate = scan.nextDouble();
		System.out.println("Your Current increase in Tuition fee 3% plus added by : " + increasedtuitionRate + " rate per year.");
		for (int i = 1; i <= 10 ; i++) {
			tuitionAddRate = tuitionPercentage += increasedtuitionRate;
			double sum = tuitionfee * (tuitionAddRate / 100);
			totalfee = tuitionfee + sum;
			System.out.println("So the total tution fee of the school: "+ school +" in year "+ (2025 + i) + " is " + totalfee);
		}
		
		scan.close();
	}

}
