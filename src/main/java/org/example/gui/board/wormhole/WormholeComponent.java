package org.example.gui.board.wormhole;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

import org.example.gui.board.BoardMapSquares;

public abstract class WormholeComponent extends JComponent {

	public enum Type {
		LADDER, SNAKE
	}
	
	private static final long serialVersionUID = 1L;
	
	protected int startSquareNr;
	protected int endSquareNr;
	protected Type type;
	
	public WormholeComponent(int startSquareNr, int endSquareNr) {
		this.startSquareNr = startSquareNr;
		this.endSquareNr = endSquareNr;
		this.type = startSquareNr > endSquareNr ? Type.LADDER : Type.SNAKE;
	}
	
	public abstract void paint(Graphics g, Rectangle from, Rectangle to);
	
	public int getStartSquareNr() {
		return startSquareNr;
	}
	
	public int getEndSquareNr() {
		return endSquareNr;
	}
	
	public Type getType() {
		return type;
	}
	
}
