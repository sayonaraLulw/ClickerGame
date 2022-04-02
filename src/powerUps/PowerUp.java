package powerUps;

// Oberklasse

public class PowerUp {

	// Variables
	private int level;
	
	public PowerUp(int level) {
		this.level = level;
	}
	
	// Get / Set Level and Power
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getPower(int power) {
		return power;
	}
	
	
}
