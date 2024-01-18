package org.example.gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

/**
 * GUI grid used for the board.
 */
public class BoardGrid extends JPanel {

	private static final long serialVersionUID = 1L;

	private final List<Component> tileComponents;
	private final int rows;
	private final int columns;
	
	public BoardGrid(List<Component> tileComponents) {
		this(tileComponents, 10, 10);
	}
	
	public BoardGrid(List<Component> tileComponents, int rows, int columns) {
		super(new GridLayout(rows, columns, 0, 0));
		this.tileComponents = tileComponents;
		this.rows = rows;
		this.columns = columns;

		fillGrid(rows, columns);
	}
	
	/**
	 *  GridLayout places places components based on the order of which they
	 *  are added. The first component starts at the top left, with each 
	 *	proceeding component placed to the right until the row is full.
	 *	This repeats for each row.
	 *	Therefore each tile has to be placed in the correct order, with 
	 *	every other row alternating direction.
	 */
	private void fillGrid(int rows, int columns) {
		boolean rigthToLeft = rows % 2 != 0;

		for(int i = rows; i > 0; i--) {
			for(int j = 1; rigthToLeft && j <= columns; j++) { 
				add(getTileComponent(i * j));
			}
			for(int j = columns; !rigthToLeft && j > 0; j--) { 
				add(getTileComponent(i * j));
			}
			
			rigthToLeft = !rigthToLeft;
		}
	}
	
	public Component getTileComponent(int tileNr) {
		return tileComponents.get(tileNr - 1);
	}
	
	public int getTileCount() {
		return tileComponents.size();
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getColumns() {
		return columns;
	}
	
}
