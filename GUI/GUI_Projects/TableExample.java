package GUI_Projects;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableExample {

    public static void main(String[] args) {

        // Create frame
        JFrame frame = new JFrame("Simple JTable Example");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ===============================
        // STEP 1: Create TableModel
        // ===============================
        DefaultTableModel model = new DefaultTableModel();

        // Add column names
        model.setColumnIdentifiers(new String[]{
                "ID", "Name", "Department"
        });

        // ===============================
        // STEP 2: Create JTable using model
        // ===============================
        JTable table = new JTable(model);

        // ===============================
        // STEP 3: Put JTable inside JScrollPane
        // ===============================
        JScrollPane scrollPane = new JScrollPane(table);

        // Add scrollPane to frame
        frame.add(scrollPane);

        // ===============================
        // STEP 4: Add a row
        // ===============================
        model.addRow(new String[]{
                "E1001", "John", "IT"
        });

        // Show frame
        frame.setVisible(true);
    }
}
