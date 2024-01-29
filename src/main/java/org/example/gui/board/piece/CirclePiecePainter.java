package org.example.gui.board.piece;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class CirclePiecePainter extends PiecePainter {

	private Color color;
	
	public CirclePiecePainter(Color color) {
		this.color = color;
	}
	
	public CirclePiecePainter(int currentSquareNr, Color color) {
		super(currentSquareNr);
		this.color = color;
	}

	@Override
	public void drawPiece(Graphics g, Rectangle bounds) {
		int x = (int) bounds.getX() + 2;
		int y = (int) bounds.getY() + 2;
		int width = (int) bounds.getWidth() - 4;
		int height = (int) bounds.getHeight() - 4;
		
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}
	
}
