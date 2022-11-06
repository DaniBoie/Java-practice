package labs.lab6;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

/**
 * A bank contains account numbers and balances of each customer.
 */
public class Bank {
	// ADD YOUR INSTANCE VARIABLES HERE
	// private String accountsFile;
	// private int numberOfAccounts;
	private ArrayList<BankAccount> accounts;
	/**
	 * Construct a Bank object with accounts read from the given file
	 * 
	 * @param filename the name of the file
	 */
	public Bank(String fileName) {

		try (Scanner input = new Scanner(new File(fileName))) {

			accounts = new ArrayList<BankAccount>();

			while (input.hasNextLine()) {
				int number = input.nextInt();
				double balance = input.nextDouble();

				BankAccount newAccount = new BankAccount(number, balance);
				accounts.add(newAccount);

			}
		} catch (Exception e) {
			System.out.print("File: " + fileName + " not found");
		}
	}


	/**
	 * Gets the account with the lowest balance.
	 * 
	 * @return the account with the lowest balance, or null if there are
	 * no accounts in this bank
	 */
	public BankAccount getLowestBalanceAccount() {
		if (accounts.size() > 0) {
			BankAccount lowest = accounts.get(0);
			for (BankAccount account : accounts) {
				if (account.getBalance() < lowest.getBalance()) {
					lowest = account;
				}
			}
			return lowest;
		}
		
		return null; // FIX ME
	}
}
