import java.util.ArrayList;
import java.util.Date;

public class BookStatus {

	private int bookID;
	private int accountID;
	Date date;

	BookStatus() {

	}

	BookStatus(int bookID, int accountID) {
		this.bookID = bookID;
		this.accountID = accountID;
		date = new Date();

	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountNumber(int accountID) {
		this.accountID = accountID;
	}

	public java.util.Date getDueDate() {
		return date;
	}

	public void borrowBooks(ArrayList<Account> accounts, ArrayList<Book> books, int accountID, int bookID,
			int amountOfBorrowedBooks, String date) {

		if (Account.isAccountNumber(accountID, accounts)) {
			System.out.println("\nAccount number doesn't exist. Try again.");

		} else if (Book.isBookNumber(bookID, books)) {
			System.out.println("\nBook number invalid. Try again.");

		} else if (Book.isBookAvailable(bookID, books)) {
			System.out.println("\nThis book is not available at the moment.");

		} else if (accounts.get(Account.getAccountNumberIndex(accountID, accounts)).getBorrowedBooks() >= 3) {
			System.out.println("\nThree books have already been borrowed!");

		} else {
			books.get(Book.getBookNumberIndex(bookID, books)).setBookAvailable(false);
			accounts.get(Account.getAccountNumberIndex(accountID, accounts))
					.setBorrowedBooks(amountOfBorrowedBooks + 1);

			System.out.println("Book is issued to account number " + accountID);

		}

	}
}
