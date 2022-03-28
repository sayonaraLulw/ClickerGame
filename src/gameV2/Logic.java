package gameV2;

import powerUps.*;

public class Logic {
	// Initialize stats
	Stats stats = new Stats();
	PowerClick powerclick = new PowerClick(0);
	
	// Methods
	protected void addScore(int amount) {
		stats.setScore(stats.getScore() + amount);
	}
	
	protected void removeScore(int amount) {
		stats.setScore(stats.getScore() - amount);
	}
	
	protected void addPower(int amount) {
		stats.setPower(stats.getPower() + amount);
	}
	
	protected void addAutoclick(int amount) {
		stats.setAutoclick(stats.getAutoclick() + amount);
	}
	
	// Get from Stats
	protected int getScore() {
		return stats.getScore();
	}
	
	public int getPower() {
		return stats.getPower();
	}
	
	public int getAutoclick() {
		return stats.getAutoclick();
	}
	protected void calculateClick() {

	}
}