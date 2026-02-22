package Projects;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main_ShapeAreaCalculator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("How many shapes? ");
		int num = scan.nextInt(); scan.nextLine();
		
		Shape[] shape = new Shape[num];
		
		for (int i = 0; i < shape.length; i++) {
			System.out.println("\nEnter details for Shape " + (i+1) + ": ");
			
			System.out.print("Shape type (1 = Circle, 2 = Rectangle): ");
			int type = scan.nextInt(); scan.nextLine();
			
			
			
			if (type == 1) {
				System.out.print("Radius: ");
				double radius = scan.nextDouble(); scan.nextLine();
				
				shape[i] = new Circle(radius);
			} else if (type == 2) {
				System.out.print("Length: ");
				double length = scan.nextDouble(); scan.nextLine();
				
				System.out.print("Width: ");
				double width = scan.nextDouble(); scan.nextLine();
				shape[i] = new Rectangle(length, width);
				
			} else {
				System.out.println("Invalid input!");
				i--;
			}
		}
		
		String text = "";
		
		
		try {
			FileWriter fw = new FileWriter("shapes_report.txt");
			for (int i = 0; i < shape.length; i++) {
				double area = shape[i].calculateArea();
				String shapetype = "";
				if (shape[i] instanceof Circle) {
					shapetype = "Circle";
				} else if (shape[i] instanceof Rectangle) {
					shapetype = "Rectangle";
				}
				text += String.format("Shape %d: %s - Area: %.1f%n", (i+1), shapetype, area);
			}
			System.out.println("\n" + text);
			fw.write(text);
			fw.close();
			System.out.println("Saved report to shapes_report.txt");
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		scan.close();
	}

}
