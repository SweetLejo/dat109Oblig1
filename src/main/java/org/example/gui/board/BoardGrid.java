package org.example.gui.board;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class BoardGrid extends JPanel {

	private static final long serialVersionUID = 1L;

	private final int rows;
	private final int columns;
	
	protected List<JComponent> squares;
	
	public BoardGrid(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}
	
	public BoardGrid(int rows, int columns, List<JComponent> squares) {
		super(new GridBagLayout());
		this.rows = rows;
		this.columns = columns;
		
		fillGrid(squares);
	}
	
	/**
	 * Fills grid with each row alternating direction.
	 * Bottom row starts at 1 on the left side.
	 * @param squares to fill grid with, mapped by their number
	 */
	public void fillGrid(List<JComponent> squares) {
		if(super.getComponentCount() > 0) {
			super.removeAll();
		}
		
		this.squares = squares;
		
		GridBagConstraints position = new GridBagConstraints();
		
		position.gridy = rows - 1;
		position.gridx = 0;
		
		int index = 0;
		boolean leftToRight = true;
		
		while(position.gridy >= 0) {
			if(leftToRight) {
				index = fillRowLeftToRight(position, index);
			} else {
				index = fillRowRightToLeft(position, index);
			}
			
			leftToRight = !leftToRight;
			position.gridy--;
		}
	}
	
	private int fillRowLeftToRight(GridBagConstraints position, int index) {
		while(position.gridx < columns) {
			add(squares.get(index), position);
			position.gridx++;
			index++;
		}
		
		return index;
	}
	
	private int fillRowRightToLeft(GridBagConstraints position, int index) {
		while(position.gridx < columns) {
			add(squares.get(index), position);
			position.gridx--;
			index++;
		}
		
		return index;
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getColumns() {
		return columns;
	}
	
	public JComponent getSquare(int squareNr) {
		return squares.get(squareNr - 1);
	}
	
}
