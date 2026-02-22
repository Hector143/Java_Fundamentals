package Projects;

public class Book implements Borrowable{
	private String title;
	private String author;
	private boolean borrowed;
	
	public Book(String title, String author, boolean borrowed) {
		this.title = title;
		this.author = author;
		this.borrowed = borrowed;
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

	public boolean isBorrowed() {
		return borrowed;
	}

	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}

	@Override
	public void borrowBook() {
		// TODO Auto-generated method stub
		borrowed = true;
		
	}

	@Override
	public void returnBook() {
		// TODO Auto-generated method stub
		borrowed = false;
		
	}
	
	public String getStatus() {
		return borrowed ? "Borrowed" : "Available" ;
	}
	
	
}
