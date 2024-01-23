package org.example.gui.board;

import javax.swing.JComponent;

@FunctionalInterface
public interface SquareFactory {

	JComponent create(int squareNr);
	
}
