package Projects;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main_SimpleInventorySystem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("How many products? ");
		int num = scan.nextInt(); scan.nextLine();
		
		Product[] products = new Product[num];
		
		for (int i = 0; i < products.length; i++) {
			System.out.println("\nEnter details for Product " + (i+1) + ": ");
			
			System.out.print("Product type (1 = Regular, 2 = Perishable): ");
			int type = scan.nextInt(); scan.nextLine();
			
			if (type == 1) {
				System.out.print("Name: ");
				String name = scan.nextLine();
				
				System.out.print("Price: ");
				double price = scan.nextDouble(); 
				
				scan.nextLine();
				System.out.print("Quantity: ");
				
				int quantity = scan.nextInt();
				scan.nextLine();
				
				products[i] = new Product(name, price, quantity);
				
			} else if (type == 2) {
				System.out.print("Name: ");
				String name = scan.nextLine();
				
				System.out.print("Price: ");
				double price = scan.nextDouble(); 
				
				scan.nextLine();
				System.out.print("Quantity: ");
				
				int quantity = scan.nextInt();
				scan.nextLine();
				
				System.out.print("Expiration Date: ");
				String expireDate = scan.nextLine();
				
				products[i] = new PerishableProduct(name, price, quantity, expireDate);
			} else {
				System.out.println("Invalid type!");
				i--;
			}
		}
		
		String data = "";
		
		try {
			FileWriter fw = new FileWriter("inventory_report.txt");
			for (int i = 0; i < products.length; i++) {
				double total = products[i].calculateTotal();
				if (products[i] instanceof PerishableProduct) {
					PerishableProduct perish = (PerishableProduct) products[i];
					data += "Product: " + products[i].getName() + " - " + String.format("Total Value: ₱%.1f", total) + " - Expiration Date: " + perish.getExpire() + "\n";
				} else {
					data += "Product: " + products[i].getName() + " - " + String.format("Total Value: ₱%.1f", total) + "\n";
				}
				
			}
			System.out.println("\n" + data);
			fw.write(data);
			fw.close();
			System.out.println("Saved report to inventory_report.txt");

		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		scan.close();
	}

}
