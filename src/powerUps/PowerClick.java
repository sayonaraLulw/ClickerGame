package powerUps;

// Unterklasse

public class PowerClick extends PowerUp {
	
	public PowerClick(int level) {
		super(level);
	}
	
	// Calculate the power of a click
	public int getPower(int power) {
		power = power * super.getLevel();
		return power;
	}
}

