package labs.lab5;

public abstract class GameElement {
	
	// ADD YOUR INSTANCE VARIABLES HERE
	// A GameElement with a health score of 5 is a neutral element, meaning
	// ingesting/doing it has no effect on health.
	private String name;
	private double healthScore;
	/**
	 * 
	 * @param name
	 * @param healthScore	from 0 (least healthy) to 10 (most healthy)
	 * 						(If below 0, sets it to 0; if above 10, sets it to 10)
	 */						
	public GameElement(String name, double healthScore) {
		// FILL IN
		this.name = name;

		if (healthScore < 0) {
			this.healthScore = 0;
		} else if (healthScore > 10) {
			this.healthScore = 10;
		} else {
			this.healthScore = healthScore;
		}
		
	}
	
	
	public String getName() {
		return name; // FIX ME
	}
	
	
	public double getHealthScore() {
		return healthScore; // FIX ME
	}
}