package Transaction_and_Inventory_System.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Transaction_and_Inventory_System.Controllers.CRUDS;
import Transaction_and_Inventory_System.Model.Product;

public class mainWindow extends JFrame implements ActionListener{
	public JLabel idLabel;
	public JLabel nameLabel;
	public JLabel categoryLabel;
	public JLabel priceLabel;
	public JLabel quantityLabel;
	public JLabel supplierLabel;
	public JLabel statusLabel;
	public JLabel notesLabel;

	public JTextField txtId;
	public JTextField txtName;
	public JTextField txtPrice;
	public JTextField txtQuantity;
	public JTextField txtSupplier;
	public JTextField txtNotes;

	public JComboBox<String> selectCategory, selectStatus;

	public DefaultTableModel model;
	public JTable table;
	public JScrollPane scroll;

	public JButton createBut;
	public JButton readBut;
	public JButton updateBut;
	public JButton deleteBut;
	public JButton searchBut;

	public static ArrayList<Product> productList;

	public mainWindow() {
		productList = new ArrayList<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle("Sales Transaction and Inventory Records");

		// TOP side
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setBackground(new Color(35,65,110));
		JLabel headerLabel = new JLabel("Managing Sales and Inventory Records");
		headerLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		headerLabel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		headerLabel.setForeground(Color.white);
		headerLabel.setHorizontalAlignment(JLabel.CENTER);

		JPanel inputPanel = new JPanel(new GridLayout(8,2,10,10));
		inputPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		inputPanel.setBackground(new Color(45,85,190));

		idLabel = new JLabel("Product ID:");
		nameLabel = new JLabel("Product Name:");
		categoryLabel = new JLabel("Category:");
		priceLabel = new JLabel("Price:");
		quantityLabel = new JLabel("Quantity:");
		supplierLabel = new JLabel("Supplier:");
		statusLabel = new JLabel("Status:");
		notesLabel = new JLabel("Notes:");

		idLabel.setForeground(Color.white);
		nameLabel.setForeground(Color.white);
		categoryLabel.setForeground(Color.white);
		priceLabel.setForeground(Color.white);
		quantityLabel.setForeground(Color.white);
		supplierLabel.setForeground(Color.white);
		statusLabel.setForeground(Color.white);
		notesLabel.setForeground(Color.white);

		txtId = new JTextField();
		txtName = new JTextField();
		txtPrice = new JTextField();
		txtQuantity = new JTextField();
		txtSupplier = new JTextField();
		txtNotes = new JTextField();

		selectCategory = new JComboBox<String>(
				new String[] {"Electronics", "Mechanical"}
				);
		selectStatus = new JComboBox<String>(
				new String[] {
						"Available", "Out of Order", "Reserved"
				});

		inputPanel.add(idLabel);
		inputPanel.add(txtId);
		inputPanel.add(nameLabel);
		inputPanel.add(txtName);
		inputPanel.add(categoryLabel);
		inputPanel.add(selectCategory);
		inputPanel.add(priceLabel);
		inputPanel.add(txtPrice);
		inputPanel.add(quantityLabel);
		inputPanel.add(txtQuantity);
		inputPanel.add(supplierLabel);
		inputPanel.add(txtSupplier);
		inputPanel.add(statusLabel);
		inputPanel.add(selectStatus);
		inputPanel.add(notesLabel);
		inputPanel.add(txtNotes);

		topPanel.add(headerLabel, BorderLayout.NORTH);
		topPanel.add(inputPanel, BorderLayout.CENTER);

		// CENTER part
		String[] columnNames = {"Product ID", "Prodcut Name", "Category",
				"Price", "Quantity", "Supplier", "Status", "Notes"
		};
		model = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scroll = new JScrollPane(table);

		// BOTTOM part
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,10));
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

		createBut = new JButton("Create new Product");
		readBut = new JButton("Display Product");
		updateBut = new JButton("Update Product");
		deleteBut = new JButton("Delete product");
		searchBut = new JButton ("Search Product");

		createBut.addActionListener(this);
		readBut.addActionListener(this);
		updateBut.addActionListener(this);
		deleteBut.addActionListener(this);
		searchBut.addActionListener(this);
		
		bottomPanel.add(createBut);
		bottomPanel.add(readBut);
		bottomPanel.add(updateBut);
		bottomPanel.add(deleteBut);
		bottomPanel.add(searchBut);

		add(topPanel, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);

		setSize(800,700);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		CRUDS c = new CRUDS(mainWindow.this, productList);
		if (e.getSource()==createBut) {
			c.createNewProduct();
		}
		if (e.getSource()==readBut) {
			c.displayProductList();
		}
		if (e.getSource()==updateBut) {
			c.updateProduct();
		}
		if (e.getSource()==deleteBut) {
			c.deleteProduct();
		}
		if (e.getSource()==searchBut) {
			c.searchProduct();
		}

	}

}
