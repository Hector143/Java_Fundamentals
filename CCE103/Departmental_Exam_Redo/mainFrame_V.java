package Departmental_Exam_Redo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class mainFrame_V extends JFrame implements ActionListener{
	public JLabel idLabel, nameLabel, categoryLabel, supplierLabel, unitPriceLabel, stockQuantityLabel, descriptionLabel;
	public JTextField txtId, txtName, txtCategory, txtSupplier, txtUnitPrice, txtStockQuantity, txtDescription;
	public JButton addBut, updateBut, deleteBut, clearBut, exitBut;
	public DefaultTableModel model;
	public JTable table;
	public JScrollPane scroll;
	public ArrayList<Product_M> productList = new ArrayList<>();
	public mainFrame_V() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Inventory Management System");
		setLayout(new BorderLayout());
		setSize(1000,600);
		setLocationRelativeTo(null);

		JPanel mainPanel = new JPanel(new BorderLayout());

		// CENTER AREA
		JPanel centerPanel = new JPanel(new BorderLayout());
		String[] columnNames = new String[] {
				"Product ID", "Product Name", "Category", "Supplier", "Unit Price", "Stock Quantity", "Description"	
		};
		model = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getTableHeader().setBackground(Color.ORANGE);
		scroll = new JScrollPane(table);
		centerPanel.add(scroll);


		// SOUTH AREA
		JPanel southPanel = new JPanel(new BorderLayout());
		JPanel inputPanel = new JPanel(new GridLayout(2,7,10,10));
		inputPanel.setBorder(BorderFactory.createTitledBorder("Inventory List"));

		idLabel = new JLabel("Product ID");
		nameLabel = new JLabel("Product Name");
		categoryLabel = new JLabel("Category");
		supplierLabel = new JLabel("Supplier");
		unitPriceLabel = new JLabel("Unit Price");
		stockQuantityLabel = new JLabel("Stock Quantity");
		descriptionLabel = new JLabel("Description");

		txtId = new JTextField();
		txtName = new JTextField();
		txtCategory = new JTextField();
		txtSupplier = new JTextField();
		txtUnitPrice = new JTextField();
		txtStockQuantity = new JTextField();
		txtDescription = new JTextField();

		inputPanel.add(idLabel); 
		inputPanel.add(nameLabel); 
		inputPanel.add(categoryLabel); 
		inputPanel.add(supplierLabel); 
		inputPanel.add(unitPriceLabel); 
		inputPanel.add(stockQuantityLabel); 
		inputPanel.add(descriptionLabel);

		inputPanel.add(txtId);
		inputPanel.add(txtName);
		inputPanel.add(txtCategory);
		inputPanel.add(txtSupplier); 
		inputPanel.add(txtUnitPrice); 
		inputPanel.add(txtStockQuantity);
		inputPanel.add(txtDescription);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING,10,10));

		addBut = new JButton("Add");
		updateBut = new JButton("Update");
		deleteBut = new JButton("Delete");
		clearBut = new JButton("Clear");
		exitBut = new JButton("Exit");

		addBut.addActionListener(this);
		updateBut.addActionListener(this);
		deleteBut.addActionListener(this);
		clearBut.addActionListener(this);
		exitBut.addActionListener(this);

		buttonPanel.add(addBut);
		buttonPanel.add(updateBut);
		buttonPanel.add(deleteBut);
		buttonPanel.add(clearBut);
		buttonPanel.add(exitBut);

		southPanel.add(inputPanel, BorderLayout.CENTER);
		southPanel.add(buttonPanel, BorderLayout.SOUTH);

		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		add(mainPanel);
		setVisible(true);
		Controllers_C controller = new Controllers_C(productList);
		controller.initFile();
		controller.readFromFile();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Controllers_C controller = new Controllers_C(productList);
		
		if (e.getSource()==addBut) {
			try {
				String id = txtId.getText().trim();
				String name = txtName.getText().trim();
				String category = txtCategory.getText().trim();
				String supplier = txtSupplier.getText().trim();
				String price = txtUnitPrice.getText().trim();
				String quantity = txtStockQuantity.getText().trim();
				String description = txtDescription.getText().trim();
				
				if (id.isEmpty() || name.isEmpty() ||
						category.isEmpty() || supplier.isEmpty() ||
						price.isEmpty() || quantity.isEmpty() ||
						description.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Fields Are empty!");
					return;
				}
				
				if (controller.isDuplicate(id)) {
					JOptionPane.showMessageDialog(this, "Duplicate ID!");
					return;
				}
				
				Product_M p = new Product_M(id, name, category, supplier, price, quantity, description);
				controller.addProduct(p);
				refreshTable();
				JOptionPane.showMessageDialog(this, "Product Added Successfully!");
				return;
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Cannot Add Product!", "Error Message", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if (e.getSource()==updateBut) {
			try {
				int selectedRow = table.getSelectedRow();
				if(selectedRow == -1) {
					JOptionPane.showMessageDialog(this, "You must select a row first");
					return;
				}
				
				int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you are going to update product?", "Confirm Update", JOptionPane.YES_NO_OPTION);
				if (confirm != JOptionPane.YES_OPTION) return;
				
				String id = txtId.getText().trim();
				String name = txtName.getText().trim();
				String category = txtCategory.getText().trim();
				String supplier = txtSupplier.getText().trim();
				String price = txtUnitPrice.getText().trim();
				String quantity = txtStockQuantity.getText().trim();
				String description = txtDescription.getText().trim();
				
				if (id.isEmpty() || name.isEmpty() ||
						category.isEmpty() || supplier.isEmpty() ||
						price.isEmpty() || quantity.isEmpty() ||
						description.isEmpty()) {
					JOptionPane.showMessageDialog(this, "You must fill the Fields first!");
					return;
				}
				
				Product_M p = new Product_M(id, name, category, supplier, price, quantity, description);
				controller.updateProduct(selectedRow, p);
				refreshTable();
				JOptionPane.showMessageDialog(this, "Updated Successfully!");
				return;
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Cannot Update Product!", "Error Message", JOptionPane.ERROR_MESSAGE);
				return;
			}	
		}
		if (e.getSource()==deleteBut) {
			try {
				int selectedRow = table.getSelectedRow();
				if(selectedRow == -1) {
					JOptionPane.showMessageDialog(this, "You must select a row first");
					return;
				}
				
				int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you are going to delete product?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
				if (confirm != JOptionPane.YES_OPTION) return;
				
				controller.deleteProduct(selectedRow);
				refreshTable();
				JOptionPane.showMessageDialog(this, "Deleted Successfully!");
				return;
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Cannot Delete Product!", "Error Message", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
		if (e.getSource()==clearBut) {
			clearFields();
		}
		
		if (e.getSource()==exitBut) {
			System.exit(0); // closes the program safely.
		}


	}
	
	public void clearFields() {
		txtId.setText("");
		txtName.setText("");
		txtCategory.setText("");
		txtSupplier.setText("");
		txtUnitPrice.setText("");
		txtStockQuantity.setText("");
		txtDescription.setText("");
	}
	
	public void refreshTable() {
		model.setRowCount(0);
		for (Product_M p : productList) {
			model.addRow(p.getFileInfo());
		}
	}
}
