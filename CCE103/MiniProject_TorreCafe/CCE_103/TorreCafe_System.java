package CCE_103;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

public class TorreCafe_System extends JFrame{

	// Top Panel
	Image image1 = new ImageIcon("Topcoffeebeans.jpg").getImage().getScaledInstance(1400, 140, Image.SCALE_SMOOTH);
	ImageIcon scaledBackground = new ImageIcon(image1);

	Image image2 = new ImageIcon("cup.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
	ImageIcon scaledCup = new ImageIcon(image2);

	Image imgCoffee1 = new ImageIcon("coffee1.jpg").getImage().getScaledInstance(230, 190, Image.SCALE_SMOOTH);
	ImageIcon scaledCoffee1 = new ImageIcon(imgCoffee1);

	Image imgCoffee2 = new ImageIcon("coffee2.png").getImage().getScaledInstance(230, 190, Image.SCALE_SMOOTH);
	ImageIcon scaledCoffee2 = new ImageIcon(imgCoffee2);

	Image imgCoffee3 = new ImageIcon("coffee3.jpg").getImage().getScaledInstance(230, 190, Image.SCALE_SMOOTH);
	ImageIcon scaledCoffee3 = new ImageIcon(imgCoffee3);

	Image imgCoffee4 = new ImageIcon("coffee4.jpg").getImage().getScaledInstance(230, 190, Image.SCALE_SMOOTH);
	ImageIcon scaledCoffee4 = new ImageIcon(imgCoffee4);

	Image imgCoffee5 = new ImageIcon("coffee5.jpg").getImage().getScaledInstance(230, 190, Image.SCALE_SMOOTH);
	ImageIcon scaledCoffee5 = new ImageIcon(imgCoffee5);

	Image imgCoffee6 = new ImageIcon("coffee6.jpeg").getImage().getScaledInstance(230, 190, Image.SCALE_SMOOTH);
	ImageIcon scaledCoffee6 = new ImageIcon(imgCoffee6);

	Image imgCoffee7 = new ImageIcon("coffee7.jpg").getImage().getScaledInstance(230, 190, Image.SCALE_SMOOTH);
	ImageIcon scaledCoffee7 = new ImageIcon(imgCoffee7);

	Image imgCoffee8 = new ImageIcon("coffee8.jpg").getImage().getScaledInstance(230, 190, Image.SCALE_SMOOTH);
	ImageIcon scaledCoffee8 = new ImageIcon(imgCoffee8);

	Image imgCoffee9 = new ImageIcon("coffee9.jpg").getImage().getScaledInstance(230, 190, Image.SCALE_SMOOTH);
	ImageIcon scaledCoffee9 = new ImageIcon(imgCoffee9);

	Image imgCoffee10 = new ImageIcon("coffee10.jpg").getImage().getScaledInstance(230, 190, Image.SCALE_SMOOTH);
	ImageIcon scaledCoffee10 = new ImageIcon(imgCoffee10);

	Image imgCoffee11 = new ImageIcon("coffee11.jpg").getImage().getScaledInstance(230, 190, Image.SCALE_SMOOTH);
	ImageIcon scaledCoffee11 = new ImageIcon(imgCoffee11);

	Image imgCoffee12 = new ImageIcon("coffee12.jpg").getImage().getScaledInstance(230, 190, Image.SCALE_SMOOTH);
	ImageIcon scaledCoffee12 = new ImageIcon(imgCoffee12);

	Image imgButton1 = new ImageIcon("f10but.png").getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	ImageIcon scaledButton1 = new ImageIcon(imgButton1);

	Image imgButton2 = new ImageIcon("f11but.png").getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	ImageIcon scaledButton2 = new ImageIcon(imgButton2);

	Image imgButton3 = new ImageIcon("f12but.png").getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	ImageIcon scaledButton3 = new ImageIcon(imgButton3);

	Image imgButton4 = new ImageIcon("escbut.png").getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	ImageIcon scaledButton4 = new ImageIcon(imgButton4);

	Image imgButton5 = new ImageIcon("enterbut.png").getImage().getScaledInstance(160, 70, Image.SCALE_SMOOTH);
	ImageIcon scaledButton5 = new ImageIcon(imgButton5);

	DefaultTableModel model;
	JTable table;
	JTextArea textOutputArea;
	JScrollPane scrollTable;
	JScrollPane scrollCoffees;
	JScrollPane scrollOutputs;

	String[] coffeNames = new String[] {
			"TorreCappuccino","TorreMocha","TorreAmericano",
			"TorreExpresso","TorreMacchiato","TorreLatte1",
			"TorreLatte2","TorreFlatWhite","TorreTurkish",
			"TorreCortado","TorreAffogato","TorreMarshmallowLatte"
	};

	ImageIcon[] images = new ImageIcon[] {
			scaledCoffee1,scaledCoffee2,scaledCoffee3,
			scaledCoffee4,scaledCoffee5,scaledCoffee6,
			scaledCoffee7,scaledCoffee8,scaledCoffee9,
			scaledCoffee10,scaledCoffee11,scaledCoffee12
	};

	ArrayList<Item> inventory = new ArrayList<>();

	public TorreCafe_System() {
		
		inventory = InventoryService.loadItems();
		
		if (inventory.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "No inventory found. Please contact Admin.");
	    }
		/// the inventoryService or should not be added here directly instead add it in the inventoyr management,
		///and just pass the added coffess and price and its quantity it in here.

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

		JPanel centerPanel = new JPanel(new BorderLayout());

		String[] columnNames = new String[] {"Item","Price"};
		model = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		TransactionSession.currentModel = model;
		table = new JTable(model);
		//		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getColumnModel().getColumn(0).setPreferredWidth(300); // Item
		table.getColumnModel().getColumn(1).setPreferredWidth(100); // Price
		scrollTable = new JScrollPane(table);

		JPanel centerWestPanel = new JPanel(new BorderLayout());
		centerWestPanel.add(scrollTable);
		JPanel centerCenterPanel = new JPanel(new GridLayout(4,3,5,5));
		centerCenterPanel.setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 50));
		centerCenterPanel.setBackground(new Color(0xF9E0BB));

		for (int i = 0; i < coffeNames.length; i++) {
			centerCenterPanel.add(createCoffeeButton(coffeNames[i], images[i]));
		}

		scrollCoffees = new JScrollPane(centerCenterPanel);
		centerPanel.add(centerWestPanel, BorderLayout.WEST);
		centerPanel.add(scrollCoffees, BorderLayout.CENTER);

		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 70 , 5));
		southPanel.setBackground(Color.LIGHT_GRAY);
		southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

		textOutputArea = new JTextArea();
		textOutputArea.setFont(new Font("", Font.PLAIN, 20));

		textOutputArea.setLineWrap(true);          // auto new line
		textOutputArea.setWrapStyleWord(true);     // wrap by words (clean look)
		textOutputArea.setEditable(false);         // optional: prevents typing

		scrollOutputs = new JScrollPane(textOutputArea);
		scrollOutputs.setPreferredSize(new Dimension(450, 120));
		scrollOutputs.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollOutputs.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		table.getSelectionModel().addListSelectionListener(e -> {
		    if (!e.getValueIsAdjusting()) {
		        int row = table.getSelectedRow();

		        if (row != -1) {
		            String item = model.getValueAt(row, 0).toString();

		            textOutputArea.setText(item);
		        }
		    }
		});
		
		
		RoundedButton f10But = new RoundedButton("F10");
		RoundedButton f11But = new RoundedButton("F11");
		RoundedButton f12But = new RoundedButton("F12");
		RoundedButton escBut = new RoundedButton("Esc");
		RoundedButton enterBut = new RoundedButton("↵Enter");

		f10But.setPreferredSize(new Dimension(70,70));
		f11But.setPreferredSize(new Dimension(70,70));
		f12But.setPreferredSize(new Dimension(70,70));
		escBut.setPreferredSize(new Dimension(70,70));
		enterBut.setPreferredSize(new Dimension(160,70));

		f10But.setFont(new Font("", Font.PLAIN, 20));
		f11But.setFont(new Font("", Font.PLAIN, 20));
		f12But.setFont(new Font("", Font.PLAIN, 20));
		escBut.setFont(new Font("", Font.PLAIN, 20));
		enterBut.setFont(new Font("", Font.PLAIN, 20));

		f10But.addActionListener(e -> editItemAction());
		f11But.addActionListener(e -> duplicateItemAction());
		f12But.addActionListener(e -> voidItemAction());
		escBut.addActionListener(e -> {
			dispose();
			new TorreCafe_Login();
		});
		enterBut.addActionListener(e -> {
			int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you are going to checkout?", "Confirm", JOptionPane.YES_NO_OPTION);
		    if (confirm != JOptionPane.YES_OPTION) {
		    	return;
		    }
			new TorreCafe_System_Checkout();
		});
		
		JLabel editLabel = new JLabel("Edit Item");
		JLabel dupLabel = new JLabel("Duplicate Item");
		JLabel voidLabel = new JLabel("Void Item");
		JLabel returnLabel = new JLabel("Return");
		JLabel checkoutLabel = new JLabel("Checkout");

		editLabel.setVerticalAlignment(JLabel.TOP);
		dupLabel.setVerticalAlignment(JLabel.TOP);
		voidLabel.setVerticalAlignment(JLabel.TOP);
		returnLabel.setVerticalAlignment(JLabel.TOP);
		checkoutLabel.setVerticalAlignment(JLabel.TOP);

		editLabel.setHorizontalAlignment(JLabel.CENTER);
		dupLabel.setHorizontalAlignment(JLabel.CENTER);
		voidLabel.setHorizontalAlignment(JLabel.CENTER);
		returnLabel.setHorizontalAlignment(JLabel.CENTER);
		checkoutLabel.setHorizontalAlignment(JLabel.CENTER);

		JPanel buttonsPanel = new JPanel(new GridLayout(2,4, 30, 5));
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
		buttonsPanel.setOpaque(false);
		buttonsPanel.add(f10But);
		buttonsPanel.add(f11But);
		buttonsPanel.add(f12But);
		buttonsPanel.add(escBut);
		buttonsPanel.add(editLabel);
		buttonsPanel.add(dupLabel);
		buttonsPanel.add(voidLabel);
		buttonsPanel.add(returnLabel);
		
		southPanel.add(scrollOutputs);
		southPanel.add(buttonsPanel);
		southPanel.add(enterBut);

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
					new TorreCafe_Login();
				}

				// NO or CANCEL → do nothing (frame stays open)
			}
		});
		JPanel mainPanel = new JPanel(new BorderLayout());

		JPanel receiptPanel = new JPanel(new BorderLayout());
		receiptPanel.setOpaque(false);
		receiptPanel.setVisible(false);

		mainPanel.add(northPanel,BorderLayout.NORTH);
		mainPanel.add(centerPanel,BorderLayout.CENTER);
		mainPanel.add(southPanel,BorderLayout.SOUTH);

		add(mainPanel);
		//		add(receiptPanel);
		addKeyBindings();
		setVisible(true);
	}

	private JButton createCoffeeButton(String name, ImageIcon icon) {
		JButton btn = new JButton(name, icon);

		btn.setHorizontalTextPosition(JButton.CENTER);
		btn.setVerticalTextPosition(JButton.BOTTOM);
		btn.setFocusable(false);
		btn.setOpaque(false);
		btn.setContentAreaFilled(false);

		btn.addActionListener(e -> {
			Item item = findItem(name);

			if (item == null) {
				JOptionPane.showMessageDialog(this, "Item not found!");
				return;
			}

			if (item.getStock() <= 0) {
				JOptionPane.showMessageDialog(this, "Out of stock!");
				return;
			}

			// Prevent duplicate
			if (isItemAlreadyInTable(item.getName())) {
				JOptionPane.showMessageDialog(this, "Item already added! Use DUPLICATE (F11)");
				return;
			}

			// Confirmation
			int confirm = JOptionPane.showConfirmDialog(
					this,
					"Add " + item.getName() + "?",
					"Confirm Order",
					JOptionPane.YES_NO_OPTION
					);

			if (confirm != JOptionPane.YES_OPTION) return;

			item.reduceStock();
			InventoryService.saveItems(inventory);

			model.addRow(new Object[]{
					item.getName(),
					"₱ " + item.getPrice()
			});
		});

		return btn;
	}

	private boolean isItemAlreadyInTable(String itemName) {
		for (int i = 0; i < model.getRowCount(); i++) {
			if (model.getValueAt(i, 0).equals(itemName)) {
				return true;
			}
		}
		return false;
	}

	private void addKeyBindings() {
		JRootPane root = this.getRootPane();

		InputMap im = root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = root.getActionMap();


		// F10 → Edit
		im.put(KeyStroke.getKeyStroke("F10"), "edit");
		am.put("edit", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openEditForm();
			}
		});

		// F11 → Duplicate
		im.put(KeyStroke.getKeyStroke("F11"), "duplicate");
		am.put("duplicate", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				duplicateSelectedItem();
			}
		});

		// F12 → Void
		im.put(KeyStroke.getKeyStroke("F12"), "void");
		am.put("void", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				voidSelectedItem();
			}
		});


		// ENTER → Checkout
		im.put(KeyStroke.getKeyStroke("ENTER"), "checkout");
		am.put("checkout", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Checkout soon");
			}
		});

		// ESC → Back to login
		im.put(KeyStroke.getKeyStroke("ESCAPE"), "exit");
		am.put("exit", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TorreCafe_Login();
			}
		});
	}

	private void openEditForm() {
		int row = table.getSelectedRow();

		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Select an item to edit!");
			return;
		}

		String itemName = model.getValueAt(row, 0).toString();

		new OrderForm(itemName, this, row); // pass data
	}

	private void duplicateSelectedItem() {
	    int row = table.getSelectedRow();

	    if (row == -1) {
	        JOptionPane.showMessageDialog(this, "Select item to duplicate!");
	        return;
	    }

	    // get full displayed text
	    String fullText = model.getValueAt(row, 0).toString();
	    String price = model.getValueAt(row, 1).toString();

	    // extract BASE NAME only (first word group fix)
	    String baseName = fullText.split(" ")[0];

	    Item item = findItem(baseName);

	    if (item == null) {
	        JOptionPane.showMessageDialog(this, "Item not found!");
	        return;
	    }

	    if (item.getStock() <= 0) {
	        JOptionPane.showMessageDialog(this, "Out of stock!");
	        return;
	    }

	    item.reduceStock();
	    InventoryService.saveItems(inventory);

	    model.addRow(new Object[]{
	        fullText,   // keep edited display text
	        price       // keep exact price
	    });
	}
	
	public void updateOrder(int row, String itemDesc, double price) {
	    model.setValueAt(itemDesc, row, 0); // Item column
	    model.setValueAt("₱ " + price, row, 1); // Price column
	}
	
	private void voidSelectedItem() {
		int row = table.getSelectedRow();

		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Select item to void!");
			return;
		}

		String fullText = model.getValueAt(row, 0).toString();

		int confirm = JOptionPane.showConfirmDialog(
				this,
				"Void " + fullText + "?",
				"Confirm Void",
				JOptionPane.YES_NO_OPTION
				);

		if (confirm != JOptionPane.YES_OPTION) return;

		// restore stock
		String baseName = fullText.split(" ")[0];

		Item item = findItem(baseName);
		if (item != null) {
			item.addStock(1); // IMPORTANT: you must have this method
		}

		// remove from table
		model.removeRow(row);

		// save inventory
		InventoryService.saveItems(inventory);

		JOptionPane.showMessageDialog(this, "Item voided successfully.");
	}

	private Item findItem(String name) {
		for (Item item : inventory) {
			if (item.getName().equalsIgnoreCase(name)) {
				return item;
			}
		}
		return null; // if not found
	}

	private void editItemAction() {
		openEditForm();
	}

	private void duplicateItemAction() {
		duplicateSelectedItem();
	}

	private void voidItemAction() {
		voidSelectedItem();
	}
	
}
