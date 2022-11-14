package labs.lab7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Class for simulating a driveway and a street, using stacks of cars with
 * license plate numbers as representation.
 */
public class Driveway {
	private Stack<Integer> driveway; // represents cars in the driveway
	private Stack<Integer> street; // represents cars on the street

	/**
	 * Constructor
	 */
	public Driveway() {
		// FILL IN
		driveway = new Stack<Integer>();
		street = new Stack<Integer>();
	}

	
	/**
	 * Returns a String representation of the driveway. For a driveway stack
	 * with cars 1, 2, 3, and 4, with 1 first-in and 4 first-out, the string
	 * returned by this method would be: "Driveway: 1 2 3 4"
	 * 
	 * @return	a String representation of this driveway
	 */
	public String getDriveway() {
		String returnString = "";
		Iterator value = driveway.iterator();

		while (value.hasNext()) {
			returnString += " " + value.next();
		}

		if (returnString.length() == 0){
			returnString = "Driveway: ";
		} else {
			returnString = "Driveway:" + returnString;
		}

		
		return returnString; // FIX ME
	}

	
	/**
	 * Returns a String representation of the street. For a street stack 
	 * with cars 1, 2, 3, and 4, with 1 first-in and 4 first-out, the string 
	 * returned by this method would be: "Street: 1 2 3 4"
	 * 
	 * @return	a String representation of the street
	 */
	public String getStreet() {
		String returnString = "";
		Iterator value = street.iterator();

		while (value.hasNext()) {
			returnString += " " + value.next();
		}

		if (returnString.length() == 0) {
			returnString = "Street: ";
		} else {
			returnString = "Street:" + returnString;
		}

		return returnString; // FIX ME
	}

	
	/**
	 * Adds the given license plate to the driveway if it's not already in the
	 * driveway. Returns a log of the process.
	 * 
	 * @param licensePlate number of license plate.
	 * 
	 * @return a log of the process
	 */
	public List<String> add(int licensePlate) {
		if (!driveway.contains(licensePlate)) {
			driveway.push(licensePlate);
			return List.of(getDriveway(), getStreet());
		} else {
			return List.of("That car is already in the driveway.");
		}		
	}

	/**
	 * Remove the given license plate from the driveway if it's in the driveway.
	 * Returns a log of the process
	 * 
	 * @param licensePlate number of license plate.
	 * 
	 * @return a log of the process
	 */
	public List<String> remove(int licensePlate) {

		ArrayList<String> log = new ArrayList<String>();
		if(!driveway.contains(licensePlate)){
			return List.of("That car is not in the driveway.");
		}
		while (driveway.contains(licensePlate)) {
			if (driveway.peek() == licensePlate) {
				driveway.pop();

				if (street.isEmpty()) {
					log.add(getDriveway());
					log.add(getStreet());
				}

				while (!street.empty()) {
					driveway.push(street.pop());
					log.add(getDriveway());
					log.add(getStreet());
				}
				break;
			} else {
				street.push(driveway.pop());
				log.add(getDriveway());
				log.add(getStreet());
			}
		}

		return List.copyOf(log); // FIX ME
	}
}
