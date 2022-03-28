package game;

//test

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener{

	// Variables
	JLabel score = new JLabel();
	JButton clicker = new JButton("Click!");
	JButton shop = new JButton("Shop");

	Logic logic;
	
	public GUI(Logic logic) {
		// Layout
		setLayout(new BorderLayout());

		// connection to logic
		this.logic = logic;
		
		// add score to NORTH
		add(score, BorderLayout.NORTH);
		
		// add clicker button to CENTER
		clicker.addActionListener(this);
		add(clicker, BorderLayout.CENTER);
		
		// add upgrade button to SOUTH
		shop.addActionListener(this);
		add(shop, BorderLayout.SOUTH);
		
		// default swing options
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 800);
		setVisible(true);
		
	}
	
	//button actions
	public void actionPerformed(ActionEvent e) {
		
		//if clicker button is pressed
		if(e.getSource() == clicker) {
			logic.addScore(logic.power);
			refreshScore();
		}
		//if upgrade button is pressed
		else if(e.getSource() == shop) {
			refreshScore();
			new GUI_Shop(logic.score);
			//logic.addPower(1, 10);
		}
	}
	//refreshes the score
	public void refreshScore() {
		score.setText(String.valueOf(logic.score));
	}
	
	//gives error message if you don't have enough score
	public void notEnoughScore(int amount) {
		String st = "You don't have enough score. You need " + amount + " more score";
		JOptionPane.showMessageDialog(null, st);
	}
}
