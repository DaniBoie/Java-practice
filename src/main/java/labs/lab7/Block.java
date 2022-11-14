package labs.lab7;

/**
 * A quantity and price of a block of stocks.
 */
public class Block {
	private int price;
	private int quantity;

	/**
	 * Constructor
	 * 
	 * @param quantity the quantity of shares in this block.
	 * @param price    the price of this block.
	 */
	public Block(int quantity, int price) {
		this.price = price;
		this.quantity = quantity;
		// FILL IN
	}

	
	public int getQuantity() {
		return quantity; // FIX ME
	}

	
	public int getPrice() {
		return price; // FIX ME
	}

	
	/**
	 * Sells shares in this block
	 * 
	 * @param shares   the number of shares to sell
	 */
	public void sell(int shares) {
		// FILL IN
		quantity -= shares;
	}
}
