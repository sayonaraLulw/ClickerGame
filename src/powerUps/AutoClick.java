package powerUps;

public class AutoClick extends PowerUp{

	public AutoClick(int level) {
		super(level);
	}
	
	public int generateScore() {
		System.out.println(super.getLevel());
		return super.getLevel();
	}

}
