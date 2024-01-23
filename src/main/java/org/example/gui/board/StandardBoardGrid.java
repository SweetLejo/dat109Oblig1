package org.example.gui.board;

import java.util.List;

import javax.swing.JComponent;

public class StandardBoardGrid extends BoardMapSquares {

	private static final long serialVersionUID = 1L;
	
	private final int rows;
	private final int columns;
	
	private List<JComponent> squares;

	public StandardBoardGrid(int rows, int columns, List<JComponent> squares) {
		this.rows = rows;
		this.columns = columns;
		this.squares = squares;
	}

	@Override
	public List<JComponent> getSquares() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JComponent getSquare(int squareNr) {
		// TODO Auto-generated method stub
		return null;
	}
	
}