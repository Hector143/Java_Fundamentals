package GUI_Projects;

import model.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DecimalFormat;
import model.User;
import model.Product;

public class FileHandler {

    private static final String USER_FILE = "users.txt";
    private static final String PRODUCT_FILE = "products.txt";

    public static void saveUsers(List<User> users) {
        try (PrintWriter pw = new PrintWriter(USER_FILE)) {
            for (User u : users) {
                pw.println(u.username + "," + u.password + "," + u.role);
            }
        } catch (Exception e) {
            System.out.println("Error saving users: "+e.getMessage());
        }
    }

    public static List<User> loadUsers() {
        List<User> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(USER_FILE))) {
            while (sc.hasNextLine()) {
                String[] d = sc.nextLine().split(",");
                list.add(new User(d[0], d[1], d[2]));
            }
        } catch (FileNotFoundException e) {
            // default admin if file missing
            list.add(new User("admin","admin","ADMIN"));
        }
        return list;
    }

    public static void saveProducts(List<Product> products) {
        try (PrintWriter pw = new PrintWriter(PRODUCT_FILE)) {
            for (Product p : products) {
                pw.println(p.id + "," + p.name + "," + p.stock + "," + p.price);
            }
        } catch (Exception e) {
            System.out.println("Error saving products: "+e.getMessage());
        }
    }

    public static List<Product> loadProducts() {
        List<Product> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(PRODUCT_FILE))) {
            while (sc.hasNextLine()) {
                String[] d = sc.nextLine().split(",");
                list.add(new Product(
                        Integer.parseInt(d[0]),
                        d[1],
                        Integer.parseInt(d[2]),
                        Double.parseDouble(d[3])
                ));
            }
        } catch (FileNotFoundException ignored) {}
        return list;
    }
}
class InventoryPanel extends JPanel {
    DefaultTableModel model;
    JTextField searchField;

    InventoryPanel() {
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new String[]{"ID","Name","Stock","Price"},0);
        JTable table = new JTable(model);
        refresh();

        searchField = new JTextField(10);
        JButton searchBtn = new JButton("Search");
        searchBtn.addActionListener(e -> searchProducts(searchField.getText()));

        JTextField name = new JTextField(8);
        JTextField stock = new JTextField(4);
        JTextField price = new JTextField(5);

        JButton add = new JButton("Add");
        JButton update = new JButton("Update");
        JButton del = new JButton("Delete");

        add.addActionListener(e -> {
            if(name.getText().isEmpty() || stock.getText().isEmpty() || price.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,"All fields required");
                return;
            }
            int s; double p;
            try { s=Integer.parseInt(stock.getText()); p=Double.parseDouble(price.getText()); }
            catch(Exception ex){ JOptionPane.showMessageDialog(this,"Invalid number"); return; }
            Store.products.add(new Product(Store.productCounter++, name.getText(), s, p));
            FileHandler.saveProducts(Store.products);
            refresh();
        });

        update.addActionListener(e -> {
            int r = table.getSelectedRow();
            if(r<0){ JOptionPane.showMessageDialog(this,"Select product"); return; }
            Product p = Store.products.get(r);
            if(name.getText().isEmpty() || stock.getText().isEmpty() || price.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,"All fields required");
                return;
            }
            try { p.stock=Integer.parseInt(stock.getText()); p.price=Double.parseDouble(price.getText()); } catch(Exception ex){ JOptionPane.showMessageDialog(this,"Invalid number"); return; }
            p.name=name.getText();
            FileHandler.saveProducts(Store.products);
            refresh();
        });

        del.addActionListener(e -> {
            int r=table.getSelectedRow();
            if(r>=0 && JOptionPane.showConfirmDialog(this,"Delete this product?","Confirm",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                Store.products.remove(r);
                FileHandler.saveProducts(Store.products);
                refresh();
            }
        });

        JPanel top = new JPanel(); top.add(new JLabel("Search")); top.add(searchField); top.add(searchBtn);
        JPanel south = new JPanel(); 
        south.add(new JLabel("Name")); south.add(name);
        south.add(new JLabel("Stock")); south.add(stock);
        south.add(new JLabel("Price")); south.add(price);
        south.add(add); south.add(update); south.add(del);

        add(top,BorderLayout.NORTH);
        add(new JScrollPane(table),BorderLayout.CENTER);
        add(south,BorderLayout.SOUTH);
    }

    void refresh() {
        model.setRowCount(0);
        for(Product p: Store.products) model.addRow(new Object[]{p.id,p.name,p.stock,p.price});
    }

    void searchProducts(String key) {
        model.setRowCount(0);
        for(Product p: Store.products)
            if(p.name.toLowerCase().contains(key.toLowerCase()))
                model.addRow(new Object[]{p.id,p.name,p.stock,p.price});
    }
}

