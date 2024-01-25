package org.example.gui.board.piece;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class CirclePieceComponent extends PieceComponent {

	private Color color;
	
	public CirclePieceComponent(Color color) {
		this.color = color;
	}
	
	public CirclePieceComponent(int currentSquareNr, Color color) {
		super(currentSquareNr);
		this.color = color;
	}

	@Override
	public void paint(Graphics g) {
		Rectangle bounds = g.getClipBounds();
		int x = (int) bounds.getX();
		int y = (int) bounds.getY();
		int width = (int) bounds.getWidth();
		int height = (int) bounds.getHeight();
		
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}
	
}
