package org.example;

import org.example.db.BoardDAO;
import org.example.gui.GUIManager;
import org.example.gui.MenuController;

public class Main {

	public static void main(String[] args) {
		GUIManager guiManager = GUIManager.getInstance();
		MenuController menuController = new MenuController(new BoardDAO());
		
		guiManager.setContentPanel(menuController.getGUIPanel());
		guiManager.displayGUI();
	}
	
}
