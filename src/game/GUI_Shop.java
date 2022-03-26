package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class GUI_Shop extends JFrame implements ActionListener{
	// Variables
	JLabel shop = new JLabel();
	JLabel puplvl1 = new JLabel("Level 1", SwingConstants.CENTER);
	JLabel puplvl2 = new JLabel("Level 1", SwingConstants.CENTER);
	JLabel puplvl3 = new JLabel("Level 1", SwingConstants.CENTER);
	JButton powerup1 = new JButton("Powerup 1");
	JButton powerup2 = new JButton("Powerup 2");
	JButton powerup3 = new JButton("Powerup 3");
	JButton closeShop = new JButton("Close shop");
	JPanel shopelements = new JPanel();
	
	public GUI_Shop(int score) {
		// Set layout
		setLayout(new BorderLayout());
		shopelements.setLayout(new GridLayout(3, 2));
		
		// JLabel
		shop = new JLabel("Shop - Score: " + score);
		add(shop, BorderLayout.NORTH);
		
		// Shop elements
		shopelements.add(powerup1);
		shopelements.add(puplvl1);
		shopelements.add(powerup2);
		shopelements.add(puplvl2);
		shopelements.add(powerup3);
		shopelements.add(puplvl3);
		
		// ActionListener
		closeShop.addActionListener(this);
		
		// Adds
		add(shopelements, BorderLayout.CENTER);
		add(closeShop, BorderLayout.SOUTH);
		
		// Swing defaults
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(600, 800);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == closeShop) {
			dispose();
		}
	}
}