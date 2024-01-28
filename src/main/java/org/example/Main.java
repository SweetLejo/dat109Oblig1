package org.example;

import org.example.db.BoardDAO;
import org.example.gui.GUIManager;
import org.example.gui.MenuController;

public class Main {

	public static void main(String[] args) {
		MenuController menuController = new MenuController(new BoardDAO());
		GUIManager guiManager = GUIManager.getInstance();
		
		guiManager.setContentPanel(menuController.getGUIPanel());
		guiManager.displayGUI();
	}
	
}
