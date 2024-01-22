package org.example.gui.board;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

public abstract class BoardMapPath extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public abstract List<JComponent> getSquares();
	
	public abstract void setSquares(List<JComponent> squares);
	
	public abstract JComponent getSquare(int squareNr);
	
	
	
	
}
