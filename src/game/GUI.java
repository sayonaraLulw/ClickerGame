package game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GUI  extends JFrame implements ActionListener{

	JLabel score = new JLabel();
	JButton clicker = new JButton("press");
	
	
	Logic logic;
	
	public GUI(Logic logic) {
		
		setLayout(new BorderLayout());

		this.logic = logic;
		
		add(score, BorderLayout.NORTH);
		
		clicker.addActionListener(this);
		add(clicker, BorderLayout.CENTER);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 800);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == clicker) {
			logic.addScore(1);
			score.setText(String.valueOf(logic.score));
		}
		
	
	}
	
}
