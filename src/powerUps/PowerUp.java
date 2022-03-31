package powerUps;

// Oberklasse

public class PowerUp {

	// Variables
	private int level;
	
	public PowerUp(int level) {
		this.level = level;
	}
	
	// Get Level and Power
	public int getLevel() {
		return level;
	}
	
	public int getPower(int power) {
		return power;
	}
}
