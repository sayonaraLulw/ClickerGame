package powerUps;

// Unterklasse

import java.util.Random;

public class CritClick extends PowerUp{

	public CritClick(int level, int power) {
		super(level, power);
	}
	
	
	
	public int getPower() {
		Random rand = new Random();
		
		// Calculate the chance to crit
		boolean crithit = (rand.nextInt(100) < super.getLevel());
		
		// Calculate the new Power of the click
		if (crithit = true) {
			int power = super.getPower() * 2;
			return power;
		}
		else {
			return super.getPower();
		}
		
	}
}
