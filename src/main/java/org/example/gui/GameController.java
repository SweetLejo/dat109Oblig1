package org.example.gui;

import java.awt.Color;

import javax.swing.undo.AbstractUndoableEdit;

import org.example.db.BoardDAO;
import org.example.gui.board.BoardMap;
import org.example.gui.board.factory.BoardMapFactory;
import org.example.snakesAndLadders.board.Board;
import org.example.snakesAndLadders.board.Square;
import org.example.snakesAndLadders.player.Player;

public class GameController implements GUIController {
	
	private BoardDAO dao;
	private Board board;
	private BoardMap map;
	
	private GamePanel guiPanel;
	
	public GameController(BoardDAO dao, Board board, BoardMap map) {
		this.dao = dao;
		this.board = board;
		this.map = map;
		this.guiPanel = new GamePanel(this);
		
		updateDisplayedCurrentPlayer();
	}
	
	public void rollDice() {
		Player currentPlayer = board.getCurrentPlayer();
		int dieRoll = board.round();
		
		updateDisplayedDieRoll(dieRoll);
		moveDisplayedPlayerPiece(currentPlayer);
		updateDisplayedCurrentPlayer();
		
		dao.savePlayer(currentPlayer);
	}
	
	private void updateDisplayedDieRoll(int dieRoll) {
		guiPanel.updatePreviousDieRoll(dieRoll);
	}
	
	private void moveDisplayedPlayerPiece(Player player) {
		map.movePiece(player.getName(), player.getPosition().getValue());
	}

	private void updateDisplayedCurrentPlayer() {
		guiPanel.updateCurrentPlayer(board.getCurrentPlayer().getName());
	}
	
	public GamePanel getGUIPanel() {
		return guiPanel;
	}
	
	public BoardMap getBoardMap() {
		return map;
	}
	
}
