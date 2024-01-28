package org.example.gui;

import java.util.ArrayList;
import java.util.List;

import org.example.db.BoardDAO;
import org.example.gui.board.BoardMap;
import org.example.gui.board.factory.BoardMapFactory;
import org.example.snakesAndLadders.board.Board;
import org.example.snakesAndLadders.player.Piece;
import org.example.snakesAndLadders.player.Player;

public class CreateGameController implements GUIController {

	private BoardDAO dao;
	private BoardMapFactory mapFactory;
	
	private CreateGamePanel guiPanel;
	
	public CreateGameController(BoardDAO dao, BoardMapFactory mapFactory) {
		this.dao = dao;
		this.mapFactory = mapFactory;
		this.guiPanel = new CreateGamePanel(this);
	}
	
	public void createBoard() {
		List<Player> players = guiPanel.getCreatePlayerPanels().stream() 
				.filter(p -> p.getName() != null && !p.getName().isBlank())
				.map(panel -> new Player(panel.getName(), panel.getPiece()))
				.toList();
		
		Board board = Board.createNewBoard(players);
		
		dao.saveNewBoard(board);
		
		BoardMap map = mapFactory.createBoardMap(board);
		GameController gameController = new GameController(dao, board, map);
		GamePanel gamePanel = gameController.getGUIPanel();
		
		GUIManager.getInstance().setContentPanel(gamePanel);
	}
	
	public CreateGamePanel getGUIPanel() {
		return guiPanel;
	}
	
	public Piece[] getPieceSelection() {
		return Piece.values();
	}
	
}
