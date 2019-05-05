import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String bookName, accountName, date;
		int choice, accountID, bookID, borrowedBooks;
		int amountOfBorrowedBooks = 0;

		ArrayList<Account> accounts = new ArrayList<Account>();
		ArrayList<Book> books = new ArrayList<Book>();
		ArrayList<BookStatus> borrowedBook = new ArrayList<>();

		choice = -1;

		while (choice != 0) {
			System.out.println();

			System.out.println(
					"Select : \n\n1. Create new account \n2. Register book \n3. Borrow book \n4. List all accounts \n5. List all books \n0. Exit");

			System.out.print("\nChoose your option: ");

			choice = input.nextInt();

			System.out.println("");

			if (choice == 1) {

				System.out.print("Enter account ID: ");
				accountID = input.nextInt();
				input.nextLine();

				while (accountID < 0 || Account.accountAlreadyExists(accountID, accounts)) {
					System.out.print("Account ID is not valid. \nTry again: ");
					accountID = input.nextInt();
					input.nextLine();

				}

				System.out.print("Enter account name: ");
				accountName = input.nextLine();
				System.out.print("Number of borrowed books: ");

				borrowedBooks = input.nextInt();

				Account profile = new Account(accountName, accountID, borrowedBooks);
				accounts.add(profile);
				profile.toString();

				System.out.println("");

			} else if (choice == 2) {

				System.out.print("Book ID: ");
				bookID = input.nextInt();
				while (Book.alreadyExists(bookID, books)) {
					System.out.print("This book already exists in our library. \nTry again: ");
					bookID = input.nextInt();
				}
				System.out.print("Book title: ");
				input.nextLine();
				bookName = input.nextLine();

				Book features = new Book(bookID, bookName);
				books.add(features);
				System.out.println("Book " + bookID + " is now added to the library.");
				System.out.println("");

			} else if (choice == 3) {

				System.out.print("Book ID: ");
				bookID = input.nextInt();
				System.out.print("Account ID: ");
				accountID = input.nextInt();
				date = input.nextLine();
				System.out.print("Date: ");
				date = input.nextLine();

				BookStatus borrowed = new BookStatus(bookID, accountID);

				borrowedBook.add(borrowed);

				borrowed.borrowBooks(accounts, books, accountID, bookID, amountOfBorrowedBooks, date);

				System.out.println("");

			} else if (choice == 4) {

				System.out.println("List of registered accounts: ");
				Account.accountsList(accounts);
				System.out.println("");

			} else if (choice == 5) {

				System.out.println("List of registered books: ");
				Book.booksList(books);
				System.out.println("");
			}

		}

		System.out.println("Thank you for using our services.");
		input.close();

	}

}
