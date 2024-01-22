package org.example.gui.board;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * The GUI component of the board. This component has two layers: the 
 * background and the grid. The background contains the all the visible squares
 * and wormholes. That's what will be seen as the board. The grid is layered on 
 * top of the background, and is used to add and move PieceComponents through.
 */
public class BoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private static final int BACKGROUND_LAYER = 0;
	private static final int GRID_LAYER = 1;
	
	private BoardBackground background;
	private BoardGrid grid; 
	
	private Map<String, PieceComponent> pieces;
	
	public BoardPanel(BoardBackground background, BoardGrid grid) {
		this.background = background;
		this.grid = grid;
		this.pieces = new HashMap<>();
		
		JLayeredPane layerPane = new JLayeredPane();
		
		layerPane.add(background, BACKGROUND_LAYER);
		layerPane.add(grid, GRID_LAYER);
		
		super.add(layerPane);
	}
	
	public void addPiece(String id, PieceComponent piece) {
		pieces.put(id, piece);
	}
	
	public void movePiece(String pieceId, int targetSquareNr) {
		PieceComponent piece = pieces.get(pieceId);
		JComponent targetSquare = grid.getSquare(targetSquareNr);
		
		targetSquare.add(piece);
		grid.validate();
	}

}
