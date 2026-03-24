package Projects_FileHandling;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Grocery_Price_Recorder {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		File file = new File("grocery_list.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("File grocery_list.txt is Created.");
			} else {
				System.out.println("File already Exists");
			} 
		} catch (Exception e) {
			System.out.println("Error");
		}
		String text = inputItems(scan);
		saveToFile(text, file);
		readFile(file);
		scan.close();
		
	}
	
	public static String inputItems(Scanner scan) {
		String contain = "";
		System.out.print("How many grocery items? ");
		int items = scan.nextInt();
		scan.nextLine();
		String[] itemName = new String[items];
		double[] itemPrice = new double[items];
		System.out.println();
		for (int i = 0; i < items; i++) {
			System.out.print("Item "+ (i + 1) + " name: ");
			itemName[i] = scan.nextLine();
			System.out.print("Item "+ (i + 1) + " price: ");
			itemPrice[i] = scan.nextDouble();
			scan.nextLine();
			System.out.println();
			contain += "Item: " + itemName[i] + " – ₱" + String.format("%.1f", itemPrice[i]) + "\n";
		}
		return contain;
		
	}
	
	public static void saveToFile(String text, File file) {
		try {
			System.out.println("Saving grocery list...");
			FileWriter writer = new FileWriter(file);
			writer.write(text);
			writer.close();
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
	public static void readFile(File file) {
		try {
			Scanner read = new Scanner(file);
			System.out.println("Reading saved file...\n");
			while(read.hasNextLine()) {
				System.out.println(read.nextLine());
			}
			System.out.println("\nSaved report to grocery_list.txt");
			read.close();
		} catch (Exception e) {
			System.out.println("Error");
		}
	}

}
