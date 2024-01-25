package org.example.gui.board.piece;

import java.awt.Graphics;

import javax.swing.JComponent;

public abstract class PieceComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	
	private int currentSquareNr;
	
	public PieceComponent(int currentSquareNr) {
		this.currentSquareNr = currentSquareNr;
	}
	
	public PieceComponent() {
		this(1);
	}
	
	public int getCurrentSquareNr() {
		return currentSquareNr;
	}
	
	public void setCurrentSquareNr(int currentSquareNr) {
		this.currentSquareNr = currentSquareNr;
	}
	
}
