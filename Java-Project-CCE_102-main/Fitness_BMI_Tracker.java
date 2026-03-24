package hey;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
public class Fitness_BMI_Tracker {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		File file = new File("bmi_report.txt");
		System.out.print("How many people? ");
		int people = scan.nextInt();
		scan.nextLine();
		double[] weights = inputData(people);
		double[] heights = inputData(people);
		for (int i = 0 ; i < people; i++) {
			System.out.print("Person " + (i+1) + " weight (kg): ");
			weights[i] = scan.nextDouble();
			scan.nextLine();
			System.out.print("Person " + (i+1) + " height (m): ");
			heights[i] = scan.nextDouble();
			scan.nextLine();	
		}
		scan.close();
		String data = "";
		System.out.println();
		for (int i = 0 ; i < people; i++) {
			double bmi = computeBMI(weights[i], heights[i]);
			String cat = getBMICategory(bmi);
			data += String.format("Person %d: %.1f kg, %.1f m, BMI = %.1f, Category = %s%n", (i+1), weights[i], heights[i], bmi, cat);
		}
		System.out.println(data + "\n");
		System.out.print("Saved report to bmi_report.txt");
		saveBMIReport(file, data);
	}
	public static double[] inputData(int people){
		double[] array = new double [people];
		return array;

	}
	public static double computeBMI(double weight, double height) {
		double bmi = weight / Math.pow(height, 2);
		return bmi;
	}
	public static String getBMICategory(double bmi) {
		if (bmi >= 30.0) {
			return "Obese";
		} else if (bmi >= 25.0) {
			return "Overweight";
		} else if (bmi >= 18.5) {
			return "Normal";
		} else {
			return "Underweight";
		}
	}
	public static void initFile(File file) {
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			System.err.println("Something went wrong!");
		}
	}
	public static void saveBMIReport(File file, String reportText) {
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(reportText);
			fw.close();
		} catch (Exception e) {
			System.err.println("Something went wrong!");
		}
	}
}
