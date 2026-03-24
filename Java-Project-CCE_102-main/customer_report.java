package Projects_FileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class customer_report {
	
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        File newFile = new File("customer_report.txt");
        try {
            newFile.createNewFile();
            if (newFile.exists()) {
            	System.out.println("File \"customer_report.txt\" created successfully.");
            } 
        } catch (IOException e) {
            
            e.printStackTrace();
            System.out.println("There is Something wrong!");
        }

        inputPurchases(scan);
        System.out.println();
        readFile(newFile);
        scan.close();
    }
	
    public static double[] inputPurchases(Scanner scan) {
        
        System.out.print("How many customers? ");
        int customer = scan.nextInt();
        String customer_Details = "";
        
        double[] purchaseAmount = new double[customer];
        System.out.println("Enter purchase amounts for " + customer + " customers: ");
        for (int i = 0; i < customer; i++) {
            System.out.printf("Customer %d: ", i + 1);
            purchaseAmount[i] = scan.nextDouble();
            String category = getCategory(purchaseAmount[i]);
            customer_Details += "Customer " + (i + 1) + ": ₱" + purchaseAmount[i] + " - " + category + "\n";
            
        }
        System.out.println("\nReading the saved File...");
        saveToFile(customer_Details, new File("customer_report.txt"));
        return purchaseAmount;

    }

    public static String getCategory(double purchaseAmount) {
        
        if (purchaseAmount >= 5000) {
            return "VIP Customer";
        } else if (purchaseAmount >= 1000 && purchaseAmount <= 5000) {
            return "Regular Customer";
        } else  {
            return "Occasional Customer";
        }

    }

    public static String saveToFile(String text, File newFile) {
        
        try {
           
            FileWriter write = new FileWriter(newFile);
            write.write(text);
            write.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return text;
            
    }
    
    public static void readFile(File newFile) {
    	try (Scanner read = new Scanner(newFile)){
 
            while (read.hasNextLine()) {
                System.out.println(read.nextLine());
            }
            System.out.println("\n\nSaved report to customer_report.txt");
            read.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
}