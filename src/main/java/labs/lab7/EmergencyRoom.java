package labs.lab7;

import java.util.PriorityQueue;

public class EmergencyRoom {

	private PriorityQueue<Patient> patients;


	public EmergencyRoom() {
		patients = new PriorityQueue<Patient>();
	}


	/**
	 * Adds a patient to the ER queue with the given injury and description
	 * 
	 * @param injury
	 * @param description
	 */
	public void addPatient(Injury injury, String description) {
		Patient newPatient = new Patient(injury, description);
		patients.add(newPatient);
	}


	/**
	 * Gets the next highest priority patient
	 */
	public Patient nextPatient() {
		try {
			return patients.remove();
		} catch (Exception e) {
			return null;
		}
	}
}