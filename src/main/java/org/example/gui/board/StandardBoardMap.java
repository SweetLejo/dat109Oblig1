package org.example.gui.board;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import org.example.gui.board.piece.PieceComponent;
import org.example.gui.board.wormhole.WormholePainter;

public class StandardBoardMap extends JLayeredPane implements BoardMap {
	
	private static final long serialVersionUID = 1L;
	
	private static final int BACKGROUND_LAYER = 0;
	private static final int MAP_GRID_LAYER = 1;
	private static final int WORMHOLES_LAYER = 2;
	private static final int PATH_LAYER = 3;
	
	private JComponent background;
	private StandardBoardGrid squares;
	private StandardBoardWormholes wormholes;
	private StandardBoardGrid path;
	
	private Map<String, PieceComponent> pieces;
	
	public StandardBoardMap() {
		this(10, 10);
	}
	
	public StandardBoardMap(int rows, int columns) {
		this.background = new JPanel();
		this.squares = new StandardBoardGrid(rows, columns);
		this.wormholes = new StandardBoardWormholes(squares);
		this.path = new StandardBoardGrid(rows, columns);
		this.pieces = new HashMap<>();

		add(background, BACKGROUND_LAYER);
		add(squares, MAP_GRID_LAYER);
		add(wormholes, WORMHOLES_LAYER);
		add(path, PATH_LAYER);
	}
	
	public void setBackground(JComponent background) {
		replace(this.background, background, BACKGROUND_LAYER);
		this.background = background;
	}
	
	protected void replace(JComponent old, JComponent replacement, int layer) {
		remove(old);
		add(replacement, layer);
	}
	
	public void fillMapSquares(List<JComponent> squareComponents) {
		squares.fillGrid(squareComponents);
	}
	
	public void fillPathSquares(List<JComponent> squareComponents) {
		path.fillGrid(squareComponents);
	}
	
	public void addWormhole(WormholePainter wormhole) {
		wormholes.addWormhole(wormhole);
	}
	
	public void addWormholes(List<WormholePainter> wormholes) {
		wormholes.forEach(this::addWormhole);
	}

	@Override
	public void addPiece(String id, PieceComponent piece) {
		pieces.put(id, piece);
		path.getSquare(piece.getCurrentSquareNr()).add(piece);
	}

	@Override
	public void movePiece(String id, int targetSquareNr) {
		PieceComponent piece = pieces.get(id);
		
		path.getSquare(targetSquareNr).add(piece);
		piece.setCurrentSquareNr(targetSquareNr);
	}

	@Override
	public PieceComponent removePiece(String id) {
		PieceComponent piece = pieces.get(id);
		
		path.getSquare(piece.getCurrentSquareNr()).remove(piece);
		pieces.remove(id);
		
		return piece;
	}
	
	@Override
	public JComponent getComponent() {
		return this;
	}

}
