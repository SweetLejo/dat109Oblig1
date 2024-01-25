package org.example.gui;

import org.example.gui.board.BoardMap;
import org.example.snakesAndLadders.board.Board;

public class GameController {

	private GamePanel guiPanel;
	private Board board;
	
	public GameController(BoardMap map, Board board) {
		this.guiPanel = new GamePanel(this, map);
		this.board = board;
	}
	
	public GamePanel getGamePanel() {
		return guiPanel;
	}
	
	public void rollDice() {
		System.out.println("Rolling dice...");
		// roll dice for player and get updated position
		
		System.out.println("Moving piece...");
		// get piece/player id and move to updated position

		System.out.println("Updating current player...");
		// update current player on screen
		
		System.out.println("Saving gamestate...");
		// save board in database
		
	}
	
}
