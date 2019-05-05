
import java.util.ArrayList;

public class Book {

	private String bookName;
	private int bookID;
	private boolean bookAvailable = true;

	Book() {

	}

	Book(int bookID, String bookName) {
		this.bookID = bookID;
		this.bookName = bookName;

	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;

	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setBookAvailable(boolean bookAvailable) {
		this.bookAvailable = bookAvailable;
	}

	public boolean isBookAvailable() {

		return bookAvailable;
	}

	public static boolean alreadyExists(int bookID, ArrayList<Book> books) {
		for (int i = 0; i < books.size(); i++) {
			while (books.get(i).getBookID() == bookID) {
				return true;
			}
		}
		return false;
	}

	public static boolean isBookNumber(int bookID, ArrayList<Book> books) {
		for (int i = 0; i < books.size(); i++) {
			while (books.get(i).getBookID() == bookID) {
				return false;
			}
		}
		return true;
	}

	public static int getBookNumberIndex(int bookID, ArrayList<Book> books) {
		int i;
		for (i = 0; i < books.size(); i++) {
			if (books.get(i).getBookID() == bookID) {
				return i;
			}
		}
		return i;
	}

	public static void booksList(ArrayList<Book> books) {
		for (int i = 0; i < books.size(); i++) {
			System.out.println(i + ". " + books.get(i).getBookName());
		}

	}

	public static boolean isBookAvailable(int bookID, ArrayList<Book> books) {
		while (books.get(getBookNumberIndex(bookID, books)).isBookAvailable()) {
			return false;
		}
		return true;

	}

	public boolean isBookNoNegative(int bookID) {
		if (getBookID() < 0) {
			return true;
		} else
			return false;
	}

}