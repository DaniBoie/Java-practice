package labs.lab4;

/**
 * Print book item in a library
 */
public class PrintBook extends Book {
	// ADD YOUR INSTANCE VARIABLES HERE
	private int numPages;
	int loan_period = 21;
	boolean checked_out;
	/**
	 * Constructor
	 * 
	 * @param title		book title
	 * @param author	book author
	 * @param numPages	number of pages
	 */
	public PrintBook(String title, String author, int numPages) {
		// FILL IN
		super(title, author);
		this.numPages = numPages;
		checked_out = false;
	}

	
	public int getNumPages() {
		return numPages; // FIX ME
	}

	
	public void setNumPages(int numPages) {
		// FILL IN
		this.numPages = numPages;
	}

	
	/**
	 * If this item is not already checked out, this method checks this item out
	 * and returns the loan period; if it is already checked out, returns the
	 * String "NOT ALLOWED"; overrides LibraryItem.checkOut()
	 */
	@Override
	public String checkOut() {
		if (checked_out) {
			return "NOT ALLOWED";
		} else {
			checked_out = true;
			return Integer.toString(loan_period) + " days";
		}
	}

	
	/**
	 * Returns true if the parameter object is a PrintBook that has the same
	 * instance variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		// if (!super.equals(otherObject)) { return false; }
		if (otherObject instanceof PrintBook) {
			PrintBook other = (PrintBook) otherObject;
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