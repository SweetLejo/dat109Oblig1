package org.example.gui.board;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

public interface SquareFactory {
	
	JComponent create(int squareNr);
	
}