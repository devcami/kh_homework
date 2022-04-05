package ncs.test8;

import ncs.test7.Book;

public class BookUpdater {
	private Book bookData;

	public BookUpdater() {
	}

	public BookUpdater(Book bookData) {
		this.bookData = bookData;
	}
	
	public void setBookData(Book bookData) {
		this.bookData = bookData;
	}

	public Book getBookData() {
		return new Book();
	}
	
	public void updateBookPrice(Book book) {
		book.setBookPrice(book.getBookPrice() - (book.getBookPrice() * (book.getBookDiscountRate()/100)));
	}
	
	
	
}
