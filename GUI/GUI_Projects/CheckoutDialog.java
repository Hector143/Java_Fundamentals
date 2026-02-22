package GUI_Projects;

import javax.swing.*;

import model.OrderItem;

import java.awt.*;
import java.util.List;

public class CheckoutDialog extends JDialog {
    public CheckoutDialog(List<OrderItem> cart, double total) {
        setTitle("Checkout");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2, 5, 5));
        setLocationRelativeTo(null);

        JTextField cash = new JTextField();
        JLabel change = new JLabel("0.00");

        add(new JLabel("Total:"));
        add(new JLabel(String.format("%.2f", total)));
        add(new JLabel("Cash:"));
        add(cash);
        add(new JLabel("Change:"));
        add(change);

        JButton pay = new JButton("Pay");
        pay.addActionListener(e -> {
            try {
                double c = Double.parseDouble(cash.getText());
                if (c < total) {
                    JOptionPane.showMessageDialog(this, "Insufficient cash");
                } else {
                    change.setText(String.format("%.2f", c - total));
                    JOptionPane.showMessageDialog(this, "Payment Successful");
                    dispose();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid cash amount");
            }
        });

        add(new JLabel());
        add(pay);

        setModal(true);
        setVisible(true);
    }
}
