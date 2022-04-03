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
	Logic logic = new Logic(this);
	
	// Variables Shop
	JFrame guiShop = new JFrame();
	JLabel shopScore = new JLabel();
	JLabel powerclickLvl = new JLabel("Level " + logic.stats.getPowerclickLevel(), SwingConstants.CENTER);
	JLabel autoclickLvl = new JLabel("Level " + logic.stats.getAutoclickLevel(), SwingConstants.CENTER);
	JLabel critclickLvl = new JLabel("Level " + logic.stats.getCritclickLevel(), SwingConstants.CENTER);
	JButton powerclick = new JButton("Powerclick - Price: " + logic.getPowerclickPrice());
	JButton autoclick = new JButton("Autoclick - Price: " + logic.getAutoclickPrice());
	JButton critclick = new JButton("Critclick - Price: " + logic.getCritclick());
	JButton closeShop = new JButton();
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
		shopScore.setText("Shop - Score: " + String.valueOf(logic.stats.getScore()));
		guiShop.add(shopScore, BorderLayout.NORTH);
		
		// Shop elements
		shopElements.add(powerclick);
		shopElements.add(powerclickLvl);
		shopElements.add(autoclick);
		shopElements.add(autoclickLvl);
		shopElements.add(critclick);
		shopElements.add(critclickLvl);
		
		powerclick.addActionListener(this);
		autoclick.addActionListener(this);
		critclick.addActionListener(this);
		
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
			//goldenClick.setVisible(true);
		}
		else if(e.getSource() == powerclick) {
			logic.buyPowerclick();
			refreshScore();
			refreshPrices();
			refreshLevel();
		}
		else if(e.getSource() == autoclick) {
			logic.buyAutoclick();
			refreshScore();
			refreshPrices();
			refreshLevel();
		}
		else if(e.getSource() == critclick) {
			logic.buyCritclick();
			refreshScore();
			refreshPrices();
			refreshLevel();
		}
		else if(e.getSource() == closeShop) {
			guiShop.dispose();
		}
	}
	// Refreshes the score
	public void refreshScore() {
		score.setText("Score: " + String.valueOf(logic.stats.getScore()));
		shopScore.setText("Shop - Score: " + String.valueOf(logic.stats.getScore()));
	}
	
	public void refreshPrices() {
		powerclick.setText("Powerclick - Price: " + logic.getPowerclickPrice());
		autoclick.setText("Autoclick - Price: " + logic.getAutoclickPrice());
		critclick.setText("Critclick - Price: " + logic.getCritclick());
	}
	
	public void refreshLevel() {
		powerclickLvl.setText("Level " + logic.stats.getPowerclickLevel());
		autoclickLvl.setText("Level " + logic.stats.getAutoclickLevel());
		critclickLvl.setText("Level " + logic.stats.getCritclickLevel());
	}
	
	// Gives error message if you don't have enough score
	public void notEnoughScore(int amount) {
		String st = "You don't have enough score. You need " + amount + " more score";
		JOptionPane.showMessageDialog(null, st);
	}
}