package gameV2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GUI_Shop extends JFrame implements ActionListener{
	// Variables
	JLabel shop = new JLabel();
	JLabel pupLvl1 = new JLabel("Level 1", SwingConstants.CENTER);
	JLabel pupLvl2 = new JLabel("Level 1", SwingConstants.CENTER);
	JLabel pupLvl3 = new JLabel("Level 1", SwingConstants.CENTER);
	JButton powerup1 = new JButton("Powerup 1");
	JButton powerup2 = new JButton("Powerup 2");
	JButton powerup3 = new JButton("Powerup 3");
	JButton closeShop = new JButton("Close shop");
	JPanel shopElements = new JPanel();
	
	public GUI_Shop(int score) {
		// Set layout
		setLayout(new BorderLayout());
		shopElements.setLayout(new GridLayout(3, 2));
		
		// JLabel
		shop = new JLabel("Shop - Score: " + score);
		add(shop, BorderLayout.NORTH);
		
		// Shop elements
		shopElements.add(powerup1);
		shopElements.add(pupLvl1);
		shopElements.add(powerup2);
		shopElements.add(pupLvl2);
		shopElements.add(powerup3);
		shopElements.add(pupLvl3);
		
		// ActionListener
		closeShop.addActionListener(this);
		
		// Adds
		add(shopElements, BorderLayout.CENTER);
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