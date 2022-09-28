package labs.lab1;

/**
 * A rechargeable battery.
 */
public class Battery {

	// ADD YOUR INSTANCE VARIABLES HERE
	private double current_capacity;
	private static double max_capacity;
	/**
	 * Create a battery with specified capacity.
	 * 
	 * @param capacity maximum capacity, measured in milliampere hours
	 */
	public Battery(double capacity) {
		// FILL IN
		current_capacity = capacity;
		max_capacity = capacity;
	}


	/**
	 * Drain capacity of the battery by given amount.
	 * 
	 * @param amount amount of battery used (assume it will not be > its current capacity
	 */
	public void drain(double amount) {
		// FILL IN
		current_capacity = current_capacity - amount;
	}


	/**
	 * Recharge the battery to maximum capacity.
	 */
	public void charge() {
		current_capacity = max_capacity;
		// FILL IN
	}


	/**
	 * Retrieve the battery's current capacity.
	 * 
	 * @return remaining capacity
	 */
	public double getRemainingCapacity() {
		return current_capacity; // FIX ME
	}
}
