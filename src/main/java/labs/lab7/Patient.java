package labs.lab7;

/**
 * Class representing a patient in a hospital emergency room
 */
public class Patient implements Comparable<Patient> {

	// ADD YOUR INSTANCE VARIABLES HERE
	private Injury injury;
	private String description;
	private int priority;

	/**
	 * Creates a new Patient object with the given injury and description
	 */
	public Patient(Injury injury, String description) {
		this.injury = injury;
		this.description = description;
		priority = Injury.getTriageLevel(injury);
		// FILL IN
	}


	public int getPriority() {
		return priority; // FIX ME
	}


	public Injury getInjury() {
		return injury; // FIX ME
	}


	public String getDescription() {
		return description; // FIX ME
	}


	/**
	 * Compares patients by priority
	 */
	@Override
	public int compareTo(Patient p) {
		return Integer.compare(priority, p.getPriority());
	}
	
	
	/**
	 * Returns a string representation of this patient in the format:
	 * "Injury: [INJURY], Description: [DESCRIPTION]"
	 */
	@Override
	public String toString() {
		return "Injury: " + injury + ", Description: " + description; // FIX ME
	}

}