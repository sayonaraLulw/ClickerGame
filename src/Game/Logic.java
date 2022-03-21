package Game;

public class Logic {

	int score = 0;
	
	public void addScore(int amount) {
		score += amount;
	}
	
	public void removeScore(int amount) {
		score -= amount;
	}
}
