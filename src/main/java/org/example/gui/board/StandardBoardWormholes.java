package org.example.gui.board;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.example.gui.board.wormhole.WormholePainter;

public class StandardBoardWormholes extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private BoardMapSquares squares;
	private List<WormholePainter> wormholes;
	
	public StandardBoardWormholes(BoardMapSquares squares) {
		super(null);
		this.squares = squares;
		this.wormholes = new ArrayList<>();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		wormholes.forEach(w -> paintWormhole(g, w));
	}
	
	protected void paintWormhole(Graphics g, WormholePainter wormhole) {
		JComponent start = squares.getSquare(wormhole.getStartSquareNr());
		JComponent end = squares.getSquare(wormhole.getEndSquareNr());
		
		wormhole.drawWormhole(g, start.getBounds(), end.getBounds());
	}
	
	public void addWormhole(WormholePainter wormhole) {
		wormholes.add(wormhole);
	}
	
	public void addWormholes(List<WormholePainter> wormholes) {
		this.wormholes.addAll(wormholes);
	}
	
	public BoardMapSquares getSquares() {
		return squares;
	}
	
	public void setSquares(BoardMapSquares squares) {
		this.squares = squares;
	}

}
