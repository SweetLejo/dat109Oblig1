package org.example.gui.board.wormhole;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

import org.example.gui.board.BoardMapSquares;

public abstract class WormholePainter {

	public enum Type {
		LADDER, SNAKE
	}
	
	protected int startSquareNr;
	protected int endSquareNr;
	protected Type type;
	
	public WormholePainter(int startSquareNr, int endSquareNr) {
		this.startSquareNr = startSquareNr;
		this.endSquareNr = endSquareNr;
		this.type = startSquareNr > endSquareNr ? Type.LADDER : Type.SNAKE;
	}
	
	public abstract void drawWormhole(Graphics g, Rectangle from, Rectangle to);
	
	public Type getType() {
		return type;
	}
	
	public int getStartSquareNr() {
		return startSquareNr;
	}	
	
	public int getEndSquareNr() {
		return endSquareNr;
	}
	
}
