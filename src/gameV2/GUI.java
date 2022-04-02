package gameV2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener{
	// Initialize logic
	Logic logic = new Logic();
	
	// Variables Shop
	JFrame guiShop = new JFrame();
	JLabel shopScore = new JLabel();
	JLabel pupLvl1 = new JLabel("Level " + logic.stats.getPowerclickLevel(), SwingConstants.CENTER);
	JLabel pupLvl2 = new JLabel("Level " + logic.stats.getAutoclickLevel(), SwingConstants.CENTER);
	JLabel pupLvl3 = new JLabel("Level " + logic.stats.getCritclickLevel(), SwingConstants.CENTER);
	JButton powerUp1 = new JButton("Powerclick");
	JButton powerUp2 = new JButton("Autoclick");
	JButton powerUp3 = new JButton("Critclick");
	JButton closeShop = new JButton("Close shop");
	JPanel shopElements = new JPanel();
	
	// Variables Game
	JFrame guiGame = new JFrame();
	JLabel score = new JLabel();
	JButton clicker = new JButton("Click!");
	JButton shop = new JButton("Shop");
	
	
	public GUI() {	
		// Layout
		guiGame.setLayout(new BorderLayout());
		
		// Add score to NORTH
		guiGame.add(score, BorderLayout.NORTH);
		
		// Add clicker button to CENTER
		clicker.addActionListener(this);
		guiGame.add(clicker, BorderLayout.CENTER);
		
		// Add upgrade button to SOUTH
		shop.addActionListener(this);
		guiGame.add(shop, BorderLayout.SOUTH);
		
		// Default swing options
		guiGame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		guiGame.setSize(600, 800);
		guiGame.setVisible(true);
		
	}
	
	// GUI_Shop
	public void GUI_Shop(int score) {
		// Set layout
		guiShop.setLayout(new BorderLayout());
		shopElements.setLayout(new GridLayout(3, 2));
		
		// JLabel
		shopScore = new JLabel("Shop - Score: " + score);
		guiShop.add(shopScore, BorderLayout.NORTH);
		
		// Shop elements
		shopElements.add(powerUp1);
		shopElements.add(pupLvl1);
		shopElements.add(powerUp2);
		shopElements.add(pupLvl2);
		shopElements.add(powerUp3);
		shopElements.add(pupLvl3);
		
		powerUp1.addActionListener(this);
		powerUp2.addActionListener(this);
		powerUp3.addActionListener(this);
		
		// ActionListener
		closeShop.addActionListener(this);
		
		// Adds
		guiShop.add(shopElements, BorderLayout.CENTER);
		guiShop.add(closeShop, BorderLayout.SOUTH);
		
		// Swing defaults
		guiShop.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		guiShop.setSize(600, 800);
		guiShop.setVisible(true);
	}
	
	// Button actions
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == shop) {
			GUI_Shop(logic.stats.getScore());
		}
		else if(e.getSource() == clicker) {
			logic.click();
			refreshScore();
		}
		else if(e.getSource() == powerUp1) { // Powerclick
			logic.addPowerclick();
			pupLvl1.setText("Level " + logic.stats.getPowerclickLevel());
		}
		else if(e.getSource() == powerUp2) { // Autoclick
			logic.addAutoclick();
			pupLvl2.setText("Level " + logic.stats.getAutoclickLevel());
		}
		else if(e.getSource() == powerUp3) {
			logic.addCritclick();
			pupLvl3.setText("Level " + logic.stats.getCritclickLevel());
		}
		else if(e.getSource() == closeShop) {
			guiShop.dispose();
		}
	}
	// Refreshes the score
	public void refreshScore() {
		score.setText(String.valueOf(logic.stats.getScore()));
	}
	
	// Gives error message if you don't have enough score
	public void notEnoughScore(int amount) {
		String st = "You don't have enough score. You need " + amount + " more score";
		JOptionPane.showMessageDialog(null, st);
	}
}