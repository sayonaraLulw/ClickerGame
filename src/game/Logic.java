package game;

public class Logic {
	GUI g = new GUI(this);

	protected int score = 0;
	protected int power = 1;
	
	public void addScore(int amount) {
		score += amount;
	}
	
	public void removeScore(int amount) {
		score -= amount;
	}
	
	public void addPower(int amount, int price) {
		if(price <= score) {
			power += amount;
			removeScore(price);
		}
		else {
			g.notEnoughScore(price-score);
		}
	}
}
