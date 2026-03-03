package Transaction_and_Inventory_System.Model;

import javax.swing.JOptionPane;

public class ElectronicProduct extends Product implements InventoryOperations{

	public ElectronicProduct(String id, String name, String category, double price, int quantity, String supplier,
			String status, String notes) {
		super(id, name, category, price, quantity, supplier, status, notes);
		
	}

	@Override
	public void addProduct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchProduct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processSale() {
		// TODO Auto-generated method stub
		
	}
	
	@Override 
	public double calculateDiscount() {
		return (getPrice() * getQuantity()) / 10;
	}
	
	@Override
	public void displayProductDetails() {
		JOptionPane.showMessageDialog(null,  "Electronic Product List:\n");
	}
}
