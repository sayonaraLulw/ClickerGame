package powerUps;

// Unterklasse

import java.util.Random;

public class CritClick extends PowerUp{

	public CritClick(int level) {
		super(level);
	}
	
	
	
	public int getPower(int power) {
		Random rand = new Random();
		
		// Calculate the chance to crit
		boolean crithit = (rand.nextInt(100) < super.getLevel());
		// Calculate the new Power of the click
		if (crithit == true) {
			power = power * 2;
			return power;
		}
		else {
			return power;
		}
		
	}
}
