package gameV2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener{

	// Variables
	JLabel score = new JLabel();
	JButton clicker = new JButton("Click!");
	JButton shop = new JButton("Shop");

	Logic logic = new Logic();
	
	
	public GUI() {	
		// Layout
		setLayout(new BorderLayout());
		
		// Add score to NORTH
		add(score, BorderLayout.NORTH);
		
		// Add clicker button to CENTER
		clicker.addActionListener(this);
		add(clicker, BorderLayout.CENTER);
		
		// Add upgrade button to SOUTH
		shop.addActionListener(this);
		add(shop, BorderLayout.SOUTH);
		
		// Default swing options
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 800);
		setVisible(true);
		
	}
	
	// Button actions
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == shop) {
			new GUI_Shop(0);
		}
		else if(e.getSource() == clicker) {
			logic.Click();
			refreshScore();
		}
	}
	// Refreshes the score
	public void refreshScore() {
		score.setText(String.valueOf(logic.getScore()));
	}
	
	// Gives error message if you don't have enough score
	public void notEnoughScore(int amount) {
		String st = "You don't have enough score. You need " + amount + " more score";
		JOptionPane.showMessageDialog(null, st);
	}
}