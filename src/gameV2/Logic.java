package gameV2;

import java.util.ArrayList;

import powerUps.*;

public class Logic {
	// Initialize stats
	Stats stats = new Stats();
	ArrayList<PowerUp> powerups = new ArrayList<PowerUp>();
	
	public Logic() {
		// Add powerups
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
	
	protected int getScore() {
		return stats.getScore();
	}
	
	// Click calls 
	protected void Click() {
		int power = 1;
		PowerClick powerclick = new PowerClick(stats.getPowerclickLevel(), power);
		power = powerclick.getPower();
		CritClick critclick = new CritClick(stats.getCritclickLevel(), power);
		power = critclick.getPower();
		addScore(power);
	}
}