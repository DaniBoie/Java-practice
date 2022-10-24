package labs.lab4;

/**
 * A class for a customer in Robert's pet store. For every $100 spent, the
 * customer gets a 10% discount that will be automatically applied to
 * a future purchase. Note that some results will have more than two places
 * after the decimal points, and that's ok.
 */
public class Customer {
	// ADD YOUR INSTANCE VARIABLES HERE
	double total_spent;
	int discounts;
	/**
	 * Creates a new customer
	 */
	public Customer() {
		// FILL IN
		total_spent = 0;
		discounts = 0;
	}

	
	/**
	 * adds a purchase for the amount to the customer's account; assume 
	 * the amount will always be a valid monetary amount > 0
	 * 
	 * @param amount	amount of purchase
	 */
	public void makePurchase(double amount) {

		if (discounts > 0) {
			amount -= amount * 0.10;
			discounts -= 1;
		}

		int before = (int)(total_spent / 100 ) % 10;

		total_spent += amount;

		int after = (int) (total_spent / 100) % 10;

		if (before < after) {
			discounts += after - before;
		}

		// FILL IN
	}
	
	
	/**
	 * Returns the number of discounts this customer has on their account 
	 * to be used on future purchases
	 * 
	 * @return	number of discounts to use
	 */
	public int getNumDiscountsToUse() {
		return discounts; // FIX ME
	}

	
	/**
	 * Returns the total amount this customer has spent on all their purchases
	 * 
	 * @return	total amount spent
	 */
	public double getTotalAmountSpent() {
		return total_spent; // FIX ME
	}
}