class UserManagementPanel extends JPanel {
    DefaultTableModel model;
    JTextField uField;
    JPasswordField pField;

    UserManagementPanel() {
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new String[]{"Username","Role"},0);
        JTable table = new JTable(model);
        refresh();

        uField = new JTextField(10);
        pField = new JPasswordField(10);

        JButton add = new JButton("Add User");
        JButton del = new JButton("Delete User");
        JButton edit = new JButton("Edit Password");

        add.addActionListener(e -> {
            if(uField.getText().isEmpty() || pField.getPassword().length==0) {
                JOptionPane.showMessageDialog(this,"Fill username and password");
                return;
            }
            Store.users.add(new User(uField.getText(), new String(pField.getPassword()), "USER"));
            FileHandler.saveUsers(Store.users);
            refresh();
        });

        del.addActionListener(e -> {
            int r = table.getSelectedRow();
            if(r>=0 && JOptionPane.showConfirmDialog(this,"Delete this user?","Confirm",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
                Store.users.remove(r);
                FileHandler.saveUsers(Store.users);
                refresh();
            }
        });

        edit.addActionListener(e -> {
            int r = table.getSelectedRow();
            if(r>=0) {
                User user = Store.users.get(r);
                String newPass = JOptionPane.showInputDialog(this,"New Password for " + user.username);
                if(newPass != null && !newPass.isEmpty()) {
                    user.password = newPass;
                    FileHandler.saveUsers(Store.users);
                    refresh();
                }
            }
        });

        JPanel south = new JPanel();
        south.add(new JLabel("User")); south.add(uField);
        south.add(new JLabel("Pass")); south.add(pField);
        south.add(add); south.add(edit); south.add(del);

        add(new JScrollPane(table),BorderLayout.CENTER);
        add(south,BorderLayout.SOUTH);
    }

    void refresh() {
        model.setRowCount(0);
        for(User u: Store.users) model.addRow(new Object[]{u.username,u.role});
    }
}
class POSPanel extends JPanel {
    DefaultTableModel productModel, orderModel;
    ArrayList<OrderItem> cart = new ArrayList<>();
    JLabel totalLabel;
    DecimalFormat df = new DecimalFormat("0.00");
    JTextField searchField;

