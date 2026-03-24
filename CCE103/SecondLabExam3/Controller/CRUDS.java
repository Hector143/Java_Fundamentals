package SecondLabExam3.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import SecondLabExam3.View.mainWindow;
import SecondLabExam3.Model.Product;

public class CRUDS {
	private mainWindow view;
	private ArrayList<Product> productList;
	public static final String fileName = "products.txt";
	public static File file = new File(fileName);
	public CRUDS(mainWindow view, ArrayList<Product> productList) {
		this.view = view;
		this.productList = productList;
	}
	
	public void clearFields() {
		view.txtID.setText("");
		view.txtName.setText("");
		view.txtPrice.setText("");
		view.txtQuantity.setText("");
		view.txtSupplier.setText("");
		view.selectCategory.setSelectedIndex(0);
		view.selectStatus.setSelectedIndex(0);
	}
	
	public void refreshTable() {
		view.model.setRowCount(0);
		for (Product p : productList) {
			Object[] row = new Object[] {
					p.getProductID(),
					p.getProductName(),
					p.getCategory(),
					p.getPrice(),
					p.getQuantity(),
					p.getSupplier(),
					p.getStatus()
			};
			view.model.addRow(row);
		}
	}
	
	public void initFile() {
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			System.err.println("Error Creating File");
		}
	}
	
	private boolean isDuplicate(String id, String name) {
		for (Product p : productList) {
			if(p.getProductID().equals(id) || p.getProductName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	public void saveToFile() {
		try (FileWriter fw = new FileWriter(fileName)){
			for (Product p : productList) {
				fw.write(p.toFileString()+ "|");
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error Message");
		}
	}
	
	public void addNewProduct() {
		initFile();
		String id = view.txtID.getText().trim();
		String name = view.txtName.getText().trim();
		String cat = view.selectCategory.getSelectedItem().toString();
		double price = Double.parseDouble(view.txtPrice.getText().trim());
		int quantity = Integer.parseInt(view.txtQuantity.getText().trim());
		String supplier = view.txtSupplier.getText().trim();
		String status = view.selectStatus.getSelectedItem().toString();
		
		if (id.isEmpty() || name.isEmpty() || supplier.isEmpty()) {
			JOptionPane.showMessageDialog(null, "You must fill the Fields");
			return;
		}
		if (isDuplicate(id,name)) {
			JOptionPane.showMessageDialog(null, "Duplicate");
			return;
		}
		try {
			Product p = new Product(id, name, cat, price, quantity, supplier, status);
			productList.add(p);
			
			saveToFile();
			refreshTable();
			clearFields();
			
			JOptionPane.showMessageDialog(null, "Product Added successfully!");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Price and Quantity should be numbers", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void displayRecords() {
		productList.clear();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line;
			while((line = br.readLine()) != null) {
				String[] split = line.split("\\|");
				Product p = new Product(
						split[0],
						split[1],
						split[2],
						Double.parseDouble(split[3]),
						Integer.parseInt(split[4]),
						split[5],
						split[6]
						);
				productList.add(p);
			}
			refreshTable();
			return;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Cannot Display Records", "Error Message", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
	
	public void updateProductRecords() {
		int selectedRow = view.table.getSelectedRow();
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "You must select a row");
			return;
		}
		
		if (view.txtPrice.getText().isEmpty() ||
			view.txtQuantity.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "You must fill quantity and price.");
			return;
		}
		
		try {
			int confirm = JOptionPane.showConfirmDialog(null, "Are you going to update record?", "Confirm Update", JOptionPane.YES_NO_CANCEL_OPTION);
			if (confirm != JOptionPane.YES_OPTION) return;
			
			Product p = productList.get(selectedRow);
			p.setProductID(p.getProductID());
			p.setProductName(p.getProductName());
			p.setCategory(p.getCategory());
			p.setPrice(Double.parseDouble(view.txtPrice.getText().trim()));
			p.setQuantity(Integer.parseInt(view.txtQuantity.getText().trim()));
			p.setSupplier(p.getSupplier());
			p.setStatus(view.selectStatus.getSelectedItem().toString());
			
			saveToFile();
			refreshTable();
			clearFields();
			JOptionPane.showMessageDialog(null, "Updated Successfully!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "", "Error Message", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
	
	public void deleteProduct() {
		int selectedRow = view.table.getSelectedRow();
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "You must select a row");
			return;
		}
		
		int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you are oging to delete", "Confirm Delete", JOptionPane.YES_NO_CANCEL_OPTION);
		if (confirm != JOptionPane.YES_OPTION) return;
		
		productList.remove(selectedRow);
		
		saveToFile();
		refreshTable();
		clearFields();
		JOptionPane.showMessageDialog(null, "Deleted Successfully");
	}
	
	public void searchProduct() {
		String id = view.txtID.getText().trim();
		for (Product p : productList) {
			if (p.getProductID().equals(id)) {
				JOptionPane.showMessageDialog(null, "==== Student Found ====\n"
						+ "\nID: " + view.txtID.getText().trim() 
						+ "\nName: " + view.txtName.getText().trim() 
						+ "\nCategory: " + view.selectCategory.getSelectedItem().toString() 
						+ "\nPrice: " + view.txtPrice.getText().trim() 
						+ "\nQuantity: " + view.txtQuantity.getText().trim() 
						+ "\nSupplier: " + view.txtSupplier.getText().trim() 
						+ "\nStatus: " + view.selectStatus.getSelectedItem().toString());
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "Product Not Found!");
	}

	
}
