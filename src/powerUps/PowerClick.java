package powerUps;

// Unterklasse

public class PowerClick extends PowerUp {
	
	public PowerClick(int level, int power) {
		super(level, power);
	}
	
	// Calculate the power of a click
	public int getPower() {
		int power = super.getPower() * super.getLevel();
		return power;
	}

}

