package org.example.gui.board.wormhole;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class LineWormholePainter extends WormholePainter {

	private static final long serialVersionUID = 1L;
	
	public LineWormholePainter(int startSquareNr, int endSquareNr) {
		super(startSquareNr, endSquareNr);
	}

	@Override
	public void drawWormhole(Graphics g, Rectangle from, Rectangle to) {
		Color color = getType() == Type.LADDER ? Color.GREEN : Color.RED;
		int fromX = (int) from.getCenterX();
		int fromY = (int) from.getCenterY();
		int toX = (int) to.getCenterX();
		int toY = (int) to.getCenterY();
		
		g.setColor(color);
		g.drawLine(fromX, fromY, toX, toY);
	}


}
