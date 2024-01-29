package org.example.gui.board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import org.example.gui.board.piece.PiecePainter;
import org.example.gui.board.wormhole.WormholePainter;

public class StandardBoardMap extends JLayeredPane implements BoardMap {
	
	private static final long serialVersionUID = 1L;
	
	private static final int BACKGROUND_LAYER = 0;
	private static final int SQUARES_LAYER = 1;
	private static final int WORMHOLES_LAYER = 2;
	private static final int PATH_LAYER = 3;
	
	private JComponent background;
	private StandardBoardGrid squares;
	private StandardWormholesPanel wormholes;
	private StandardPiecesPanel pieces;

	public StandardBoardMap() {
		this(10, 10);
	}
	
	public StandardBoardMap(int rows, int columns) {
		this.background = new JPanel();
		this.squares = new StandardBoardGrid(rows, columns);
		this.wormholes = new StandardWormholesPanel(squares);
		this.pieces = new StandardPiecesPanel(squares);
		
		squares.setOpaque(false);
		wormholes.setOpaque(false);
		pieces.setOpaque(false);
		
		add(background, BACKGROUND_LAYER, 0);
		add(squares, SQUARES_LAYER, 0);
		add(wormholes, WORMHOLES_LAYER, 0);
		add(pieces, PATH_LAYER, 0);
	}
	
	@Override
    public void doLayout() {
        synchronized(getTreeLock()) {
            int w = getWidth();
            int h = getHeight();
            for(Component c : getComponents()) {
                c.setBounds(0, 0, w, h);
                c.setLocation(0, 0);
            }
        }
    }
	
	public void setBackground(JComponent background) {
		if(this.background != null) {
			remove(this.background);
		}
		
		add(background, BACKGROUND_LAYER);
		this.background = background;
	}
	
	public void fillMapSquares(SquareFactory squareComponents) {
		squares.fillGrid(squareComponents);
	}
	
	public void addWormhole(WormholePainter wormhole) {
		wormholes.addWormhole(wormhole);
	}
	
	public void addWormholes(List<WormholePainter> wormholes) {
		wormholes.forEach(this::addWormhole);
	}

	@Override
	public void addPiece(String id, PiecePainter piece) {
		pieces.addPiece(id, piece);
	}

	@Override
	public void movePiece(String id, int targetSquareNr) {
		pieces.movePiece(id, targetSquareNr);
	}

	@Override
	public PiecePainter removePiece(String id) {
		return pieces.removePiece(id);
	}
	
	@Override
	public JComponent getComponent() {
		return this;
	}
	
	public int getGridSize() {
		return squares.getGridSize();
	}

	public StandardBoardGrid getSquares() {
		return squares;
	}

	public StandardWormholesPanel getWormholes() {
		return wormholes;
	}

	public StandardPiecesPanel getPieces() {
		return pieces;
	}
	
}
