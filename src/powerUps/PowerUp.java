package powerUps;

// Oberklasse

public class PowerUp {

	// Variables
	private int level;
	private int power;
	
	public PowerUp(int level, int power) {
		this.level = level;
		this.power = power;
	}
	
	// Get Level and Power
	protected int getLevel() {
		return level;
	}
	
	protected int getPower() {
		return power;
	}
}
