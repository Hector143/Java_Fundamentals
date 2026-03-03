package Transaction_and_Inventory_System.Model;

public class Product {
	private String id;
	private String name;
	private String category;
	private double price;
	private int quantity;
	private String supplier;
	private String status;
	private String notes;
	
	public Product(String id, String name, String category, double price, int quantity, String supplier, String status,
			String notes) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.supplier = supplier;
		this.status = status;
		this.notes = notes;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getSupplier() {
		return supplier;
	}


	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String toFileString() {
		return id + "|" + name + "|" + 
				category + "|" + price + "|" + 
				quantity + "|" + supplier + "|" + 
				status + "|" + notes; 
	}
	
	public double calculateDiscount() {
		return 0;
	}
	public void displayProductDetails() {
	
	}
}
