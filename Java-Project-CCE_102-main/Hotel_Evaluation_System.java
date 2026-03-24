package Projects_FileHandling;

import java.util.Scanner;
import java.io.FileWriter;

public class Hotel_Evaluation_System {

	public static void main(String[] args) {
		String text = "";
		int[] inputs = inputStayDays();
		
		for (int i = 0; i < inputs.length; i++) {
			int rate = getRatePerDay(inputs[i]);
			int total = calculateTotalCharge(inputs[i]);
			String cat = getStayCategory(inputs[i]);
			text += String.format("Guest %d: %d days | Rate: ₱%d | Total Charge: ₱%d | %s%n", (i+1),inputs[i], rate, total, cat);
		}
		int countShort = countCategory(inputs, "Short Stay");
		int countStandard = countCategory(inputs, "Standard Stay");
		int countLong = countCategory(inputs, "Long Stay");
		int totalRevenue = calculateTotalRevenue(inputs);
		
		text += "\nSummary:\n";
		text += "Short Stay Guests: " + countShort + "\n";
		text += "Standard Stay Guests: " + countStandard + "\n";
		text += "Long Stay Guests: " + countLong + "\n";
		text += "Total Hotel Revenue: ₱" + totalRevenue + "\n";
		System.out.println(text);
		saveToFile(text);
		System.exit(0);

	}
	
	public static int[] inputStayDays() {
		Scanner scan = new Scanner(System.in);
		System.out.print("How many guests checked in? ");
		int num = scan.nextInt();
		scan.nextLine();
		
		int[] days = new int[num];
		System.out.println("Enter number of days stayed: ");
		for (int i = 0; i < days.length; i++) {
			System.out.print("Guest " + (i+1) + ": ");
			days[i] = scan.nextInt();
			scan.nextLine();
		}
		System.out.println();
		scan.close();
		return days;
		
	}
	
	public static int getRatePerDay(int days) {
		int rate = 0;
		if (days > 5) {
			rate += 1000;
		} else if(days >= 3) {
			rate += 1200;
		} else if(days >= 1){
			rate += 1500;
		}
		return rate;
	}
	
	public static int calculateTotalCharge(int days) {
		int charge = 0;
		if (days > 5) {
			charge += (1000 * days);
		} else if(days >= 3) {
			charge += (1200 * days);
		} else if(days >= 1){
			charge += (1500 * days);
		}
		return charge;
		
	}
	
	public static String getStayCategory(int days) {
		if (days > 5) {
			return "Long Stay";
		} else if(days >= 3) {
			return "Standard Stay";
		} else {
			return "Short Stay";
		}
	}
	
	public static int countCategory(int[] days, String category) {
	    int count = 0;

	    for (int i = 0; i < days.length; i++) {
	        if (getStayCategory(days[i]).equals(category)) {
	            count++;
	        }
	    }
	    return count;
	}
	
	public static int calculateTotalRevenue(int[] days) {
		int total = 0;
		for (int i = 0; i < days.length; i++) {
			total += calculateTotalCharge(days[i]);
		}
		return total;
	}
	
	public static void saveToFile(String text) {
		try {
			FileWriter fw = new FileWriter("hotel_occupancy_report.txt", true);
			fw.write(text + "\n\n\n");
			fw.close();
			System.out.println("Hotel occupancy report saved to hotel_occupancy_report.txt");
		} catch (Exception e) {
			System.err.println("Something went wrong!");
		}
	}

}
