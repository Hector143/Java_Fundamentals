package Projects_FileHandling;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
 
public class Smart_Energy_Auditor {
 
	public static void main(String[] args) {
 
		Scanner scan = new Scanner(System.in);
		File file = new File("energy_audit.txt");
		int[] devices = scanDevices(scan);
		String data = "";
		for (int i = 0; i < devices.length; i++) {
			data += String.format("Device %d: %dW - %s%n", (i+1),devices[i],checkEfficiency(devices[i]));
		}
		System.out.println("\n"+data);
		saveAudit(file, data);
		System.out.println("Energy audit saved to energy_audit.txt");
		scan.close();

		}
		 
	public static int[] scanDevices(Scanner scan) {
		 
		System.out.print("How many devices to scan? ");
		int numDev = scan.nextInt();
		scan.nextLine();
		int[] wattage = new int[numDev];
		System.out.println("Enter wattage for " +numDev + " devices: ");
		for (int i = 0; i < wattage.length; i++) {
			System.out.print("Device " +(i + 1) + ": ");
			wattage[i] = scan.nextInt();
			scan.nextLine();
		}
		return wattage;
		 
	}
		 
	public static String checkEfficiency(int watts) {
		 
		if (watts > 1500) {
			return "Power Hog";
		} else if (watts >= 200) {
			return "Standard";
		} else {
			return "Eco-Friendly";
		}
		 
	}
		 
	public static void saveAudit(File f, String data) {
		try {
			FileWriter fw = new FileWriter(f, true);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		} 
	}	 
}