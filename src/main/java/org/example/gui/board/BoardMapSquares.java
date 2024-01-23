package org.example.gui.board;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

public abstract class BoardMapSquares extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public abstract List<JComponent> getSquares();
	
	public abstract JComponent getSquare(int squareNr);
	
	
}
