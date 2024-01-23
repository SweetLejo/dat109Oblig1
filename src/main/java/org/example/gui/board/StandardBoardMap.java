package org.example.gui.board;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.example.gui.board.wormhole.WormholeComponent;

public class StandardBoardMap extends StandardBoardGrid implements BoardMap {
	
	private static final int ROWS = 10;
	private static final int COLUMNS = 10;
	
	private BoardComponentFactory componentFactory;
	
	private List<WormholeComponent> wormholes;
	private StandardBoardGrid path;
	
	private StandardBoardMap(BoardComponentFactory componentFactory) {
		super(ROWS, COLUMNS);
		this.wormholes = new ArrayList<>();
		this.path = new StandardBoardGrid(ROWS, COLUMNS);
		
		fillGrid(this::createGridSquare);
		path.fillGrid(this::createPathSquare);
	}
	
	protected JComponent createGridSquare(int squareNr) {
		JPanel panel = new JPanel();
		
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JLabel label = new JLabel("" + squareNr);
		return null; // TODO
	}
	
	protected JComponent createPathSquare(int squareNr) {
		return new JPanel(new GridLayout(2, 2));
	}
	
	@Override
	public void addWormhole(int fromSquareNr, int toSquareNr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardMapSquares getPath() {
		return path;
	}

}
