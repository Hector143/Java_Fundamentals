package Transaction_and_Inventory_System.Controllers;

import Transaction_and_Inventory_System.Model.Product;
import Transaction_and_Inventory_System.View.mainWindow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CRUDS {
	private ArrayList<Product> productList;
	private mainWindow view;

	public static final String fileName = "product.txt";
	public static File file = new File(fileName);

	public CRUDS(mainWindow view, ArrayList<Product> productList) {
		this.view = view;
		this.productList = productList;
	}

	public void createNewProduct() {
		try {
			String id = view.txtId.getText().trim();
			String name = view.txtName.getText().trim();
			String cat  =	view.selectCategory.getSelectedItem().toString();
			double price =	Double.parseDouble(view.txtPrice.getText().trim());
			int quantity = Integer.parseInt(view.txtQuantity.getText().trim());
			String sup = view.txtSupplier.getText().trim();
			String status =	view.selectStatus.getSelectedItem().toString();
			String notes =	view.txtNotes.getText().trim();

			if (id.isEmpty() || name.isEmpty() || notes.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Field Missing!" ,"Error Message", JOptionPane.ERROR_MESSAGE);
				return;
			}
			Product p = new Product(id,name, cat, price, quantity, sup, status, notes);
			productList.add(p);
			saveToFile();
			refreshTable();
			clearFields();
			JOptionPane.showMessageDialog(null, "Added Record Successfully");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error Creation");
		}
		
		
	}

	public void displayProductList() {
		productList.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				String[] split = line.split("\\|");
				Product row = new Product(
						split[0], split[1], split[2], 
						Double.parseDouble(split[3]),
						Integer.parseInt(split[4]),
						split[5], split[6], split[7]);
				productList.add(row);
			}
			br.close();
			refreshTable();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Display Error: Cannot Read File", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void updateProduct() {
		String id = view.txtId.getText().trim();
		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(null, "You must enter ID to update");
			return;
		}
		try {
			for (Product p : productList) {
				if (p.getId().equalsIgnoreCase(id)) {
					int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you are going to update product records?"
							,"Confirm Message", JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.NO_OPTION) {
						return;
					}

					view.txtName.setText(view.txtName.getText().trim());
					view.txtPrice.setText(view.txtPrice.getText().trim());
					view.txtQuantity.setText(view.txtQuantity.getText().trim());
					view.txtSupplier.setText(view.txtSupplier.getText().trim());
					return;
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cant Create File", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void deleteProduct() {
		int selectedRow = view.table.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "You must select a row to delete!");
			return;
		}
	}

	public void searchProduct() {
		String id = view.txtId.getText().trim();
		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(null, "You must input ID");
			return;
		}
	}

	public void refreshTable() {
		view.model.setRowCount(0);
		
		for (Product p : productList) {
			Object[] row = {p.getId(), p.getName(),
					p.getCategory(), p.getPrice(),
					p.getQuantity(), p.getSupplier(), p.getStatus(),
					p.getNotes()
			};
			view.model.addRow(row);
		}
	}
	
	public void clearFields() {
		view.txtId.setText("");
		view.txtName.setText("");
		view.txtPrice.setText("");
		view.txtQuantity.setText("");
		view.txtSupplier.setText("");
		view.txtNotes.setText("");
		view.selectCategory.setSelectedItem(0);
		view.selectStatus.setSelectedItem(0);
	}
	
	public void initFile() {
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cant Create File", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void saveToFile() {
		try {
			FileWriter fw = new FileWriter("product.txt", true);
			for (Product p : productList) {
				fw.write(p.toFileString() + "\n");
			}
			fw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error Saving File");
			return;
		}
		
	}

}
