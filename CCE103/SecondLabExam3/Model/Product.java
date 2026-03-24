package SecondLabExam3.Model;

public class Product {
	private String productID;
	private String productName;
	private String category;
	private double price;
	private int quantity;
	private String supplier;
	private String status;
	public Product(String productID, String productName, String category, double price, int quantity, String supplier,
			String status) {
		this.productID = productID;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.supplier = supplier;
		this.status = status;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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
	
	public String toFileString() {
		return productID + "|" + productName + "|" +
				category + "|" + price + "|" +
				quantity + "|" + supplier + "|" +
				status;
	}
	
	public double calculateDiscount() {
		return 0;
	}
	
	public void displayProductDetails() {
		
	}
	
	
}
