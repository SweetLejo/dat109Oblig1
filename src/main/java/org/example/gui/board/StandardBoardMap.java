package org.example.gui.board;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import org.example.gui.board.wormhole.WormholeComponent;

public class StandardBoardMap extends JLayeredPane implements BoardMap {
	
	private static final long serialVersionUID = 1L;
	
	private static final int MAP_GRID_LAYER = 1;
	private static final int WORMHOLES_LAYER = 2;
	
	private StandardBoardGrid mapGrid;
	private StandardBoardGrid pathGrid;
	private JPanel wormholesPanel;
	private List<WormholeComponent> wormholes;
	
	public StandardBoardMap(int rows, int columns) {
		this.mapGrid = new StandardBoardGrid(rows, columns);
		this.pathGrid = new StandardBoardGrid(rows, columns);
		this.wormholePanel = new JPanel(null);
		this.wormholes = new ArrayList<>();

		super.add(mapGrid, MAP_GRID_LAYER);
		super.add(wormholesPanel, MAP_GRID_LAYER);
	}
	
	public void fillMapSquares(List<JComponent> squares) {
		mapGrid.fillGrid(squares);
	}
	
	public void fillPathSquares(List<JComponent> squares) {
		pathGrid.fillGrid(squares);
	}
	
	public void addWormhole(WormholeComponent wormhole) {
		wormholes.add(wormhole);
	}
	
	public void addWormholes(List<WormholeComponent> wormholes) {
		this.wormholes.addAll(wormholes);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		paintWormholes(g);
	}
	
	protected void paintWormholes(Graphics g) {
		wormholes.forEach(w -> {
			JComponent start = mapGrid.getSquare(w.getStartSquareNr());
			JComponent end = mapGrid.getSquare(w.getEndSquareNr());
			
			w.paint(g, start, end);
		});
	}
	
	@Override
	public BoardMapSquares getPath() {
		return pathGrid;
	}

	@Override
	public JComponent getComponent() {
		return this;
	}

}
