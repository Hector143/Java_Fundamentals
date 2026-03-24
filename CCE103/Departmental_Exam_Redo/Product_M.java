package Departmental_Exam_Redo;

public class Product_M {
	private String productId;
	private String productName;
	private String category;
	private String supplier;
	private String unitPrice;
	private String stockQuantity;
	private String description;
	public Product_M(String productId, String productName, String category, String supplier, String unitPrice,
			String stockQuantity, String description) {
		setProductId(productId);
		setProductName(productName);
		setCategory(category);
		setSupplier(supplier);
		setUnitPrice(unitPrice);
		setStockQuantity(stockQuantity);
		setDescription(description);
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
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
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(String stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toFileString() {
		return productId + "|" + productName + "|" +
				category + "|" + supplier + "|" +
				unitPrice + "|" + stockQuantity + "|" +
				description;
	}
	
	public String[] getFileInfo() {
		String[] info = {getProductId(), getProductName(), getCategory(),
				getSupplier(), getUnitPrice(), getStockQuantity(), getDescription()};
		return info;
	}
	
}
