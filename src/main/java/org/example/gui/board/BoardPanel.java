package org.example.gui.board;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

public abstract class BoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public abstract void addPiece(Color color);
	
	public abstract void movePiece(Color color, int targetSquareNr);
	
	public abstract void removePiece(Color color);

	public abstract void addWormhole(int fromSquareNr, int toSquareNr);
	
	public abstract void removeWormhole(int fromSquareNr, int toSquareNr);
	
}
