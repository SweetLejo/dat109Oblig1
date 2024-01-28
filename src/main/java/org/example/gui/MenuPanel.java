package org.example.gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private MenuController controller;
	
	private JButton loadGameButton;
	private JButton newGameButton;
	
	public MenuPanel(MenuController controller) {
		super(new FlowLayout());
		this.controller = controller;
		this.loadGameButton = new JButton("Load saved game");
		this.newGameButton = new JButton("Create new game");
		
		loadGameButton.addActionListener(e -> onLoadSavedGame());
		newGameButton.addActionListener(e -> onCreateNewGame());
		
		add(loadGameButton);
		add(newGameButton);
	}
	
	private void onLoadSavedGame() {
		controller.loadSavedGame();
	}
	
	private void onCreateNewGame() {
		controller.createNewGame();
	}

}
