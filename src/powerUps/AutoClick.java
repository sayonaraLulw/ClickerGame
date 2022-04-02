package powerUps;

public class AutoClick extends PowerUp implements Runnable{

	public AutoClick(int level) {
		super(level);
	}
	
	public int generateScore() {
		System.out.println(super.getLevel());
		return super.getLevel();
	}

	@Override
	public void run() {
		
		
	}

}
