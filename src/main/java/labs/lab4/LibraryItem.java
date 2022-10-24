package labs.lab4;

/**
 * An abstract item that can be checked out of a library
 */
public abstract class LibraryItem {
	// ADD YOUR INSTANCE VARIABLES HERE
	String title;
	boolean checked_out;


	
	/**
	 * Constructor
	 * 
	 * @param title	title of the item
	 */
	public LibraryItem(String title) {
		this.title = title;
		checked_out = false;
		// FILL IN
	}
	
	
	public String getTitle() {
		return title; // FIX ME
	}
	
	
	public boolean isCheckedOut() {
		return checked_out; // FIX ME
	}
	
	
	public void setCheckedOut(boolean checkedOut) {
		// FILL IN
		this.checked_out = checkedOut;
	}
	
	
	/**
	 * Causes this item to be checked out
	 * 
	 * @return	a message about the check out
	 */
	public abstract String checkOut();
	
	
	/**
	 * Causes this item to be checked in
	 */
	public void checkIn() {
		// FILL IN
		checked_out = false;

	}
	
	
	public String toString() {
		return title; // FIX ME
	}
	
	
	/**
	 * Returns true if the parameter object is a LibraryItem that has the same instance
	 * variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		// if (!super.equals(otherObject)) { return false; }
		if (otherObject instanceof LibraryItem) {
			LibraryItem other = (LibraryItem) otherObject;
			if (other.getTitle() == getTitle()) {
				return true;
			}
		}
		return false;
	}
}