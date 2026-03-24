package Sample2ndExam.Model;

public class ReferenceBook extends Book implements Borrowable{

	public ReferenceBook(String bookId, String title, String author, String category, String publicationDate,
			String isbn, String status, String shelfLocation, String description) {
		super(bookId, title, author, category, publicationDate, isbn, status, shelfLocation, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void borrowBook() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returnBook() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calculateLateFee() {
		// TODO Auto-generated method stub
		return 0;
	}

}
