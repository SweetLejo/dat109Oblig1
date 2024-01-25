package org.example.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import org.example.gui.board.BoardMap;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private GameController controller;
	private GameBoardPanel boardPanel;
	private GameControlsPanel controlsPanel;
	
	public GamePanel(GameController controller, BoardMap map) {
		super(new BorderLayout());
		this.controller = controller;
		this.boardPanel = new GameBoardPanel(map);
		this.controlsPanel = new GameControlsPanel();
		
		controlsPanel.setOnRollDice(e -> onRollDice());
		
		add(boardPanel, BorderLayout.CENTER);
		add(controlsPanel, BorderLayout.SOUTH);
	}
	
	public void onRollDice() {
		controller.rollDice();
	}
	
	public void updateCurrentPlayer(String currentPlayer) {
		controlsPanel.setCurrentPlayer(currentPlayer);
	}
	
	public void movePiece(String id, int targetSquareNr) {
		boardPanel.movePiece(id, targetSquareNr);
	}
	
	public GameBoardPanel getBoardPanel() {
		return boardPanel;
	}
	
	public GameControlsPanel getControlsPanel() {
		return controlsPanel;
	}
	
}
