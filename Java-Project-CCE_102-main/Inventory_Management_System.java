package Projects_FileHandling;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Inventory_Management_System {

	public static void main(String[] args) {
		File file = new File("inventory.txt");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter maximum number of items: ");
		int max = scan.nextInt();
		scan.nextLine();
		
		String[] itemName = new String[max];
		double[] price = new double[max];
		int[] quantity = new int[max];
		
		int count = 0;
		int option = 0;
		
		do {
			System.out.println("\n-------------------------------------");
			System.out.println("     INVENTORY MANAGEMENT SYSTEM");
			System.out.println("-------------------------------------");
			System.out.println("1 – Add Item\n2 – Update Item Quantity\n3 – Display Inventory\n4 – Save Inventory\n5 – Exit\n");
			System.out.print("Choose an option: ");
			option = scan.nextInt();
			scan.nextLine();
			switch (option) {
			case 1: 
				count = addItem(scan,itemName,price,quantity, count, max);
				break;
			case 2:
				updateQuantity(scan,itemName,quantity,count);
				break;
			case 3:
				displayInventory(itemName,price,quantity,count);
				break;
			case 4:
				saveToFile(file,itemName,price,quantity,count);
				break;
			case 5: 
				System.out.println("Program terminated.");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid option!");
				break;
			}
		} while (option != 5) ;
		
		scan.close();
		
	}
	
	public static int addItem(Scanner sc, String[] itemName, double[] price, int[] quantity, int count, int max) {
		if (count >= max) {
			System.out.println("Inventory full!");
			return count;
		} else {
			System.out.print("Enter item name: ");
			itemName[count] = sc.nextLine();
			System.out.print("Enter price: ");
			price[count] = sc.nextDouble();
			sc.nextLine();
			System.out.print("Enter quantity: ");
			quantity[count] = sc.nextInt();
			sc.nextLine();
			System.out.println("Item added!\n");
			
			
		}
		count++;
		
		return count;
		
	}
	
	public static void updateQuantity(Scanner scan, String[] itemName, int[] quantity, int count) {
		System.out.print("Enter item name to update: ");
		int i = 0;
		String update = scan.nextLine();
		for (i = 0; i < count; i++) {
			if (itemName[i].equals(update)) {
				System.out.print("Enter new quantity: ");
				quantity[i] = scan.nextInt();
				System.out.println("Quantity updated!");
				return;
			} 
		}
		System.out.println("Item not found");
	}
	
	public static void displayInventory(String[] itemName, double[] price, int[] quantity, int count) {
		System.out.println("-------------------------------------\n\tINVENTORY LIST\n-------------------------------------\n");
		for (int i = 0; i < count; i++) {
			System.out.printf("%s - %.1f (Qty: %d)%n", itemName[i], price[i], quantity[i]);
		}
	}
	
	public static void saveToFile(File file, String[] itemName, double[] price, int[] quantity, int count) {
		try {
			FileWriter writer = new FileWriter(file, true);
			for (int i = 0; i < count; i++) {
				writer.write(itemName[i] + "," + String.format("%.0f", price[i]) + "," + quantity[i] + "\n");
			}
			System.out.println("Inventory successfully saved!");
			writer.close();
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
	}
}
