package org.example.gui.board;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;

import org.example.gui.board.piece.PieceComponent;

public class LayeredBoardPanel extends BoardPanel {

	private static final long serialVersionUID = 1L;
	
	private static final int BACKGROUND_LAYER = 0;
	private static final int PATH_LAYER = 1;
	
	private BoardMap map;
	private BoardMapSquares path; 
	private Map<String, PieceComponent> pieces;
	
	public LayeredBoardPanel(BoardMap map) {
		this.map = map;
		this.path = map.getPath();
		this.pieces = new HashMap<>();
		
		JLayeredPane layerPane = new JLayeredPane();
		
		layerPane.add(map.getComponent(), BACKGROUND_LAYER);
		layerPane.add(path.getComponent(), PATH_LAYER);
		
		super.add(layerPane);
	}
	
	@Override
	public void addPiece(String id, PieceComponent piece) {
		pieces.put(id, piece);
		path.getSquare(1).add(piece);
	}
	
	@Override
	public void movePiece(String pieceId, int targetSquareNr) {
		PieceComponent piece = pieces.get(pieceId);
		JComponent targetSquare = path.getSquare(targetSquareNr);
		
		targetSquare.add(piece);
		path.getComponent().revalidate();
	}

	@Override
	public PieceComponent removePiece(String id) {
		PieceComponent piece = pieces.remove(id);
		
		piece.getParent().remove(piece);
		
		return piece;
	}

}