    POSPanel() {
        setLayout(new BorderLayout());

        productModel = new DefaultTableModel(new String[]{"ID","Name","Stock","Price"},0);
        JTable productTable = new JTable(productModel);

        orderModel = new DefaultTableModel(new String[]{"Name","Qty","Subtotal"},0);
        JTable orderTable = new JTable(orderModel);

        refreshProducts();

        searchField = new JTextField(10);
        JButton searchBtn = new JButton("Search");
        searchBtn.addActionListener(e -> searchProducts(searchField.getText()));

        JButton add = new JButton("Add to Order");
        JButton remove = new JButton("Remove Item");
        JButton checkout = new JButton("Checkout");

        totalLabel = new JLabel("Total: 0.00");

        add.addActionListener(e -> {
            int r = productTable.getSelectedRow();
            if(r<0) return;

            Product p = Store.products.get(r);

            if(p.stock <= 0) { JOptionPane.showMessageDialog(this,"OUT OF STOCK"); return; }

            String qStr = JOptionPane.showInputDialog("Quantity:");
            int q;
            try { q = Integer.parseInt(qStr); } catch(Exception ex){ JOptionPane.showMessageDialog(this,"Invalid number"); return; }
            if(q>p.stock) { JOptionPane.showMessageDialog(this,"Insufficient stock"); return; }

            p.stock -= q;
            cart.add(new OrderItem(p,q));
            FileHandler.saveProducts(Store.products);
            refreshProducts(); refreshOrder();
        });

        remove.addActionListener(e -> {
            int r = orderTable.getSelectedRow();
            if(r>=0) {
                OrderItem oi = cart.remove(r);
                oi.product.stock += oi.qty;
                FileHandler.saveProducts(Store.products);
                refreshProducts(); refreshOrder();
            }
        });

        checkout.addActionListener(e -> {
            if(cart.isEmpty()){ JOptionPane.showMessageDialog(this,"Cart empty"); return; }
            new CheckoutDialog(cart,total());
            cart.clear();
            refreshOrder(); refreshProducts();
        });

        JButton editQty = new JButton("Edit Quantity");
        editQty.addActionListener(e -> {
            int r = orderTable.getSelectedRow();
            if(r>=0){
                OrderItem oi = cart.get(r);
                String newQStr = JOptionPane.showInputDialog("New quantity:", oi.qty);
                int newQ;
                try { newQ = Integer.parseInt(newQStr); } catch(Exception ex){ JOptionPane.showMessageDialog(this,"Invalid number"); return; }
                if(newQ <=0 || newQ > (oi.product.stock + oi.qty)) { JOptionPane.showMessageDialog(this,"Invalid stock"); return; }
                oi.product.stock += oi.qty - newQ; // adjust stock
                oi.qty = newQ;
                FileHandler.saveProducts(Store.products);
                refreshProducts(); refreshOrder();
            }
        });

        JPanel top = new JPanel(); top.add(new JLabel("Search")); top.add(searchField); top.add(searchBtn);
        JPanel left = new JPanel(new BorderLayout());
        left.add(new JLabel("Products",SwingConstants.CENTER), BorderLayout.NORTH);
        left.add(new JScrollPane(productTable), BorderLayout.CENTER);
        left.add(add,BorderLayout.SOUTH);

        JPanel right = new JPanel(new BorderLayout());
        right.add(new JLabel("Order",SwingConstants.CENTER), BorderLayout.NORTH);
        right.add(new JScrollPane(orderTable), BorderLayout.CENTER);

        JPanel south = new JPanel();
        south.add(editQty); south.add(remove); south.add(totalLabel); south.add(checkout);

        add(top,BorderLayout.NORTH);
        add(left,BorderLayout.WEST);
        add(right,BorderLayout.CENTER);
        add(south,BorderLayout.SOUTH);
    }

    void refreshProducts() {
        productModel.setRowCount(0);
        for(Product p: Store.products)
            productModel.addRow(new Object[]{p.id,p.name,p.stock,p.price});
    }

    void refreshOrder() {
        orderModel.setRowCount(0);
        for(OrderItem oi: cart)
            orderModel.addRow(new Object[]{oi.product.name,oi.qty,df.format(oi.subtotal())});
        totalLabel.setText("Total: "+df.format(total()));
    }

    double total() {
        double t=0; for(OrderItem oi: cart) t+=oi.subtotal(); return t;
    }

    void searchProducts(String key) {
        productModel.setRowCount(0);
        for(Product p: Store.products)
            if(p.name.toLowerCase().contains(key.toLowerCase()))
                productModel.addRow(new Object[]{p.id,p.name,p.stock,p.price});
    }
}
class LoginFrame extends JFrame {
    JTextField user;
    JPasswordField pass;

    LoginFrame() {
        // Load users/products
        Store.users = FileHandler.loadUsers();
        Store.products = FileHandler.loadProducts();
        if(Store.products.size()>0) Store.productCounter = Store.products.get(Store.products.size()-1).id+1;

        setTitle("TorreCafe Login");
        setSize(350,220);
        setLayout(new GridLayout(4,2,5,5));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        user = new JTextField();
        pass = new JPasswordField();
        JButton login = new JButton("Login");

        login.addActionListener(e -> {
            if(user.getText().isEmpty() || pass.getPassword().length==0){
                JOptionPane.showMessageDialog(this,"Enter username and password");
                return;
            }
            User u = Store.login(user.getText(), new String(pass.getPassword()));
            if(u==null){ JOptionPane.showMessageDialog(this,"Invalid credentials"); return; }
            dispose();
            if(u.role.equals("ADMIN")) new AdminFrame();
            else new POSFrame();
        });

        add(new JLabel("Username:")); add(user);
        add(new JLabel("Password:")); add(pass);
        add(new JLabel()); add(login);

        setVisible(true);
    }
}
