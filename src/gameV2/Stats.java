package gameV2;

public class Stats {
	// Variables
	private volatile int score = 0;
	private volatile int autoclickLevel = 0;
	private volatile int powerclickLevel = 1;
	private volatile int critclickLevel = 0;
	
	
	// Getter and setter
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getAutoclickLevel() {
		return autoclickLevel;
	}
	public void setAutoclickLevel(int autoclickLevel) {
		this.autoclickLevel = autoclickLevel;
	}
	public int getPowerclickLevel() {
		return powerclickLevel;
	}
	public void setPowerclickLevel(int powerclickLevel) {
		this.powerclickLevel = powerclickLevel;
	}
	public int getCritclickLevel() {
		return critclickLevel;
	}
	public void setCritclickLevel(int critclickLevel) {
		this.critclickLevel = critclickLevel;
	}
}