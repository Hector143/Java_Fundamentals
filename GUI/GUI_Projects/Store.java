package GUI_Projects;


import model.User;
import model.Product;
import java.util.*;

public class Store {
    public static List<User> users = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static int productCounter = 1;

    static {
        // default admin
        users.add(new User("admin","admin","ADMIN"));
    }

    public static User login(String username, String password) {
        for(User u: users) {
            if(u.username.equals(username) && u.password.equals(password)) {
                return u;
            }
        }
        return null;
    }
}
