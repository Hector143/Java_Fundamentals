package GUI_Projects;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class ApartmentSystemUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Apartment Rent Billing System");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(2, 2, 10, 10));

        // =========================
        // TENANT INFORMATION PANEL
        // =========================
        JPanel tenantPanel = new JPanel();
        tenantPanel.setLayout(new GridLayout(5, 2, 5, 5));
        tenantPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2),
                "Tenant Information"
        ));

        tenantPanel.add(new JLabel("Tenant Name:"));
        tenantPanel.add(new JTextField("Jaidee Ramil"));

        tenantPanel.add(new JLabel("Apartment Type:"));
        tenantPanel.add(new JComboBox<>(new String[]{"Studio", "1 Bedroom"}));

        tenantPanel.add(new JLabel("Tenant Category:"));
        tenantPanel.add(new JComboBox<>(new String[]{"Regular", "VIP"}));

        tenantPanel.add(new JLabel("Months Rented:"));
        tenantPanel.add(new JTextField("1"));

        tenantPanel.add(new JLabel("Monthly Rent:"));
        tenantPanel.add(new JTextField("8000"));

        // =========================
        // BILLING SUMMARY PANEL
        // =========================
        JPanel summaryPanel = new JPanel();
        summaryPanel.setLayout(new BorderLayout());
        summaryPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2),
                "Billing Summary"
        ));

        JTextArea summaryArea = new JTextArea();
        summaryArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        summaryArea.setEditable(false);

        summaryArea.setText(
                "Rents Subtotal:  P8000.00\n" +
                "Discount:        P0.00\n" +
                "Utilities total: P2600.00\n" +
                "VAT (12%):       P960.00\n" +
                "TOTAL DUE:       P11560.00\n" +
                "Change:          P440.00"
        );

        summaryPanel.add(summaryArea);

        // =========================
        // RECEIPT PANEL (LIKE IMAGE)
        // =========================
        JPanel receiptPanel = new JPanel();
        receiptPanel.setLayout(new BorderLayout());
        receiptPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2),
                "Receipt"
        ));

        JTextArea receiptArea = new JTextArea();
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        receiptArea.setEditable(false);

        receiptArea.setText(
                "APARTMENT RENT RECEIPT\n" +
                "=================================\n\n" +
                "Tenant Name:   JAIDEE RAMIL\n" +
                "Apartment:     STUDIO\n" +
                "Tenant Type:   REGULAR\n\n" +
                "Monthly Rent:  P8000.00\n" +
                "Months Rented: 1\n" +
                "Rent Subtotal: P8000.00\n" +
                "Discount:      P0.00\n\n" +
                "Utilities:\n" +
                "  Electricity: P1000.00\n" +
                "  Water:       P100.00\n" +
                "  Internet:    P1500.00\n" +
                "---------------------------------\n" +
                "VAT (12%):     P960.00\n" +
                "TOTAL DUE:     P11560.00\n\n" +
                "Cash:          P12000.00\n" +
                "Change:        P440.00\n\n" +
                "=================================\n" +
                "Thank you for your payment!"
        );

        JScrollPane scrollPane = new JScrollPane(receiptArea);
        receiptPanel.add(scrollPane, BorderLayout.CENTER);

        // =========================
        // BUTTON PANEL
        // =========================
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        buttonPanel.add(new JButton("Compute Rent"));
        buttonPanel.add(new JButton("Generate Receipt"));
        buttonPanel.add(new JButton("Clear"));
        buttonPanel.add(new JButton("Exit"));

        // =========================
        // ADD TO FRAME
        // =========================
        frame.add(tenantPanel);
        frame.add(summaryPanel);
        frame.add(receiptPanel);
        frame.add(buttonPanel);

        frame.setVisible(true);
    }
}
