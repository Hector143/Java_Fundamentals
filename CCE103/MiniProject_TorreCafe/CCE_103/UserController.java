package CCE_103;

import java.io.*;
import java.util.ArrayList;

public class UserController {

    public static final String FILE_NAME = "users.txt";
    public static File file = new File(FILE_NAME);

    public ArrayList<User> userList;

    public UserController(ArrayList<User> userList) {
        this.userList = userList;
    }

    public void initFile() {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        userList.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split("\\|");

                if (split.length >= 2) {
                    userList.add(new User(split[0], split[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("No user file yet.");
        }
    }

    public void saveToFile() {
        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            for (User u : userList) {
                fw.write(u.toFileString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 🔥 duplicate check
    public boolean isDuplicate(String username) {
        for (User u : userList) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    public void addUser(User u) {
        userList.add(u);
        saveToFile();
    }

    public void deleteUser(int index) {
        userList.remove(index);
        saveToFile();
    }
}