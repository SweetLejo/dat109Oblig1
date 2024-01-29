package org.example.gui.board.wormhole;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

import org.example.math.Vector2;

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
		
		// Global vectors pointing to the center of the start and end squares
		Vector2 startCenter = new Vector2(from.getCenterX(), from.getCenterY()); 
		Vector2 endCenter = new Vector2(to.getCenterX(), from.getCenterY());
		
		// Local vector pointing in the direction from start to end
		Vector2 startToEndDirection = endCenter.minus(startCenter);
		
		// Local vector perpendicular (90 degrees relative) to the direction of start to end
		Vector2 perpendicularDirection = startToEndDirection.perpendicular();
		
		double ladderWidth = from.getWidth() / 3;
		
		// Local vector pointing from the ladders center to its edge the ladders horizontal plane
		Vector2 localHorizontalEdge = perpendicularDirection.scaledToMagnitude(ladderWidth / 2);
		
		// Global vectors pointing to the each corner of the ladder
		Vector2 globalStart1 = startCenter.plus(localHorizontalEdge);
		Vector2 globalStart2 = startCenter.minus(localHorizontalEdge);
		Vector2 globalEnd1 = endCenter.plus(localHorizontalEdge);
		Vector2 globalEnd2 = endCenter.minus(localHorizontalEdge);
		
		drawLadder(g, globalStart1, globalStart2, globalEnd1, globalEnd2);
	}
	
	private static void drawLadder(Graphics g, Vector2 start1, Vector2 start2, Vector2 end1, Vector2 end2) {
		drawLine(g, start1, end1);
		drawLine(g, start2, end2);
	}
	
	private static void drawLine(Graphics g, Vector2 start, Vector2 end) {
		g.drawLine((int) start.x(), (int) start.y(), (int) end.x(), (int) end.y());
	}
	
	private void drawSnake(Graphics g, Rectangle from, Rectangle to) {
		
	}
	
	
	
}
