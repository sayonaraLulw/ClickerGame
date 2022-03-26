package game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GUI  extends JFrame implements ActionListener{

	JLabel score = new JLabel();
	JButton clicker = new JButton("press");
	JButton upgrade = new JButton("upgrade");
	
	
	Logic logic;
	
	public GUI(Logic logic) {
		
		setLayout(new BorderLayout());

		this.logic = logic;
		
		
		add(score, BorderLayout.NORTH);
		
		clicker.addActionListener(this);
		add(clicker, BorderLayout.CENTER);
		
		upgrade.addActionListener(this);
		add(upgrade, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 800);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == clicker) {
			logic.addScore(logic.power);
			refreshScore();
		}
		else if(e.getSource() == upgrade) {
			logic.addPower(1, 10);
			refreshScore();
		}
		
	
	}
	public void refreshScore() {
		score.setText(String.valueOf(logic.score));
	}
	
	public void notEnoughScore(int amount) {
		String st = "You don't have enough score. You need " + amount + " more score";
		JOptionPane.showMessageDialog(null, st);
	}
}
