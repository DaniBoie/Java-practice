package labs.lab4;

/**
 * A class to simulate a combination lock.
 */
public class ComboLock {
	// ADD YOUR INSTANCE VARIABLES HERE
	int currentNum;
	int num1;
	int num2;
	int num3;
	boolean num1bool;
	boolean num2bool;
	boolean num3bool;

	private int return_num(int num, char method) {
		if (method == '+') {
			num += currentNum;
			if (num > 39) {
				num -= 40;
			}
		} else if (method == '-') {
			num = currentNum - num;
			if (num < 0) {
				num += 40;
			}
		}

		return num;
	}

	/**
	 * Initializes the combination of the lock. Assume all inputs are valid ints
	 * between 0 and 39 inclusive
	 * 
	 * @param num1 first number to turn right to
	 * @param num2 second number to turn left to
	 * @param num3 third number to turn right to
	 */
	public ComboLock(int num1, int num2, int num3) {
		// FILL IN
		currentNum = 0;
		num1bool = false;
		num2bool = false;
		num3bool = false;

		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}

	/**
	 * Resets the state of the lock so that it can be opened again; resets the
	 * dial so that it points to 0
	 */
	public void reset() {
		currentNum = 0;
		num1bool = false;
		num2bool = false;
		num3bool = false;
		// FILL IN
	}

	/**
	 * Turns lock left given number of ticks.
	 * 
	 * @param ticks number of ticks to turn left; assume ticks always between 0 
	 * and 39 inclusive
	 */
	public void turnLeft(int ticks) {
		// FILL IN ADD NUMBERS
		if (num1bool) {
			int landed_on = return_num(ticks, '+');
			if (landed_on == num2) {
				currentNum = landed_on;
				num2bool = true;
			}
		}
	}

	/**
	 * Turns lock right given number of ticks
	 * 
	 * @param ticks number of ticks to turn right; assume ticks always between 0
	 * and 39 inclusive
	 */
	public void turnRight(int ticks) {
		// FILL IN SUBTRACT NUMBERS
		if (!num2bool) {
			// first number
			int landed_on = return_num(ticks, '-');
			if (landed_on == num1) {
				currentNum = landed_on;
				num1bool = true;
			}
		} else {
			if (num1bool) {
				int landed_on = return_num(ticks, '-');
				if (landed_on == num3) {
					currentNum = landed_on;
					num3bool = true;
				}
			}
			// last number
		}
	}

	/**
	 * Returns true if the lock can be opened now, false otherwise
	 * 
	 * @return true if lock is in open state
	 */
	public boolean open() {
		if (num1bool && num2bool && num3bool) {
			return true;
		}
		return false; // FIX ME
	}
}
