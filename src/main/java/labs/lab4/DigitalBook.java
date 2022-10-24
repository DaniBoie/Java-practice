package labs.lab4;

/**
 * Digital book item in a library
 */
public class DigitalBook extends Book {
	// ADD YOUR INSTANCE VARIABLES HERE

	private int numPages;
	private int loan_period = 14;
	private int max_checkouts = 3;
	private int current_checkouts;

	/**
	 * Constructor
	 * 
	 * @param title		book title
	 * @param author	book author
	 * @param numPages	number of pages
	 */
	public DigitalBook(String title, String author, int numPages) {
		// FILL IN
		super(title, author);
		this.numPages = numPages;
	}

	
	public int getNumPages() {
		return numPages; // FIX ME
	}
	
	
	public void setNumPages(int numPages) {
		// FILL IN
		this.numPages = numPages;
	}
	
	
	/**
	 * If the max number of checkouts for this item has not already been reached,
	 * this method checks this item out and returns the loan period; if no more
	 * check outs are available for this item, returns the String "NOT ALLOWED";
	 * overrides LibraryItem.checkOut()
	 */
	@Override
	public String checkOut() {
		if (current_checkouts == max_checkouts) {
			return "NOT ALLOWED";
		} else {
			current_checkouts += 1;
			return Integer.toString(loan_period) + " days";
		}
	}
	
	
	/**
	 * Checks in this item  (frees up one checkout for this item); overrides 
	 * LibraryItem.checkIn()
	 */
	@Override
	public void checkIn() {
		if (current_checkouts > 0) {
			current_checkouts -= 1;
		}
	}
	
	
	/**
	 * Returns true if the parameter object is a DigitalBook that has the same
	 * instance variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		// if (!super.equals(otherObject)) { return false; }
		if (otherObject instanceof DigitalBook) {
			DigitalBook other = (DigitalBook) otherObject;
			if (other.getTitle() == getTitle()) {
				if (other.getAuthor() == getAuthor()) {
					if (other.getNumPages() == getNumPages()) {
						return true;
					}
				}
			}
		}
		return false;
	}
}