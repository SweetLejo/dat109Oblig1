package org.example.gui.board.wormhole;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class LineWormholeComponent extends WormholeComponent {

	
	public LineWormholeComponent(int startSquareNr, int endSquareNr) {
		super(startSquareNr, endSquareNr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g, Rectangle from, Rectangle to) {
		int fromX = (int) from.getCenterX();
		int fromY = (int) from.getCenterY();
		
		int toX = (int) to.getCenterX();
		int toY = (int) to.getCenterY();
		
		Color color = getType() == Type.LADDER ? Color.GREEN : Color.RED;
		
		g.setColor(color);
		g.drawLine(fromX, fromY, toX, toY);
	}


}
