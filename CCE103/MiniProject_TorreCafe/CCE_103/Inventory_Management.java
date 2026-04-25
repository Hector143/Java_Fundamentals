package CCE_103;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Inventory_Management {
    public JFrame frame = new JFrame();
    public DefaultTableModel model;
    private ArrayList<Item> inventory;
    
    // Summary Labels
    private JLabel totalStatsLabel = new JLabel("Sales/Profit: ₱0.00");
    private JLabel avgStatsLabel = new JLabel("Avg Price: ₱0.00");
    private JLabel lowStockLabel = new JLabel("Low Stock: 0");

    public Inventory_Management() {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Inventory Management");
        
        // LOAD Inventory here instead of TorreCafe_System
        refreshData();

        JPanel mainPanel = new JPanel(new BorderLayout());

        // TOP PANEL with 3 Sub-Panels
        JPanel topPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        topPanel.setPreferredSize(new Dimension(1100, 150));
        
        topPanel.add(createStatPanel("Total Financials", totalStatsLabel, new Color(0xF9E0BB)));
        topPanel.add(createStatPanel("Averages", avgStatsLabel, new Color(0xD1B893)));
        topPanel.add(createStatPanel("Stock Alerts", lowStockLabel, new Color(0x828294)));

        // Table Setup
        String[] columnNames = {"ID", "Item", "Price", "Quantity"};
        model = new DefaultTableModel(columnNames, 0) {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        
        updateTable();

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(buildTable(), BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton edit = new JButton("Edit Quantity");
        JButton back = new JButton("Back");
        
        edit.addActionListener(e -> {
            // Logic to edit quantity of selected row
            int row = ((JTable)((JViewport)((JScrollPane)mainPanel.getComponent(1)).getComponent(0)).getComponent(0)).getSelectedRow();
            if(row != -1) {
                String newQty = JOptionPane.showInputDialog("Enter new quantity for " + model.getValueAt(row, 1));
                if(newQty != null) {
                    inventory.get(row).setStock(Integer.parseInt(newQty));
                    InventoryService.saveItems(inventory);
                    refreshData();
                }
            }
        });
        
        back.addActionListener(e -> frame.dispose());
        
        buttonPanel.add(edit);
        buttonPanel.add(back);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setSize(1100, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createStatPanel(String title, JLabel valueLabel, Color bg) {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(bg);
        JLabel titleLabel = new JLabel(title, JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        
        valueLabel.setHorizontalAlignment(JLabel.CENTER);
        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
        
        p.add(titleLabel, BorderLayout.NORTH);
        p.add(valueLabel, BorderLayout.CENTER);
        return p;
    }

    public void refreshData() {
        this.inventory = InventoryService.loadItems();
        updateSummaryLabels();
        if (model != null) updateTable();
    }

    private void updateSummaryLabels() {
        double totalValue = 0;
        int lowStockCount = 0;
        for (Item item : inventory) {
            totalValue += (item.getPrice() * item.getStock());
            if (item.getStock() < 5) lowStockCount++; // Example low stock threshold [cite: 213]
        }
        totalStatsLabel.setText("Inv Value: ₱" + String.format("%.2f", totalValue));
        avgStatsLabel.setText("Avg: ₱" + String.format("%.2f", totalValue/inventory.size()));
        lowStockLabel.setText("Low Stock: " + lowStockCount);
    }

    private void updateTable() {
        model.setRowCount(0);
        for (int i = 0; i < inventory.size(); i++) {
            Item itm = inventory.get(i);
            model.addRow(new Object[]{i + 1, itm.getName(), "₱ " + itm.getPrice(), itm.getStock()});
        }
    }

    private JScrollPane buildTable() {
        JTable table = new JTable(model);
        // ... (Keep your existing table styling code here)
        table.setRowHeight(40);
        JScrollPane scroll = new JScrollPane(table);
        return scroll;
    }

	public Window getFrame() {
		return frame;
	}
}