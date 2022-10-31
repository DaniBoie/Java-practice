package labs.lab5;

public class Activity extends GameElement implements Doable {
	
	// ADD YOUR INSTANCE VARIABLES EHRE
	private int duration;
	/**
	 * 
	 * @param name
	 * @param healthScore
	 * @param duration	in hours
	 */
	public Activity(String name, double healthScore, int duration) {
		super(name, healthScore);
		this.duration = duration;
		// FILL IN
	}
	
	
	/**
	 * For every this.healthScore point above 5, adds 0.05 to the player's health.
	 * For every this.healthScore point below 5, subtracts 0.05 from the player's health.
	 * If this.healthScore == 5, makes no change to the player's health
	 */
	@Override
	public String doIt(Player player) {
		double health = super.getHealthScore() - 5;

		while (health > 0) {
			player.setHealth(player.getHealth() + 0.05);
			health -= 1;
		}

		while (health < 0) {
			player.setHealth(player.getHealth() - 0.05);
			health += 1;
		}
		return player.getName() + " is doing " + super.getName() + " for " + duration + " hours"; // FIX ME
	}
}