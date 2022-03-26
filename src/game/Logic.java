package game;

public class Logic {
	//creates GUI
	GUI g = new GUI(this);

	//variables
	protected int score = 0;
	protected int power = 1;
	
	//function to add a specified number to the score
	public void addScore(int amount) {
		score += amount;
	}
	
	//function to remove a specified number from the score
	public void removeScore(int amount) {
		score -= amount;
	}
	
	//function to check if user has enough score and adds power to the click
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
