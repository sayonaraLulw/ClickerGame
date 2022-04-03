package powerUps;

import gameV2.Logic;

public class AutoClick extends PowerUp implements Runnable{
	
	Logic logic;

	public AutoClick(Logic logic, int level) {
		super(level);
		this.logic = logic;
	}

	// clicks every second while true
	public void run() {
		while (true) {
			logic.click(); 
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
