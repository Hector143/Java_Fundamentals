package GUI_Projects;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class ReceiptGUI {

    public static void main(String[] args) {

        // Create frame
        JFrame frame = new JFrame("Receipt");
        frame.setSize(350, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // center screen

        // Create panel with border
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        TitledBorder border = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2),
                "Receipt",
                TitledBorder.LEFT,
                TitledBorder.TOP
//                new Font("Arial", Font.BOLD, 14)
                
        ); 
        panel.setBorder(border);

        // Create text area (receipt content)
        JTextArea receiptArea = new JTextArea();
//        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 14)); 
        receiptArea.setEditable(false);

        // Add receipt text
        receiptArea.setText(
                "Receipt\n" +
                "==================================================\n" +
                "Months Rented\n\n" +
                "Rent Subtotal:        P8000.00\n" +
                "Discount:             P0.00\n\n" +
                "Utilities:\n" +
                "  Electricity:        P1000.00\n" +
                "  Water:              P100.00\n" +
                "  Internet:           P150.00\n" +
                "---------------------------------\n" +
                "VAT (12%):            P960.00\n" +
                "TOTAL DUE:            P10210.00\n\n" +
                "Cash:                 P12000.00\n" +
                "Change:               P1790.00\n" +
                "=================================\n" +
                "Thank you for your payment!"
        );

        // Add scroll pane (so it looks like your image)
        JScrollPane scrollPane = new JScrollPane(receiptArea);

        // Add scrollpane to panel
        panel.add(scrollPane, BorderLayout.CENTER);

        // Add panel to frame
        frame.add(panel);

        frame.setVisible(true);
    }
}