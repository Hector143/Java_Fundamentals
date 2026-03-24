package hey;

import java.util.Scanner;
import java.io.FileWriter;

public class Traffic_Violation_System {

	public static void main(String[] args) {
		String text = "";
		int[] input = inputSpeeds();
		
		for (int i = 0; i < input.length; i++) {
			String violation = getViolationLevel(input[i]);
			int fine = calculateFine(input[i]);
			text += "Vehicle " + (i+1) + ": " + input[i] + " km/h | " + violation + " | Fine: ₱" + fine + "\n";
		}
		
		int severe = countSevereViolations(input);
		int major = countMajorViolations(input);
		int minor = countMinorViolations(input);
		int no = countNoViolations(input);
		int total = calculateTotalFines(input);
		text += "\nSummary:\n";
		text += "No Violation: " + no + "\n";
		text += "Minor Violation: " + minor + "\n";
		text += "Major Violation: " + major + "\n";
		text += "Severe Violation: " + severe + "\n";
		text += "Total Fines Collected: " + total + "\n";
		System.out.println(text);
		System.out.println("Traffic violation report saved to traffic_violation_report.txt");
		saveToFile(text);

		
		
	}
	
	public static int[] inputSpeeds() {
		Scanner scan = new Scanner(System.in);
		System.out.print("How many vehicles were monitored? ");
		int vehicles = scan.nextInt();
		scan.nextLine();
		
		int[] speeds = new int[vehicles];
		System.out.println("Enter vehicle speeds: ");
		for (int i = 0; i < speeds.length; i++) {
			System.out.print("Vehicle " + (i+1) + ": ");
			speeds[i] = scan.nextInt();
			scan.nextLine();
		}
		System.out.println();
		scan.close();
		return speeds;
	}
	
	public static String getViolationLevel(int speed) {
		if (speed > 100) {
			return "Severe Violation";
		} else if (speed > 80) {
			return "Major Violation";
		} else if (speed > 60) {
			return "Minor Violation";
		} else {
			return "No Violation";
		}
	}
	
	public static int calculateFine(int speed) {
		if (speed > 100) {
			return 5000;
		} else if (speed > 80) {
			return 3000;
		} else if (speed > 60) {
			return 1000;
		} else {
			return 0;
		}
	}
	
	public static int countSevereViolations(int[] speeds) {
		int count = 0;
		for (int i = 0; i < speeds.length; i++) {
			if (speeds[i] > 100) {
				count++;
			}		
		} 
		return count;
	
	}
	
	public static int countMajorViolations(int[] speeds) {
		int count = 0;
		for (int i = 0; i < speeds.length; i++) {
			if (speeds[i] > 80) {
				count++;
			} 
		}
		return count;
	
	}
			
	public static int countMinorViolations(int[] speeds) {
		int count = 0;
		for (int i = 0; i < speeds.length; i++) {
			if (speeds[i] > 60) {
				count++;
			}
		} 
		return count;
	
	}
	
	public static int countNoViolations(int[] speeds) {
		int count = 0;
			for (int i = 0; i < speeds.length; i++) {
				if (speeds[i] < 60) {
					count++;
			} 
			
		}
	return count;
	}
	
	public static int calculateTotalFines(int[] speeds) {
		int total = 0;
		for (int i = 0; i < speeds.length; i++) {
			total += speeds[i];
		} 
		return total;
	}
	
	public static void saveToFile(String text) {
		try {
			FileWriter fw = new FileWriter("traffic_violation_report.txt");
			fw.write(text);
			fw.close();
		} catch (Exception e) {
			System.err.println("Something went wrong!");
		}
	}

}
