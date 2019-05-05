
import java.util.ArrayList;

public class Account {

	private String accountName;
	private int accountID;
	private int borrowedBooks;

	Account() {

	}

	Account(String accountName, int accountID, int borrowedBooks) {
		this.accountName = accountName;
		this.accountID = accountID;
		this.borrowedBooks = borrowedBooks;

	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getName() {
		return accountName;
	}

	public void setAccountName(String name) {
		this.accountName = name;
	}

	public int getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(int borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	public static void printInformation(ArrayList<Account> accounts, int accountID) {

		boolean account = false;

		for (int i = 0; i < accounts.size(); i++) {

			if (accounts.get(i).getAccountID() == accountID) {

				System.out.println("Name: " + accounts.get(i).getName());
				System.out.println("AccountID: " + accounts.get(i).getAccountID());
				System.out.println("Books borrowed: " + accounts.get(i).getBorrowedBooks());
				account = true;
				break;
			}
		}
		if (!account) {
			System.out.println("This account does not exist!");
		}
	}

	public static boolean accountAlreadyExists(int accountNumber, ArrayList<Account> accounts) {

		for (int i = 0; i < accounts.size(); i++) {

			while (accounts.get(i).getAccountID() == accountNumber) {

				return true;

			}
		}
		return false;
	}

	public static boolean isAccountNumber(int accountNumber, ArrayList<Account> accounts) {

		for (int i = 0; i < accounts.size(); i++) {

			if (accounts.get(i).getAccountID() == accountNumber) {

				return false;

			}
		}

		return true;
	}

	public static int getAccountNumberIndex(int accountNumber, ArrayList<Account> accounts) {

		int i;

		for (i = 0; i < accounts.size(); i++) {

			if (accounts.get(i).getAccountID() == accountNumber) {

				return i;
			}
		}
		return i;
	}

	public static void accountsList(ArrayList<Account> accounts) {

		for (int i = 0; i < accounts.size(); i++) {

			System.out.println(i + ". AccountID: " + accounts.get(i).getAccountID() + ", name: "
					+ accounts.get(i).getName() + ", books borrowed: " + accounts.get(i).getBorrowedBooks());

		}

	}

}