package org.example.gui.board;

import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class StandardBoardGrid extends JPanel implements BoardMapSquares {

	private static final long serialVersionUID = 1L;
	
	private final int amountOfRows;
	private final int amountOfColumns;
	private Map<Integer, GridCell> cells = new HashMap<>();

	public StandardBoardGrid(int amountOfRows, int amountOfColumns) {
		super(new GridBagLayout());
		this.amountOfRows = amountOfRows;
		this.amountOfColumns = amountOfColumns;
		this.cells = new HashMap<>();
		
		int squareNr = 1;
		
		for(int i = amountOfRows - 1; i >= 0 ; i--) {
			for(int j = 0; i % 2 != 0 && j < amountOfColumns; j++) {
				cells.put(squareNr++, new GridCell(j, i));
			}
			for(int j = amountOfColumns - 1; i % 2 == 0 && j >= 0; j--) {
				cells.put(squareNr++, new GridCell(j, i));
			}
		}
	}
	
	public StandardBoardGrid(int amountOfRows, int amountOfColumns, 
			List<JComponent> squares) {
		this(amountOfRows, amountOfColumns);
		
		fillGrid(squares);
	}
	
	public void fillGrid(List<JComponent> squares) {
		for(int i = 0; i < squares.size(); i++) {
			setSquare(i + 1, squares.get(i));
		}
	}
 
	public void setSquare(int squareNr, JComponent square) {
		GridCell cell = cells.get(squareNr);

		if(cell.hasSquare()) {
			remove(square);
		}
		
		cell.setSquare(square);
		add(square, cell.getGridBagConstraints());
	}
	
	@Override
	public JComponent getSquare(int squareNr) {
		return cells.get(squareNr).getSquare();
	}

	@Override
	public JComponent getComponent() {
		return this;
	}
	
	public int getGridSize() {
		return amountOfRows * amountOfColumns;
	}

	private static class GridCell {
		
		private final int row;
		private final int column;
		private JComponent square;
		
		public GridCell(int row, int column, JComponent square) {
			this.row = row;
			this.column = column;
			this.square = square;
		}
		
		public GridCell(int row, int column) {
			this(row, column, null);
		}
		
		public JComponent getSquare() {
			return square;
		}
		
		public void setSquare(JComponent square) {
			this.square = square;
		}
		
		public boolean hasSquare() {
			return square != null;
		}
		 
		public GridBagConstraints getGridBagConstraints() {
			GridBagConstraints gbc = new GridBagConstraints();
			
			gbc.fill = GridBagConstraints.BOTH;
			gbc.gridx = row;
			gbc.gridy = column;
			
			return gbc;
		}
		
	}
	
}