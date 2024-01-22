package org.example.gui.board;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import org.example.gui.board.grid.BoardMapGrid;

public class LayeredBoardPanel extends BoardPanel {

	private static final long serialVersionUID = 1L;
	
	private static final int BACKGROUND_LAYER = 0;
	private static final int PATH_LAYER = 1;
	
	private BoardMap background;
	private BoardMapPath path; 
	
	private Map<String, PieceComponent> pieces;
	
	public LayeredBoardPanel(BoardMap background, BoardMapGrid path) {
		this.background = background;
		this.path = path;
		this.pieces = new HashMap<>();
		
		JLayeredPane layerPane = new JLayeredPane();
		
		layerPane.add(background, BACKGROUND_LAYER);
		layerPane.add(path, PATH_LAYER);
		
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
		path.validate();
	}

	@Override
	public PieceComponent removePiece(String id) {
		PieceComponent piece = pieces.remove(id);
		
		piece.getParent().remove(piece);
		
		return piece;
	}

	@Override
	public void addWormhole(WormholeComponent wormhole) {
		background.addWormhole(wormhole);
	}

	@Override
	public WormholeComponent removeWormhole(WormholeComponent wormhole) {
		return background.removeWormhole(wormhole);
	}

}
