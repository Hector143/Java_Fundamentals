package Projects_FileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Simple_Address_Book_System {
	
    static final int MAX_CONTACTS = 20;

    static String[] names = new String[MAX_CONTACTS];
    static String[] phoneNumbers = new String[MAX_CONTACTS];
    static String[] emails = new String[MAX_CONTACTS];
    static int contactCount = 0;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
    	
        File file = new File("address_book.txt");
        initFile(file);
        loadContactsFromFile();
        int choice;
        do {
            System.out.println("====================================");
            System.out.println("        SIMPLE ADDRESS BOOK");
            System.out.println("====================================");
            System.out.println("[1] Add Contact");
            System.out.println("[2] Delete Contact");
            System.out.println("[3] Search Contact");
            System.out.println("[4] Display All Contacts");
            System.out.println("[5] Save & Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    deleteContact();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    displayContacts();
                    break;
                case 5:
                    saveToFile();
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.err.println("Invalid choice!");
            }

        } while (choice != 5);

        scan.close();
    }

    // ================= LOAD CONTACTS =================
    public static void loadContactsFromFile() {
        File file = new File("address_book.txt");

        if (!file.exists()) {
            System.out.println("No existing address book found. Starting fresh.");
            return;
        }

        System.out.println("Loading existing contacts from address_book.txt...");

        try {
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine() && contactCount < MAX_CONTACTS) {
                String line = fileScanner.nextLine();

                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");

                if (parts.length == 3) {
                    names[contactCount] = parts[0];
                    phoneNumbers[contactCount] = parts[1];
                    emails[contactCount] = parts[2];
                    contactCount++;
                }
            }

            fileScanner.close();
            System.out.println(contactCount + " contacts loaded successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Error reading the address book file.");
        }
    }

    public static void addContact() {
        if (contactCount == MAX_CONTACTS) {
            System.out.println("\nAddress book is full.");
            return;
        }

        System.out.print("\nEnter contact name: ");
        String name = scan.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scan.nextLine();
        System.out.print("Enter email address: ");
        String email = scan.nextLine();

        if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            System.out.println("All fields are required.");
            return;
        }

        names[contactCount] = name;
        phoneNumbers[contactCount] = phone;
        emails[contactCount] = email;
        contactCount++;

        System.out.println("\nContact added successfully!\n");
        saveToFile();
    }

    public static void deleteContact() {
        if (contactCount == 0) {
            System.out.println("\nNo contacts to delete.");
            return;
        }

        System.out.print("\nEnter name of contact to delete: ");
        String nameToDelete = scan.nextLine();

        int index = -1;

        for (int i = 0; i < contactCount; i++) {
            if (names[i].equalsIgnoreCase(nameToDelete)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("\nContact not found.");
            return;
        }

        for (int i = index; i < contactCount - 1; i++) {
            names[i] = names[i + 1];
            phoneNumbers[i] = phoneNumbers[i + 1];
            emails[i] = emails[i + 1];
        }

        names[contactCount - 1] = null;
        phoneNumbers[contactCount - 1] = null;
        emails[contactCount - 1] = null;
        contactCount--;

        System.out.println("\nContact deleted successfully!");
        saveToFile();
    }

    public static void searchContact() {
        if (contactCount == 0) {
            System.out.println("\nNo contacts to search.");
            return;
        }

        System.out.print("\nEnter name to search: ");
        String searchName = scan.nextLine();

        for (int i = 0; i < contactCount; i++) {
            if (names[i].equalsIgnoreCase(searchName)) {
                System.out.println("Contact found!");
                System.out.println("Name: " + names[i]);
                System.out.println("Phone: " + phoneNumbers[i]);
                System.out.println("Email: " + emails[i]);
                return;
            }
        }

        System.out.println("\nContact not found.");
    }

    public static void displayContacts() {
        if (contactCount == 0) {
            System.out.println("\nNo contacts saved.");
            return;
        }

        System.out.println("\n\n------------------------------------");
        System.out.println("       CONTACT LIST (" + contactCount + " total)");
        System.out.println("------------------------------------");

        for (int i = 0; i < contactCount; i++) {
            System.out.println((i + 1) + ". Name: " + names[i]);
            System.out.println("   Phone: " + phoneNumbers[i]);
            System.out.println("   Email: " + emails[i]);
            System.out.println();
        }
        System.out.print("------------------------------------\n\n");
    }

    public static void saveToFile() {
        try {
            FileWriter fw = new FileWriter("address_book.txt");

            for (int i = 0; i < contactCount; i++) {
                fw.write(names[i] + "," + phoneNumbers[i] + "," + emails[i] + "\n");
            }

            fw.close();
            System.out.println("\nSaved!");
        } catch (Exception e) {
            System.err.println("\nError saving file.");
        }
    }

    public static void initFile(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            System.err.println("File error.");
        }
    }
}
