package org.example.gui.board;

import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class StandardBoardGrid extends JPanel implements BoardMapSquares {

	private static final long serialVersionUID = 1L;
	
	private final int amountOfRows;
	private final int amountOfColumns;
	
	private List<JComponent> squares;

	public StandardBoardGrid(int amountOfRows, int amountOfColumns) {
		this.amountOfRows = amountOfRows;
		this.amountOfColumns = amountOfColumns;

		for()
		
	}

	public void fillGrid(Function<Integer, JComponent> squareSupplier) {
		List<JComponent> squares = new ArrayList<>();
		
		for(int i = 1; i < getGridSize(); i++) {
			squares.add(squareSupplier.apply(i));
		}
		
		fillGrid(squares);
	}
	
	public void fillGrid(List<JComponent> squares) {	
		if(squares.size() != getGridSize()) {
			throw new IllegalArgumentException("Square amount doesn't match grid size");
		}

		squares.forEach(super::remove);
		this.squares = squares;
		
		GridBagConstraints position = new GridBagConstraints();
		
		// Start at the bottom left of the grid
		position.gridy = amountOfRows - 1;
		position.gridx = 0;
		
		boolean leftToRight = true;
		int squareIndex = 1;
		
		// Iterate upwards over each row
		for(; position.gridy >= 0; position.gridy--) {
			// Fill each column in the row from left to right
			for(; leftToRight && position.gridx < amountOfColumns; position.gridx++) {
				add(squares.get(squareIndex++), position);
			}
			// Or fill from right to left
			for(; !leftToRight && position.gridx >= 0; position.gridx--) {
				add(squares.get(squareIndex++), position);
			}
			
			leftToRight = !leftToRight;
		}
	}

	/**
	 * @return amount of squares needed to fill the grid
	 */
	public int getGridSize() {
		return amountOfRows * amountOfColumns;
	}
	
	@Override
	public List<JComponent> getSquares() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JComponent getSquare(int squareNr) {
		return squares.get(squareNr - 1);
	}

	@Override
	public JComponent getComponent() {
		return this;
	}
	
}