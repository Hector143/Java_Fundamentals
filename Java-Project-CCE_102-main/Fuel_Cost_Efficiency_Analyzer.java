package hey;

import java.util.Scanner;

public class Fuel_Cost_Efficiency_Analyzer {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter distance traveled (in kilometers): ");
		double dist = scan.nextDouble();
		scan.nextLine();
		System.out.print("Enter fuel consumed (in liters): ");
		double fuelcons = scan.nextDouble();
		scan.nextLine();
		System.out.print("Enter price per liter of fuel: ");
		double price = scan.nextDouble();
		scan.nextLine();
		
		double fuelEfficiency = dist / fuelcons;
		double totalcost = fuelcons * price;
		String efficiencyClassification = "";
		if (fuelEfficiency >= 15) {
			efficiencyClassification += "Excellent fuel efficiency";
		} else if (fuelEfficiency >= 10) {
			efficiencyClassification += "Moderate fuel efficiency";
		} else {
			efficiencyClassification += "Poor fuel efficiency";
		}
		
		System.out.printf("\nFuel Efficiency: %.2f km/L%n", fuelEfficiency);
		System.out.printf("Total Fueld Cost: %%%.2f %n", totalcost);
		System.out.printf("Efficiency Classification: %s%n", efficiencyClassification);
		scan.close();

	}

}
