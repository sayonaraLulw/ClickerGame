package game;

public class Logic {
	GUI g = new GUI(this);

	protected int score = 0;
	
	public void addScore(int amount) {
		score += amount;
	}
	
	public void removeScore(int amount) {
		score -= amount;
	}
}
