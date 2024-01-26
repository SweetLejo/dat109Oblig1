package org.example.gui;

import java.awt.Color;

import javax.swing.undo.AbstractUndoableEdit;

import org.example.db.BoardDAO;
import org.example.gui.board.BoardMap;
import org.example.snakesAndLadders.board.Board;
import org.example.snakesAndLadders.board.Square;
import org.example.snakesAndLadders.player.Player;

public class GameController {
	
	private GamePanel gui;
	private BoardDAO dao;
	private Board board;
	
	public GameController(BoardMap map, BoardDAO dao) {
		this.dao = dao;
		this.gui = new GamePanel(this, map);
		this.board = dao.getBoard();
	}
	
	public GamePanel getGamePanel() {
		return gui;
	}
	
	public void rollDice() {
		Player currentPlayer = board.getCurrentPlayer();
		
		board.round();
		moveGuiPiece(currentPlayer);
		dao.saveExistingBoard();
	}
	
	private void moveGuiPiece(Player player) {
		int newSquareNr = player.getPosition().getValue();
		
		gui.movePiece(player.getPiece().toString(), newSquareNr);
	}
	
	public void updateGui() {
		
	}
	
	
}
