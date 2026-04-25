package CCE_103;
//
//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
//import java.awt.Font;
//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
//import java.awt.GridLayout;
//
//import javax.swing.ButtonGroup;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JRadioButton;
//import javax.swing.border.EmptyBorder;
//
//public class OrderForm{
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLayout(new BorderLayout());
//		frame.setSize(510,620);
//		frame.setLocationRelativeTo(null);
//		
//		JPanel mainPanel = new JPanel();
//		mainPanel.setBorder(new EmptyBorder(20,20,20,20));
//		mainPanel.setLayout(new GridBagLayout());
//		GridBagConstraints c = new GridBagConstraints();
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.gridx = 0;
//		c.gridy = 0;
//		c.ipadx = 10;
//		c.ipady = 20;
//		JLabel coffeeLabel = new JLabel("Type of Coffee:");
//		coffeeLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
//		mainPanel.add(coffeeLabel, c);
//		
//		c.gridx = 1;
//		
//		JLabel coffeeTextLabel = new JLabel("TorreMocha");
//		coffeeTextLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
//		mainPanel.add(coffeeTextLabel, c);
//		c.gridx = 0;
//		c.gridy = 1;
//		c.weightx = 0;
////		c.fill = GridBagConstraints.NONE; 
////		c.anchor = GridBagConstraints.BASELINE_LEADING;
//		
//		JLabel sizeLabel = new JLabel("Size:");
//		sizeLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
//		mainPanel.add(sizeLabel, c);
//		
//		c.gridx = 1;
//		c.weightx = 3.0;
////		c.fill = GridBagConstraints.HORIZONTAL; 
//		
//		JPanel sizes = new JPanel(new GridLayout(1,4));
//		JRadioButton small = new JRadioButton("Small");
//		JRadioButton medium = new JRadioButton("Medium");
//		JRadioButton large = new JRadioButton("Large");
//		JRadioButton xl = new JRadioButton("Extra Large");
//		small.setFont(new Font("SansSerif", Font.BOLD, 13));
//		medium.setFont(new Font("SansSerif", Font.BOLD, 13));
//		large.setFont(new Font("SansSerif", Font.BOLD, 13));
//		xl.setFont(new Font("SansSerif", Font.BOLD, 13));
//		
//		ButtonGroup groupSize = new ButtonGroup();
//		groupSize.add(small);
//		groupSize.add(medium);
//		groupSize.add(large);
//		groupSize.add(xl);
//		
//		sizes.add(small);
//		sizes.add(medium);
//		sizes.add(large);
//		sizes.add(xl);
//		
//		mainPanel.add(sizes, c);
//		frame.add(mainPanel);
//		frame.setVisible(true);
//		
//	}
//	
//	
//}
//
//

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class OrderForm extends JFrame implements ActionListener{
	// Labels
	JLabel titleLabel;
	JLabel imageLabel;

	// RadioButtons
	JRadioButton small;
	JRadioButton medium;
	JRadioButton large;
	JRadioButton xl;

	JRadioButton unsweet;
	JRadioButton sugar;
	JRadioButton honey;
	JRadioButton stevia;

	JRadioButton hot;
	JRadioButton iced;

	// ButtonGroups
	ButtonGroup sizeGroup;
	ButtonGroup sweetGroup;
	ButtonGroup brewGroup;

	// CheckBoxes
	JCheckBox whippedBox;
	JCheckBox oreoBox;
	JCheckBox espressoBox;
	JCheckBox coffeBox;

	// ComboBoxes
	JComboBox<String> milkBox;
	JComboBox<String> syrupBox;

	// action Button
	JButton confirmBut;

	// Save All
	ArrayList<Object> data = new ArrayList<Object>();
	private TorreCafe_System parent;
	private int rowIndex;
	
	public OrderForm(String coffeeName, TorreCafe_System parent, int rowIndex) {
		this.parent = parent;
		this.rowIndex = rowIndex;
		
		// ========== Background Image ==========
		ImageIcon icon = new ImageIcon("caffeForm.PNG");
		Image image = icon.getImage().getScaledInstance(530, 590, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(image);

		imageLabel = new JLabel(scaledIcon); // set label to image

		// Main Frame
		setTitle("Order Form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setContentPane(imageLabel);
		imageLabel.setLayout(new BorderLayout());

		JPanel mainPanel = new JPanel(new GridBagLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 35, 25, 35));
		mainPanel.setOpaque(false);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 3, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// ================= Type of Coffee =================
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;
		mainPanel.add(new JLabel("Type of Coffee:"), gbc);

		gbc.gridx = 1;
		gbc.weightx = 1;
		titleLabel = new JLabel(coffeeName);
		mainPanel.add(titleLabel, gbc);

		// ================= Size =================
		gbc.gridy++;
		gbc.gridx = 0;
		gbc.weightx = 0;
		mainPanel.add(new JLabel("Size:"), gbc);

		gbc.gridx = 1;
		gbc.weightx = 4;

		JPanel sizePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		small = new JRadioButton("Small");
		medium = new JRadioButton("Medium");
		large = new JRadioButton("Large");
		xl = new JRadioButton("Extra Large");

		sizePanel.setOpaque(false);
		small.setOpaque(false);
		small.setFocusable(false);
		medium.setOpaque(false);
		medium.setFocusable(false);
		large.setOpaque(false);
		large.setFocusable(false);
		xl.setOpaque(false);
		xl.setFocusable(false);

		sizeGroup = new ButtonGroup();
		sizeGroup.add(small);
		sizeGroup.add(medium);
		sizeGroup.add(large);
		sizeGroup.add(xl);

		sizePanel.add(small);
		sizePanel.add(medium);
		sizePanel.add(large);
		sizePanel.add(xl);

		mainPanel.add(sizePanel, gbc);

		// ================= Milk =================
		gbc.gridy++;
		gbc.gridx = 0;
		gbc.weightx = 0;
		mainPanel.add(new JLabel("Milk:"), gbc);

		gbc.gridx = 1;
		gbc.weightx = 1;
		milkBox = new JComboBox<>(new String[]{
				"Soy milk", "Whole milk", "Almond milk"
		});
		mainPanel.add(milkBox, gbc);

		// ================= Syrup =================
		gbc.gridy++;
		gbc.gridx = 0;
		gbc.weightx = 0;
		mainPanel.add(new JLabel("Syrup:"), gbc);

		gbc.gridx = 1;
		gbc.weightx = 1;
		syrupBox = new JComboBox<>(new String[]{
				"Hazelnut Syrup", "Vanilla Syrup", "Caramel Syrup"
		});
		mainPanel.add(syrupBox, gbc);

		// ================= Sweetener =================
		gbc.gridy++;
		gbc.gridx = 0;
		gbc.weightx = 0;
		mainPanel.add(new JLabel("Sweetener:"), gbc);

		gbc.gridx = 1;
		gbc.weightx = 1;

		JPanel sweetPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		unsweet = new JRadioButton("Unsweetened");
		sugar = new JRadioButton("Sugar");
		honey = new JRadioButton("Honey");
		stevia = new JRadioButton("Stevia");

		sweetPanel.setOpaque(false);
		unsweet.setOpaque(false);
		unsweet.setFocusable(false);
		sugar.setOpaque(false);
		sugar.setFocusable(false);
		honey.setOpaque(false);
		honey.setFocusable(false);
		stevia.setOpaque(false);
		stevia.setFocusable(false);

		sweetGroup = new ButtonGroup();
		sweetGroup.add(unsweet);
		sweetGroup.add(sugar);
		sweetGroup.add(honey);
		sweetGroup.add(stevia);

		sweetPanel.add(unsweet);
		sweetPanel.add(sugar);
		sweetPanel.add(honey);
		sweetPanel.add(stevia);

		mainPanel.add(sweetPanel, gbc);

		// ================= Add-ons =================
		gbc.gridy++;
		gbc.gridx = 0;
		gbc.weightx = 0;
		mainPanel.add(new JLabel("Add-ons:"), gbc);

		gbc.gridx = 1;
		gbc.weightx = 3;

		//	    JPanel addonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
		JPanel checkBoxPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel checkBoxPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));

		whippedBox = new JCheckBox("Whipped Cream");
		oreoBox = new JCheckBox("Oreo Crumbs");
		espressoBox = new JCheckBox("Espresso Shot");
		coffeBox = new JCheckBox("Coffee Jelly");

		//	    addonPanel.setOpaque(false);
		checkBoxPanel1.setOpaque(false);
		checkBoxPanel2.setOpaque(false);

		whippedBox.setOpaque(false);
		whippedBox.setFocusable(false);
		oreoBox.setOpaque(false);
		oreoBox.setFocusable(false);
		espressoBox.setOpaque(false);
		espressoBox.setFocusable(false);
		coffeBox.setOpaque(false);
		coffeBox.setFocusable(false);

		checkBoxPanel1.add(whippedBox);
		checkBoxPanel1.add(oreoBox);
		checkBoxPanel2.add(espressoBox);
		checkBoxPanel2.add(coffeBox);

		//	    addonPanel.add(checkBoxPanel1);
		//	    addonPanel.add(checkBoxPanel2);
		mainPanel.add(checkBoxPanel1, gbc);

		gbc.gridy++;
		mainPanel.add(checkBoxPanel2, gbc);
		// ================= Type of Brew =================
		gbc.gridy++;
		gbc.gridx = 0;
		gbc.weightx = 0;
		mainPanel.add(new JLabel("Type of brew:"), gbc);

		gbc.gridx = 1;
		gbc.weightx = 1;

		// Brew Panel layout
		JPanel brewPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
		hot = new JRadioButton("Hot Coffee");
		iced = new JRadioButton("Iced Coffee");

		brewPanel.setOpaque(false);
		hot.setOpaque(false);
		hot.setFocusable(false);
		iced.setOpaque(false);
		iced.setFocusable(false);

		brewGroup = new ButtonGroup();
		brewGroup.add(hot);
		brewGroup.add(iced);

		brewPanel.add(hot);
		brewPanel.add(iced);

		mainPanel.add(brewPanel, gbc);

		// ================= Confirm Button =================
		gbc.gridy++;
		gbc.gridx = 1;
		gbc.gridwidth = 2;      // span both columns
		gbc.weightx = 3;

		confirmBut = new JButton("Confirm");
		confirmBut.setFocusable(false);
		mainPanel.add(confirmBut, gbc);

		pack();
		add(mainPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);

		confirmBut.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==confirmBut) {
			// radioButtons text
			String sizes = "";
			String sweets = "";
			String brew = "";
			// checkboxes text
			String whipped = "";
			String oreo = "";
			String espresso = "";
			String coffee = "";
			String none = "";
			// combo text
			String milkType = milkBox.getSelectedItem().toString();
			String syrupType = syrupBox.getSelectedItem().toString();

			// sizes
			if (small.isSelected()) {
				sizes = "small";
			} else if (medium.isSelected()) {
				sizes = "medium";
			} else if (large.isSelected()) {
				sizes = "large";
			} else if (xl.isSelected()) {
				sizes = "extra large";
			}

			// sweets 
			if (unsweet.isSelected()) {
				sweets = "unsweeted";
			} else if (sugar.isSelected()) {
				sweets = "sugar";
			} else if (honey.isSelected()) {
				sweets = "honey";
			} else if (stevia.isSelected()) {
				sweets = "stevia";
			}

			// brew
			if (hot.isSelected()) {
				brew = "hot";
			} else if (iced.isSelected()) {
				brew = "iced";
			}

			// CheckBox Part
			if (whippedBox.isSelected()) {
				whipped = "\n->Whipped Cream";
			} 
			if (oreoBox.isSelected()) {
				oreo = "\n->Oreo Crumbs";
			}
			if (espressoBox.isSelected()) {
				espresso = "\n->Espresso Shot";
			}
			if (coffeBox.isSelected()) {
				coffee = "\n->Coffee Jelly";
			}
			if (!whippedBox.isSelected() &&
					!oreoBox.isSelected() &&
					!espressoBox.isSelected() &&
					!coffeBox.isSelected()) {
				none = "No Add-ons";
			}
			
			double totalPrice = calculatePrice(
			        titleLabel.getText(),
			        sizes,
			        milkType,
			        syrupType,
			        sweets,
			        whippedBox.isSelected(),
			        oreoBox.isSelected(),
			        espressoBox.isSelected(),
			        coffeBox.isSelected(),
			        brew
			);
			
			String itemDescription = titleLabel.getText();

			if (!sizes.isEmpty()) {
			    itemDescription += " " + sizes;
			}

			// Milk
			itemDescription += " + " + milkType;

			// Syrup
			itemDescription += " + " + syrupType;

			// Sweetener
			if (sweets.equals("sugar")) {
			    itemDescription += " + with Sugar";
			} else if (sweets.equals("honey")) {
			    itemDescription += " + with Honey";
			} else if (sweets.equals("stevia")) {
			    itemDescription += " + with Stevia";
			}

			// Brew
			if (brew.equals("iced")) {
			    itemDescription += " + Iced";
			} else if (brew.equals("hot")) {
			    itemDescription += " + Hot";
			}

			// Add-ons
			if (whippedBox.isSelected()) 
				itemDescription += " + Whipped Cream";
			if (oreoBox.isSelected()) 
				itemDescription += " + Oreo Crumbs";
			if (espressoBox.isSelected()) 
				itemDescription += " + Espresso Shot";
			if (coffeBox.isSelected()) 
				itemDescription += " + Coffee Jelly";
			
			try {
				JOptionPane.showMessageDialog(this, "Order Transaction\n"
				        + "Type of Coffee: " + titleLabel.getText() + "\n"
				        + "Size: " + sizes + "\n"
				        + "Milk: " + milkType + "\n"
				        + "Syrup: " + syrupType + "\n"
				        + "Sweetener: " + sweets + "\n"
				        + "Add-ons: " + none + whipped + oreo + espresso + coffee + "\n"
				        + "Brew Type: " + brew + "\n\n"
				        + "TOTAL: ₱ " + totalPrice);
				parent.updateOrder(rowIndex, itemDescription, totalPrice);
				//				confirm();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, 
						"There is something wrong with Confirm Button",
						"Error Message",
						JOptionPane.ERROR_MESSAGE);
			} finally {
				dispose();
			}
		}
	}

	private double calculatePrice(String coffee, String size,
			String milk, String syrup, String sweet,
			boolean whipped, boolean oreo,
			boolean espresso, boolean jelly,
			String brew) {

		double price = 0;

		// ===== 1. BASE COFFEE PRICE (REALISTIC ₱40–₱90) =====
		switch (coffee) {
		case "TorreCappuccino": price = 65; break;
		case "TorreMocha": price = 75; break;
		case "TorreAmericano": price = 55; break;
		case "TorreExpresso": price = 50; break;
		case "TorreMacchiato": price = 70; break;
		default: price = 60;
		}

		// ===== 2. SIZE ADDITION =====
		switch (size) {
		case "small": price += 0; break;
		case "medium": price += 10; break;
		case "large": price += 20; break;
		case "extra large": price += 30; break;
		}

		// ===== 3. MILK (premium options cost more) =====
		if (milk.equals("Soy milk") || milk.equals("Almond milk")) {
			price *= 1.10;
		} else {
			price *= 1.05; // whole milk
		}

		// ===== 4. SYRUP =====
		if (!syrup.equals("None")) {
			price += 10;
		}

		// ===== 5. SWEETENER =====
		if (sweet.equals("honey") || sweet.equals("stevia")) {
			price += 5;
		}
		// sugar/unsweetened = free

		// ===== 6. ADD-ONS =====
		if (whipped) price += 15;
		if (oreo) price += 15;
		if (espresso) price += 20; // strong add-on
		if (jelly) price += 10;

		// ===== 7. BREW TYPE =====
		if (brew.equals("iced")) {
			price += 5; // ice cost
		}

		return price;
	}

	public void confirm() {
		try {
			JOptionPane.showMessageDialog(this, "Confirmed Successfully!");
			return;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Cannot Confirm", "Error Message", JOptionPane.ERROR_MESSAGE);
			return;
		} 
	}

}
