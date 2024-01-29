package org.example.gui.board.wormhole;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

public class LadderAndSnakePainter extends WormholePainter {

	public LadderAndSnakePainter(int startSquareNr, int endSquareNr) {
		super(startSquareNr, endSquareNr);
	}

	@Override
	public void drawWormhole(Graphics g, Rectangle from, Rectangle to) {
		if(type == Type.LADDER) {
			drawLadder(g, from, to);
		} else {
			drawSnake(g, from, to);
		}
	}
	
	private void drawLadder(Graphics g, Rectangle from, Rectangle to) {
		System.out.println(super.startSquareNr + " to " + super.endSquareNr);
		
		double startX = from.getCenterX();
		double startY =  from.getCenterY();
		double endX = to.getCenterX();
		double endY = to.getCenterY();
		
		g.drawLine((int) startX, (int) startY, (int) endX, (int) endY);
		
		double directionX = endX - startX;
		double directionY = endY - startY;
		double ladderWidth = from.getWidth() / 4;
		
		startX = startX + ladderWidth;
		startY = startY + ladderWidth;
		endX = startX + directionX;
		endY = startY + directionY;
		
		g.drawLine((int) startX, (int) startY, (int) endX, (int) endY);
	}
	
	private void drawSnake(Graphics g, Rectangle from, Rectangle to) {
		
	}
	
	
	
}
