package CCE_103;

import java.io.*;
import java.util.ArrayList;

public class InventoryService {

    private static final String FILE_NAME = "inventory.txt";

    // LOAD
    public static ArrayList<Item> loadItems() {
        ArrayList<Item> items = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                String name = parts[0];
                double price = Double.parseDouble(parts[1]);
                int stock = Integer.parseInt(parts[2]);

                items.add(new Item(name, price, stock));
            }

        } catch (IOException e) {
            System.out.println("No inventory file found. Starting fresh.");
        }

        return items;
    }

    // SAVE 🔥 (THIS IS WHAT YOU NEED)
    public static void saveItems(ArrayList<Item> items) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Item item : items) {
                bw.write(item.getName() + "," +
                         item.getPrice() + "," +
                         item.getStock());
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}