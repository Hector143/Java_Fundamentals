package Sample2ndExam.Model;

public class Book {
	private String bookId;
	private String title;
	private String author;
	private String category;
	private String publicationDate;
	private String isbn;
	private String status;
	private String shelfLocation;
	private String description;
	
	public Book(String bookId, String title,String author,
	String category, String publicationDate,String isbn,
	String status,String shelfLocation,String description) {
		setBookId(bookId);
		setTitle(title);
		setAuthor(author);
		setCategory(category);
		setPublicationDate(publicationDate);
		setIsbn(isbn);
		setStatus(status);
		setShelfLocation(shelfLocation);
		setDescription(description);
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
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

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getShelfLocation() {
		return shelfLocation;
	}

	public void setShelfLocation(String shelfLocation) {
		this.shelfLocation = shelfLocation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toFileString() {
		return bookId + "|" + title + "|" +
				author + "|" + category + "|" +
				publicationDate + "|" + isbn + "|" +
				status + "|" + shelfLocation + "|" +
				description;
	}
	
}
