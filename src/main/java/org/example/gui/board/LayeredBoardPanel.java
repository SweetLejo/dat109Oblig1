package org.example.gui.board;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class LayeredBoardPanel extends BoardPanel {

	private static final long serialVersionUID = 1L;
	
	private static final int BACKGROUND_LAYER = 0;
	private static final int GRID_LAYER = 1;
	
	private JPanel background;
	private BoardGrid grid; 
	
	private Map<String, PieceComponent> pieces;
	
	public LayeredBoardPanel(JPanel background, BoardGrid grid) {
		this.background = background;
		this.grid = grid;
		this.pieces = new HashMap<>();
		
		JLayeredPane layerPane = new JLayeredPane();
		
		layerPane.add(background, BACKGROUND_LAYER);
		layerPane.add(grid, GRID_LAYER);
		
		super.add(layerPane);
	}
	
	@Override
	public void addPiece(String id, PieceComponent piece) {
		pieces.put(id, piece);
		grid.getSquare(1).add(piece);
	}
	
	@Override
	public void movePiece(String pieceId, int targetSquareNr) {
		PieceComponent piece = pieces.get(pieceId);
		JComponent targetSquare = grid.getSquare(targetSquareNr);
		
		targetSquare.add(piece);
		grid.validate();
	}

}
