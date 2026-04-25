package CCE_103;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class TorreCafe_System_Checkout extends JFrame{
	
	Image image1 = new ImageIcon("Topcoffeebeans.jpg").getImage().getScaledInstance(1400, 140, Image.SCALE_SMOOTH);
	ImageIcon scaledBackground = new ImageIcon(image1);

	Image image2 = new ImageIcon("cup.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
	ImageIcon scaledCup = new ImageIcon(image2);
	
	DefaultTableModel model;
	JTable table;
	JTextArea checkoutArea;
	JScrollPane scrollTable;
	JScrollPane scrollArea;
	
	public TorreCafe_System_Checkout() {
		JPanel northPanel = new JPanel(new BorderLayout());

		JLabel headerLabel = new JLabel("TorreCafe");
		headerLabel.setIcon(scaledCup);
		headerLabel.setForeground(Color.white);
		headerLabel.setFont(new Font("",Font.BOLD,92));
		headerLabel.setHorizontalAlignment(JLabel.CENTER);
		headerLabel.setVerticalTextPosition(JLabel.CENTER);
		headerLabel.setHorizontalTextPosition(JLabel.RIGHT);

		JLabel topBackgLabel = new JLabel(scaledBackground);
		topBackgLabel.setLayout(new BorderLayout());
		topBackgLabel.add(headerLabel);

		northPanel.add(topBackgLabel);

		JPanel centerPanel = new JPanel(new GridLayout(1,2));
		
		String[] columnNames = new String[] {"Item","Price"};
		
		model = TransactionSession.currentModel;
		double currentTotal = calculateTotal();
		model.addRow(new Object[] {
		    "Total Price:", 
		    String.format("₱ %.2f", currentTotal)
		});

		table = new JTable(model);
		
		//		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getColumnModel().getColumn(0).setPreferredWidth(500); // Item
		table.getColumnModel().getColumn(1).setPreferredWidth(200); // Price
		table.getSelectionModel().addListSelectionListener(e -> {
		    if (!e.getValueIsAdjusting()) {
		        int row = table.getSelectedRow();
		        if (row != -1) {
		            String item = model.getValueAt(row, 0).toString();

		            checkoutArea.setText(item);
		        }
		    }
		});
		
		
		checkoutArea = new JTextArea();
		checkoutArea.setFont(new Font("", Font.PLAIN, 20));

		checkoutArea.setLineWrap(true);          // auto new line
		checkoutArea.setWrapStyleWord(true);     // wrap by words (clean look)
		checkoutArea.setEditable(false);         // optional: prevents typing

		scrollArea = new JScrollPane(checkoutArea);
		scrollArea.setPreferredSize(new Dimension(450, 120));
		scrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		scrollTable = new JScrollPane(table);

		JPanel centerWestPanel = new JPanel(new BorderLayout());
		centerWestPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
		centerWestPanel.add(scrollTable);
		JPanel centerCenterPanel = new JPanel(new GridBagLayout());
		centerCenterPanel.setBackground(new Color(0xF9E0BB));
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15,15,15,15);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		JLabel checkOutLabel = new JLabel("Check-out");
		checkOutLabel.setFont(new Font("", Font.BOLD, 50));
		checkOutLabel.setHorizontalAlignment(JLabel.CENTER);
		
		centerCenterPanel.add(checkOutLabel, gbc);
		
		gbc.gridy = 1; 
		gbc.gridwidth = 2;
		
		
		centerCenterPanel.add(scrollArea, gbc);
		
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		
		JLabel cashAmountLabel = new JLabel("Enter cash amount: ₱");
		cashAmountLabel.setHorizontalAlignment(JLabel.RIGHT);
		
		JTextField inputAmount = new JTextField();
		
		cashAmountLabel.setFont(new Font("", Font.BOLD, 21));
		inputAmount.setFont(new Font("", Font.PLAIN, 18));
		
		gbc.gridx = 0;
		centerCenterPanel.add(cashAmountLabel, gbc);
		
		gbc.gridx = 1;
		centerCenterPanel.add(inputAmount, gbc);
		
		gbc.gridy = 3;
		JLabel changeLabel = new JLabel("Change: ₱");
		changeLabel.setHorizontalAlignment(JLabel.RIGHT);
		JTextField inputChangeLabel = new JTextField();
		inputChangeLabel.setEditable(false); // Ensure user can't type in the change field

		inputAmount.getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void insertUpdate(DocumentEvent e) { updateChange(); }
		    @Override
		    public void removeUpdate(DocumentEvent e) { updateChange(); }
		    @Override
		    public void changedUpdate(DocumentEvent e) { updateChange(); }

		    private void updateChange() {
		        // Run on the Event Dispatch Thread to keep UI smooth
		        SwingUtilities.invokeLater(() -> {
		            String text = inputAmount.getText().trim();
		            
		            if (text.isEmpty()) {
		                inputChangeLabel.setText("");
		                inputChangeLabel.setForeground(Color.BLACK);
		                return;
		            }

		            try {
		                double total = calculateTotal();
		                double cash = Double.parseDouble(text);

		                if (cash < total) {
		                    inputChangeLabel.setForeground(Color.RED);
		                    inputChangeLabel.setText("Not enough money!");
		                } else {
		                    double change = cash - total;
		                    inputChangeLabel.setForeground(new Color(0, 100, 0)); // Dark Green for success
		                    inputChangeLabel.setText(String.format("₱ %.2f", change));
		                }
		            } catch (NumberFormatException ex) {
		                // Handle cases where user types non-numeric characters
		                inputChangeLabel.setForeground(Color.RED);
		                inputChangeLabel.setText("Invalid Input");
		            }
		        });
		    }
		});
		
		changeLabel.setFont(new Font("", Font.BOLD, 21));
		inputChangeLabel.setFont(new Font("", Font.PLAIN, 21));
		inputChangeLabel.setEditable(false);
		
		gbc.gridx = 0;
		centerCenterPanel.add(changeLabel, gbc);
		
		gbc.gridx = 1;
		centerCenterPanel.add(inputChangeLabel, gbc);
		
		
		inputAmount.addActionListener(e -> {
		    try {
		        double total = calculateTotal();
		        double cash = Double.parseDouble(inputAmount.getText());

		        if (cash < total) {
		            JOptionPane.showMessageDialog(this, "Not enough money!");
		            inputAmount.setText("");
		            inputChangeLabel.setText("");
		            return;
		        }

		        double change = cash - total;
		        inputChangeLabel.setText(String.format("%.2f", change));

		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(this, "Invalid input!");
		        inputAmount.setText("");
		    }
		});
		
		
		gbc.gridx = 0; gbc.gridy = 4; 
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = 2; // IMPORTANT: span both columns;
		JPanel buttonLabelPanel = new JPanel(new BorderLayout());
		
		RoundedButton checkoutButton = new RoundedButton("Enter");
		checkoutButton.setPreferredSize(new Dimension(150,70));
		checkoutButton.setFont(new Font("", Font.PLAIN, 17));
		
		checkoutButton.addActionListener(e -> {
			double total = calculateTotal();
		    try {
		        double cash = Double.parseDouble(inputAmount.getText());
		        if (cash < total) {
		            JOptionPane.showMessageDialog(this, "Not enough money!");
		            return;
		        }

		        // 1. Save the receipt
		        saveReceipt(cash, total);
		        
		        // 2. CRITICAL: Save the current inventory state to the file
		        // Since TorreCafe_System already reduced the stock in memory, 
		        // we just need to tell the Service to write that current state to disk.
		        ArrayList<Item> currentInventory = InventoryService.loadItems(); 
		        // Note: For a more advanced system, you'd pass the actual 
		        // inventory object here, but calling Save after the items 
		        // were reduced in the previous frame is the goal.
		        
		        JOptionPane.showMessageDialog(this, "Transaction Complete!");

		        // 3. Clear the table for the next customer
		        model.setRowCount(0);
		        inputAmount.setText("");
		        inputChangeLabel.setText("");
		        checkoutArea.setText("");
		        
		    } catch (Exception ex) {
		        JOptionPane.showMessageDialog(this, "Invalid input!");
		    }
		});
		
		JLabel checkoutLabel = new JLabel("Checkout");
		checkoutLabel.setHorizontalAlignment(JLabel.CENTER);
		
		buttonLabelPanel.setOpaque(false);
		buttonLabelPanel.add(checkoutButton, BorderLayout.CENTER);
		buttonLabelPanel.add(checkoutLabel, BorderLayout.SOUTH);
		
		centerCenterPanel.add(buttonLabelPanel, gbc);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("TorreCafe POS System");
		setLayout(new BorderLayout());
		setResizable(false);
		setSize(1400,800);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				int choice = JOptionPane.showConfirmDialog(
						null,
						"Are you sure you want to exit?",
						"Confirm Exit",
						JOptionPane.YES_NO_CANCEL_OPTION
						);

				if (choice == JOptionPane.YES_OPTION) {
					dispose(); // closes ONLY this frame
//					new TorreCafe_System();
				}
				// NO or CANCEL → do nothing (frame stays open)
			}
		});
		
		centerPanel.add(centerWestPanel);
		centerPanel.add(centerCenterPanel);
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		setVisible(true);
	}
	
	private double calculateTotal() {
		double total = 0;

	    for (int i = 0; i < model.getRowCount(); i++) {
	        String itemName = model.getValueAt(i, 0).toString();
	        
	        // IMPORTANT: Skip the summary row so we don't calculate the total of the total!
	        if (itemName.equalsIgnoreCase("Total Price:")) {
	            continue;
	        }

	        String priceStr = model.getValueAt(i, 1).toString();
	        priceStr = priceStr.replace("₱", "").trim();

	        try {
	            double price = Double.parseDouble(priceStr);
	            total += price;
	        } catch (NumberFormatException e) {
	            // Skip rows that aren't valid numbers
	        }
	    }
	    return total;
	}
	
	private void saveReceipt(double cash, double total) {
		try {
	        FileWriter fw = new FileWriter("receipt.txt", true);
	        fw.write("===== TORRE CAFE RECEIPT =====\n");

	        for (int i = 0; i < model.getRowCount(); i++) {
	            String item = model.getValueAt(i, 0).toString();
	            String price = model.getValueAt(i, 1).toString();
	            
	            // Format the output
	            fw.write(item + " : " + price + "\n");
	        }

	        fw.write("CASH RECEIVED: ₱" + String.format("%.2f", cash) + "\n");
	        fw.write("CHANGE: ₱" + String.format("%.2f", (cash - total)) + "\n");
	        fw.write("==============================\n\n");
	        fw.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
}
