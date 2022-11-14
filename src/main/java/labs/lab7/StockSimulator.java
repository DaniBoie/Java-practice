package labs.lab7;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Class for simulating trading a single stock at varying prices.
 */
public class StockSimulator {

	private Queue<Block> blocks;

	/**
	 * Constructor
	 */
	public StockSimulator() {
		// FILL IN
		blocks = new LinkedList<Block>();
	}


	/**
	 * Handle a user buying a given quantity of stock at a given price.
	 * 
	 * @param quantity how many to buy.
	 * @param price    the price to buy at.
	 * 
	 * @throws IllegalArgumentException if the requested quantity/price cannot be
	 *                                  sold i.e., quantity <= 0 or price < 0
	 */
	public void buy(int quantity, int price) throws IllegalArgumentException {
		// FILL IN
		if (quantity > 0 && price >= 0) {
			Block stock = new Block(quantity, price);
			blocks.add(stock);
		} else {
			throw new IllegalArgumentException("Unable to complete purchase");
		}

	}


	/**
	 * Handle a user selling a given quantity of stock at a given price.
	 * 
	 * @param quantity how many to sell.
	 * @param price    the price to sell.
	 * 
	 * @return the gain (can be positive or negative)
	 * 
	 * @throws IllegalArgumentException if the requested quantity cannot be sold
	 *                                  e.g., quantity exceeds quantity owned,
	 *                                  quantity < 1, price < 0
	 */
	public int sell(int quantity, int price) throws IllegalArgumentException {
		int totalStocks = 0;
		for (Block stock : blocks) {
			totalStocks += stock.getQuantity();
		}

		if (quantity <= totalStocks && quantity >= 1 && price >= 0) {
			int totalReturn = 0;
			int totalPaid = 0;

			for (Block stock : blocks) {
				while (quantity > 0) {
					if (stock.getQuantity() >= 1) {
						stock.sell(1);
						totalReturn += price;
						totalPaid += stock.getPrice();
						quantity -= 1;
					} else {
						break;
					}		
				}
			}
			return totalReturn - totalPaid;

		} else {
			throw new IllegalArgumentException("Unable to complete sale");
		}
	}


	/**
	 * This is a method for us to test your class
	 * 
	 * @return a List of Blocks owned
	 */
	public List<Block> getBlocks() {
		return List.copyOf(blocks); // FIX ME
	}

}
