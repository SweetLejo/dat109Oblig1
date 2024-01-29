package org.example.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.example.db.BoardDAO;
import org.example.gui.board.BoardMap;
import org.example.gui.board.StandardBoardBuilder;
import org.example.gui.board.factory.BetterBoardMapFactory;
import org.example.gui.board.factory.BoardMapFactory;
import org.example.gui.board.factory.SimpleBoardMapFactory;
import org.example.gui.board.piece.CirclePiecePainter;
import org.example.gui.board.piece.PiecePainter;
import org.example.gui.board.wormhole.LineWormholePainter;
import org.example.gui.board.wormhole.WormholePainter;
import org.example.snakesAndLadders.board.Board;
import org.example.snakesAndLadders.board.Square;
import org.example.snakesAndLadders.player.Piece;
import org.example.snakesAndLadders.player.Player;

public class MenuController implements GUIController {

	private BoardDAO dao;
	private BoardMapFactory mapFactory;
	
	private MenuPanel guiPanel;
	
	public MenuController(BoardDAO dao) {
		this.dao = dao;
		this.mapFactory = new BetterBoardMapFactory();
		this.guiPanel = new MenuPanel(this);
	}
	
	public void loadSavedGame() {
		Board board = dao.getBoard();
		
		if(board == null) {
			System.err.println("No existing board found");
			return;
		}
		
		BoardMap map = mapFactory.createBoardMap(board);
		GameController gameController = new GameController(dao, board, map);
		GamePanel gamePanel = gameController.getGUIPanel();
		
		GUIManager.getInstance().setContentPanel(gamePanel);
	}
	
	public void createNewGame() {
		CreateGameController createGameController = new CreateGameController(dao, mapFactory);
		CreateGamePanel createGamePanel = createGameController.getGUIPanel();

		GUIManager.getInstance().setContentPanel(createGamePanel);
	}
	
	public MenuPanel getGUIPanel() {
		return guiPanel;
	}
	
}
