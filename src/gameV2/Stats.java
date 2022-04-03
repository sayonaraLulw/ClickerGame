package gameV2;

public class Stats {
	// Variables
	private int score = 0;
	private int autoclickLevel = 0;
	private int powerclickLevel = 1;
	private int critclickLevel = 0;
	private boolean goldenclick = false;
	
	
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
	public boolean isGoldenclick() {
		return goldenclick;
	}
	public void setGoldenclick(boolean goldenclick) {
		this.goldenclick = goldenclick;
	}
}