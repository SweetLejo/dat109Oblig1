package org.example.gui.board;

import java.util.List;

import javax.swing.JComponent;

import org.example.gui.board.piece.PieceComponent;
import org.example.gui.board.wormhole.WormholePainter;

public class StandardBoardBuilder {

	private StandardBoardMap map;
	
	public StandardBoardBuilder() {
		map = new StandardBoardMap();
	}
	
	public StandardBoardBuilder withBackground(JComponent background) {
		map.setBackground(background);
		
		return this;
	}
	
	public StandardBoardBuilder withMapSquares(SquareFactory squareFactory) {
		map.fillMapSquares(squareFactory.createList(map.getGridSize()));
		
		return this;
	}
	
	public StandardBoardBuilder withPathSquares(SquareFactory squareFactory) {
		map.fillPathSquares(squareFactory.createList(map.getGridSize()));
		
		return this;
	}
	
	public StandardBoardBuilder addWormhole(WormholePainter wormhole) {
		map.addWormhole(wormhole);
		
		return this;
	}
	
	public StandardBoardBuilder addWormholes(List<WormholePainter> wormholes) {
		map.addWormholes(wormholes);
		
		return this;
	}
	
	public StandardBoardBuilder addPiece(String id, PieceComponent piece) {
		map.addPiece(id, piece);
		
		return this;
	}
	
	public StandardBoardMap build() {
		return map;
	}
	
}
