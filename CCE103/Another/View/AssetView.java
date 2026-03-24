package Another.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AssetView extends JFrame {

    // Form Fields
    public JTextField txtId = new JTextField();
    public JTextField txtName = new JTextField();
    public JTextField txtCategory = new JTextField();
    public JTextField txtDate = new JTextField();
    public JTextField txtCost = new JTextField();
    public JTextField txtStatus = new JTextField();
    public JTextField txtLocation = new JTextField();
    public JTextField txtDescription = new JTextField();
    public JTextField txtSearch = new JTextField();

    // Buttons
    public JButton btnAdd = new JButton("Add");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnSearch = new JButton("Search");

    // Table
    public JTable table;
    public DefaultTableModel tableModel;

    public AssetView() {

        setTitle("Asset Management System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ===== TOP PANEL =====
        JPanel panel = new JPanel(new GridLayout(9, 2));

        panel.add(new JLabel("Asset ID:")); panel.add(txtId);
        panel.add(new JLabel("Name:")); panel.add(txtName);
        panel.add(new JLabel("Category:")); panel.add(txtCategory);
        panel.add(new JLabel("Purchase Date:")); panel.add(txtDate);
        panel.add(new JLabel("Cost:")); panel.add(txtCost);
        panel.add(new JLabel("Status:")); panel.add(txtStatus);
        panel.add(new JLabel("Location:")); panel.add(txtLocation);
        panel.add(new JLabel("Description:")); panel.add(txtDescription);

        panel.add(btnAdd); panel.add(btnUpdate);

        add(panel, BorderLayout.NORTH);

        // ===== TABLE =====
        String[] columns = {"ID", "Name", "Category", "Date", "Cost", "Status", "Location", "Description"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        add(new JScrollPane(table), BorderLayout.CENTER);

        // ===== BOTTOM PANEL =====
        JPanel bottom = new JPanel();
        bottom.add(new JLabel("Search:"));
        bottom.add(txtSearch);
        bottom.add(btnSearch);
        bottom.add(btnDelete);

        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }
}
