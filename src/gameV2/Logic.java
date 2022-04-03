package gameV2;

import java.util.ArrayList;

import powerUps.*;

public class Logic {
	// Initialize stats
	Stats stats = new Stats();
	ArrayList<PowerUp> powerups = new ArrayList<PowerUp>();
	GUI gui;
	
	// Shop
	private int PowerclickPrice = (stats.getPowerclickLevel()*100+100);
	private int AutoclickPrice = (stats.getAutoclickLevel()*500+500);
	private int CritclickPrice = (stats.getCritclickLevel()*100+100);
	
	public Logic(GUI gui) {	
		this.gui = gui;
	}
	
	// Methods
	public void addScore(int amount) {
		stats.setScore(stats.getScore() + amount);
	}
	
	public void removeScore(int amount) {
		stats.setScore(stats.getScore() - amount);
	}
	
	public void addPowerclick() {
		stats.setPowerclickLevel(stats.getPowerclickLevel() + 1);
	}
	
	// creates a new Autoclick class inside a new thread.
	public void addAutoclick() {
		stats.setAutoclickLevel(stats.getAutoclickLevel() + 1);
		AutoClick auto = new AutoClick(this, stats.getAutoclickLevel());
		Thread t =new Thread(auto);
		t.start();
	}
	
	public void addCritclick() {
		stats.setCritclickLevel(stats.getCritclickLevel()+ 1);
	}
	// Refreshes the powerups by deleting the old one and creating them new with the current variables
	public void refreshPowerUps() {
		powerups.clear();
		PowerClick powerclick = new PowerClick(stats.getPowerclickLevel());
		CritClick critclick = new CritClick(stats.getCritclickLevel());
		powerups.add(powerclick);
		powerups.add(critclick);
	}
	
	// Click calls 
	public void click() {
		int power = 1;
		refreshPowerUps();
		// Goes in all the PowerUps and calculates the new Power
		 for (int i = 0; i < powerups.size(); i++) {
			 	PowerUp p = powerups.get(i);
			 	power = p.getPower(power);;
	        }
		addScore(power);
		gui.refreshScore();
	}
	
	// Shop price getters
	public int getPowerclickPrice() {
		return PowerclickPrice;
	}
	
	public int getAutoclickPrice() {
		return AutoclickPrice;
	}
	
	public int getCritclickPrice() {
		return CritclickPrice;
	}
	
	// Shop refresh prices
	public void refreshPowerclickPrice() {
		PowerclickPrice = (stats.getPowerclickLevel())*100+100;
	}
	
	public void refreshAutoclickPrice() {
		AutoclickPrice = (stats.getAutoclickLevel())*500+500;
	}
	
	public void refreshCritclickPrice() {
		CritclickPrice = (stats.getCritclickLevel())*100+100;
	}
	
	// Shop - Buying
	public void buyPowerclick() {
		if(stats.getScore() >= getPowerclickPrice()) {
			stats.setScore(stats.getScore() - getPowerclickPrice());
			addPowerclick();
			refreshPowerclickPrice();
		}else {
			gui.notEnoughScore(getPowerclickPrice() - stats.getScore());
		}
	}
	
	public void buyAutoclick() {
		if(stats.getScore() >= getAutoclickPrice()) {
			stats.setScore(stats.getScore() - getAutoclickPrice());
			addAutoclick();
			refreshAutoclickPrice();
		}else {
			gui.notEnoughScore(getAutoclickPrice() - stats.getScore());
		}
	}
	
	public void buyCritclick() {
		if(stats.getScore() >= getCritclickPrice()) {
			stats.setScore(stats.getScore() - getCritclickPrice());
			addCritclick();
			refreshCritclickPrice();
		}else {
			gui.notEnoughScore(getCritclickPrice() - stats.getScore());
		}
	}
}