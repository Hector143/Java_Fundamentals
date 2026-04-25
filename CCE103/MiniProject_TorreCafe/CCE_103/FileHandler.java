package CCE_103;

import java.io.*;
import java.util.*;

public class FileHandler {

    public static void saveUser(User user) {
        try (FileWriter fw = new FileWriter("users.txt", true)) {
            fw.write(user.toFileString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<User> loadUsers() {
        ArrayList<User> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");

                if (data.length >= 2) {
                    list.add(new User(data[0], data[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("No user file yet.");
        }

        return list;
    }
}