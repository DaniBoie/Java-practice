package labs.lab6;
import java.io.PrintWriter;
import java.io.File;
import java.util.Hashtable;
import java.util.Scanner;
import java.lang.AutoCloseable;
import java.util.ArrayList;

public class ProductDB {

	// ADD YOUR INSTANCE VARIABLES EHRE
	private ArrayList<Product> products;
	private String dbFile;
	/**
	 * Constructor that reads in the product data from a file
	 * 
	 * @param productsFileName name of file with product data
	 */
	public ProductDB(String productsFileName) {
		dbFile = productsFileName;
		try (Scanner input = new Scanner(new File(productsFileName))) {
			
			products = new ArrayList<Product>();

			while (input.hasNextLine()) {
				String line = input.nextLine();

				String[] productDescription = line.split(";", 0);

				Product newProduct = new Product(productDescription[0], Double.valueOf(productDescription[1]) , Integer.parseInt(productDescription[2]));
				products.add(newProduct);
			}
		} catch (Exception e) {
			System.out.print("File: " + dbFile + " not found");
		}
	}


	/**
	 * Searches for the product with the given name and returns it if found,
	 * otherwise returns null.
	 * 
	 * @param productName name of product to search for
	 * 
	 * @return product with given name, or null if not found
	 */
	public Product findProduct(String productName) {
		for (Product product : products) {
			if (product.getName().equals(productName)) {
				return product;
			}
		}
		return null;
	}


	/**
	 * Adds a new product to the products DB if a product with the given name
	 * doesn't already exist
	 * 
	 * @param name     name of product
	 * @param price    price of product
	 * @param quantity quantity of product
	 */
	public void addProduct(String name, double price, int quantity) {

		if (findProduct(name) == null) {
			Product newProduct = new Product(name, price, quantity);
			products.add(newProduct);
		}

		try (PrintWriter out = new PrintWriter(dbFile)) {
			for (Product product : products) {
				out.print(product.getName() + ";" + String.format("%.2f", product.getPrice()) + ";" + (int) product.getQuantity() + "\n");
			}
		} catch (Exception e) {
			System.out.print("File: " + dbFile + " not found");
		}
	}
}
