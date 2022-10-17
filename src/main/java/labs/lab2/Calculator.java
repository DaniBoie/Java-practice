package labs.lab2;

/**
 * A class that performs simple calculations on two integers
 */
public class Calculator {
	
	// ADD YOUR INSTANCE VARIABLES HERE
	private int num1;
	private int num2;
	/**
	 * Constructor
	 * 
	 * @param num1	first number
	 * @param num2	second number
	 */
	public Calculator(int num1, int num2) {
		// FILL IN
		this.num1 = num1;
		this.num2 = num2;
	}
	
	
	/**
	 * Sums the two numbers
	 * 
	 * @return the sum of the two numbers
	 */
	public int getSum() {
		return num1 + num2; // FIX ME
	}
	
	
	/**
	 * Computes the difference between num1 - num2
	 * 
	 * @return the difference
	 */
	public int getDifference() {
		return num1 - num2; // FIX ME
	}
	
	
	/**
	 * Computes the product of the two numbers
	 * 
	 * @return the product
	 */
	public int getProduct() {
		return num1 * num2; // FIX ME
	}
	
	
	/**
	 * Computes the average of the two numbers
	 * 
	 * @return the average
	 */
	public double getAverage() {
		return (double)(num1+num2)/2; // FIX ME
	}
	
	
	/**
	 * Computes the distance between the two numbers
	 * 
	 * @return the distance
	 */
	public int getDistance() {
		int distance = num1 - num2;
		return distance >= 0 ? distance : distance * -1; // FIX ME
	}
	
	
	/**
	 * Returns the maximum of the two numbers
	 * 
	 * @return the maximum
	 */
	public int getMax() {
		return (num1 < num2 ? num2 : num1); // FIX ME
	}
	  
	
	/**
	 * Returns the minimum of the two numbers
	 * 
	 * @return the minimum
	 */
	public int getMin() {
		return (num1 < num2 ? num1 : num2); // FIX ME
	}
}