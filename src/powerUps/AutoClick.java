package powerUps;

import gameV2.Logic;

public class AutoClick extends PowerUp implements Runnable{
	
	Logic logic;

	public AutoClick(Logic logic, int level) {
		super(level);
		this.logic = logic;
	}

	@Override
	public void run() {
		while (true) {
			for (int i = 1; i <= super.getLevel(); i++ ) {
				logic.click();
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
