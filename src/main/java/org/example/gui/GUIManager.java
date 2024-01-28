package org.example.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIManager {

	private static GUIManager instance;
	
	private JFrame frame;
	
	private GUIManager() {
		this.frame = new JFrame("Snakes and Ladders");
	}
	
	public static GUIManager getInstance() {
		if(instance == null) {
			instance = new GUIManager();
		}
		
		return instance;
	}
	
	public void displayGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 700);
		frame.setVisible(true);
	}
	
	public void setContentPanel(JPanel panel) {
		frame.setContentPane(panel);
		frame.revalidate();
	}
	
}
