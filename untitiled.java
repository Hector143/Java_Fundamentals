package anotherprojecthek;
import java.util.Scanner;

public class untitiled {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int hoursworked;
		int rate = 4;
		int minutesworked;
		double totalpay;
		
		System.out.print("Input the minutes you worked in a day: ");
		minutesworked = scanner.nextInt();
		
		
		
		hoursworked = minutesworked / 60;
		minutesworked = minutesworked % 60;
		totalpay = (minutesworked * rate) + ((hoursworked * 60) * rate);
		System.out.println("you spend " + hoursworked + " hour/s and " + minutesworked + " minutes and my total income is: " + totalpay + "php.");

	}

}
