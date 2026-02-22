package GUI_Projects;

import javax.swing.*;

class AdminFrame extends JFrame {
    public AdminFrame() {
        setTitle("Admin Panel");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Users", new UserManagementPanel());   // Make sure this class exists
        tabs.add("Inventory", new InventoryPanel());    // Make sure this class exists

        add(tabs);
        setVisible(true);
    }
}