package labs.lab6;

/**
 * Represents a single product.
 */
public class Product {
	// ADD YOUR INSTANCE VARIABLES EHRE
	private String name;
	private double price;
	private int quantity;
	/**
	 * Constructs a Product.
	 * 
	 * @param name    	product name
	 * @param price	  	price of product
	 * @param quantity	quantity of product
	 */
	public Product(String name, double price, int quantity) {
		// FILL IN
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	/**
	 * Retrieve product name.
	 * 
	 * @return name
	 */
	public String getName() {
		return name; // FIX ME
	}

	/**
	 * Retrieve product price.
	 * 
	 * @return product price
	 */
	public double getPrice() {
		return price; // FIX ME
	}

	/**
	 * Retrieve quantity.
	 * 
	 * @return quantity of product
	 */
	public double getQuantity() {
		return quantity; // FIX ME
	}
	
	
	/**
	 * Returns the name, price, and quantity, each separated by a comma and
	 * space
	 */
	@Override
	public String toString() {
		return name + "; " + price + "; " + quantity; // FIX ME
	}
	
	
	/**
	 * Returns true if the given object is a Product with the same instance
	 * variable values as this one
	 */
	@Override
	public boolean equals(Object otherObj) {
		Product otherProduct = (Product) otherObj;
		
			if (otherProduct.getName().equals(name) && otherProduct.getPrice() == price
					&& otherProduct.getQuantity() == quantity) {
				return true;
			}

		return false; // FIX ME
	}
}
