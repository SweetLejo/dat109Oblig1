package org.example.gui.board.piece;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

public abstract class PiecePainter {

	private static final long serialVersionUID = 1L;
	
	private int currentSquareNr;
	
	public PiecePainter(int currentSquareNr) {
		this.currentSquareNr = currentSquareNr;
	}
	
	public PiecePainter() {
		this(1);
	}
	
	public abstract void drawPiece(Graphics g, Rectangle bounds);
	
	public int getCurrentSquareNr() {
		return currentSquareNr;
	}
	
	public void setCurrentSquareNr(int currentSquareNr) {
		this.currentSquareNr = currentSquareNr;
	}
	
}
