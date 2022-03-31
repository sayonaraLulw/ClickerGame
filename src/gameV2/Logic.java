package gameV2;

import java.util.ArrayList;

import powerUps.*;

public class Logic {
	// Initialize stats
	Stats stats = new Stats();
	ArrayList<PowerUp> powerups = new ArrayList<PowerUp>();
	
	public Logic() {
		// Add powerups
		PowerClick powerclick = new PowerClick(stats.getPowerclickLevel());
		CritClick critclick = new CritClick(stats.getCritclickLevel());
		powerups.add(powerclick);
		powerups.add(critclick);
	}
	
	// Methods
	protected void addScore(int amount) {
		stats.setScore(stats.getScore() + amount);
	}
	
	protected void removeScore(int amount) {
		stats.setScore(stats.getScore() - amount);
	}
	
	protected void addPower(int amount) {
		stats.setPowerclickLevel(stats.getPowerclickLevel() + amount);
	}
	
	protected void addAutoclick(int amount) {
		stats.setAutoclickLevel(stats.getAutoclickLevel() + amount);
	}
	
	// Get from Stats
	protected int getScore() {
		return stats.getScore();
	}
	
	// Click calls 
	protected void Click() {
		int power = 1;
		
		 for (int i = 0; i < powerups.size(); i++) {
			 	PowerUp p = powerups.get(i);
			 	power = p.getPower(power);;
	        }
		
		addScore(power);
	}
}