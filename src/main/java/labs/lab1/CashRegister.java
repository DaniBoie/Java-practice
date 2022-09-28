package labs.lab1;

/**
 * A cash register totals up sales and computes change due.
 */
public class CashRegister {
	private double purchase;
	private double payment;
	private double transaction_total;
	private int items;
	private int transactions;
	private String receipt;

	/**
	 * Constructs a cash register with no money in it.
	 */
	public CashRegister() {
		purchase = 0;
		payment = 0;
		items = 0;
		receipt = "";
	}

	/**
	 * Records the sale of an item.
	 * 
	 * @param amount the price of the item
	 */
	public void recordPurchase(double amount) {
		items = items + 1;
		purchase = purchase + amount;
		transaction_total = transaction_total + amount;
		receipt = receipt + String.valueOf(amount) + "\n";
	}

	/**
	 * Processes a payment received from the customer.
	 * 
	 * @param amount the amount of the payment
	 */
	public void receivePayment(double amount) {
		payment = payment + amount;
	}

	/**
	 * Computes the change due and resets the machine for the next customer.
	 * 
	 * @return the change due to the customer
	 */
	public double giveChange() {
		double change = payment - purchase;
		items = 0;
		purchase = 0;
		payment = 0;
		receipt = "";
		transactions = transactions + 1;
		return change;
	}
	

	/**
	 * Returns count of items purchased.
	 * 
	 * @return count of items purchased
	 */
	public int getItemCountInPurchase() {
		// WRITE YOUR CODE HERE 
		return items; // FIX ME
	}

	/**
	 * Get the total amount of all sales for the day.
	 * 
	 * @return the total amount of all sales for the day
	 */
	public double getSalesTotal() {
		// WRITE YOUR CODE HERE 
		return transaction_total; // FIX ME
	}

	/**
	 * Get the total number of sales for the day.
	 * 
	 * @return the number of sales for the day
	 */
	public int getSalesCount() {
		// WRITE YOUR CODE HERE 
		return transactions; // FIX ME
	}

	/**
	 * Reset counters and totals for the next day's sales.
	 */
	public void reset() {
		// WRITE YOUR CODE HERE 
		purchase = 0;
		payment = 0;
		transaction_total = 0;
		items = 0;
		transactions = 0;
	}

	public String getReceipt() {
		// WRITE YOUR CODE HERE 

		return receipt + String.valueOf(purchase); // FIX ME
	}
}
