package LibraryTransactionsInventory;

public class Book_M {
	private String id;
	private String title;
	private String author;
	private String category;
	private String price;
	private String quantity;
	private String publisher;
	private String status;
	private String notes;
	public Book_M(String id, String title, String author, String category, String price, String quantity, String publisher,
			String status, String notes) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.publisher = publisher;
		this.status = status;
		this.notes = notes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
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
	
	public String[] getFileInfo() {
		String[] info = {getId(), getTitle(), getAuthor(),getCategory(),
				getPrice(), getQuantity(), getPublisher(), getStatus(), getNotes()
		};
		return info;
	}
	
	
}
