package labs.lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * A DVD item in a library
 */
public class DVD extends LibraryItem {
	// ADD YOUR INSTANCE VARIABLES HERE
	String title;
	List<String> actors;
	boolean checked_out;
	int max_checkouts = 1;
	int loan_period = 7;
	
	/**
	 * Constructor
	 * 
	 * @param title		title of the DVD
	 * @param actors	actors in the DVD
	 */
	public DVD(String title, List<String> actors) {
		// FILL IN
		super(title);
		this.actors = actors;
		checked_out = false;
	}

	
	public List<String> getActors() {
		return actors; // FIX ME
	}
	
	
	public void setActors(List<String> actors) {
		// FILL IN
		this.actors = actors;
	}
	
	
	/**
	 * If this item is not already checked out, this method checks this item out and 
	 * returns the loan period; if it is already checked out, returns the String 
	 * "NOT ALLOWED"; overrides LibraryItem.checkOut()
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
	 * Returns true if the parameter object is a DVD that has the same instance 
	 * variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		// if (!super.equals(otherObject)) { return false; }
		if (otherObject instanceof DVD) {
			DVD other = (DVD) otherObject;
			if (other.getTitle() == getTitle()) {
				if (other.getActors() == getActors()) {
					return true;
				}
			}
		}
		return false;
	}
}