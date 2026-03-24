package SecondLabExam3.View;

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

import SecondLabExam3.Controller.CRUDS;
import SecondLabExam3.Model.Product;

public class mainWindow extends JFrame implements ActionListener{
	public JLabel idLabel, nameLabel, categoryLabel, priceLabel, quantityLabel, supplierLabel, statusLabel;
	public JTextField txtID, txtName, txtPrice, txtQuantity, txtSupplier;
	public JComboBox<String> selectCategory, selectStatus;
	public JButton createBut, readBut, updateBut, deleteBut, searchBut;
	public DefaultTableModel model;
	public JTable table;
	public JScrollPane scroll;
	public ArrayList<Product> productList;
	public mainWindow() {
		productList = new ArrayList<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle("Orders and Product Inventory System");
		setSize(900,700);
		setLocationRelativeTo(null);

		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setBackground(new Color(35,65,110));

		JLabel headerLabel = new JLabel("Customer Orders and Product Mangement System");
		headerLabel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		headerLabel.setFont(new Font("SansSerif",Font.BOLD,25));
		headerLabel.setForeground(Color.white);
		headerLabel.setHorizontalAlignment(JLabel.CENTER);

		JPanel inputPanel = new JPanel(new GridLayout(7,2,10,10));
		inputPanel.setBackground(new Color(45,85,190));
		inputPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

		idLabel = new JLabel("Student ID:");
		nameLabel = new JLabel("Student Name:");
		categoryLabel = new JLabel("Category:");
		priceLabel = new JLabel("Price:");
		quantityLabel = new JLabel("Quantity:");
		supplierLabel = new JLabel("Supplier:");
		statusLabel = new JLabel("Status:");
		
		idLabel.setForeground(Color.white);
		nameLabel.setForeground(Color.white);
		categoryLabel.setForeground(Color.white);
		priceLabel.setForeground(Color.white);
		quantityLabel.setForeground(Color.white);
		supplierLabel.setForeground(Color.white);
		statusLabel.setForeground(Color.white);
		
		txtID = new JTextField();
		txtName = new JTextField();
		txtPrice = new JTextField();
		txtQuantity = new JTextField();
		txtSupplier = new JTextField();

		selectCategory = new JComboBox<String>(new String[] {"Storage Device", "Accessories"});
		selectStatus = new JComboBox<String>(new String[] {"Available", "Unavailable", "Out of Stock"});

		inputPanel.add(idLabel);
		inputPanel.add(txtID);
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

		topPanel.add(headerLabel, BorderLayout.NORTH);
		topPanel.add(inputPanel, BorderLayout.CENTER);

		JPanel centerPanel = new JPanel(new BorderLayout());
		String[] columnNames = new String[]{"Product ID", "Product Name", "Category", "Price", "Quantity","Supplider", "Status"};
		model = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scroll = new JScrollPane(table);
		centerPanel.add(scroll);

		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		createBut = new JButton("Add New Product");
		readBut = new JButton("Display Product Records");
		updateBut = new JButton("Modify Product Details");
		deleteBut = new JButton("Remove Product");
		searchBut = new JButton("Find Product Record");

		bottomPanel.add(createBut);
		bottomPanel.add(readBut);
		bottomPanel.add(updateBut);
		bottomPanel.add(deleteBut);
		bottomPanel.add(searchBut);

		createBut.addActionListener(this);
		readBut.addActionListener(this);
		updateBut.addActionListener(this);
		deleteBut.addActionListener(this);
		searchBut.addActionListener(this);

		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
		setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		CRUDS c = new CRUDS(this,productList);
		if (e.getSource()==createBut) {
			c.addNewProduct();
		}
		if (e.getSource()==readBut) {
			c.displayRecords();
		}
		if (e.getSource()==updateBut) {
			c.updateProductRecords();
		}
		if (e.getSource()==deleteBut) {
			c.deleteProduct();
		}
		if (e.getSource()==searchBut) {
			c.searchProduct();
		}

	}

}
