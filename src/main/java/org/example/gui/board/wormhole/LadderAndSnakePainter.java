package org.example.gui.board.wormhole;

import java.awt.Color;
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
//			drawSnake(g, from, to);
			new LineWormholePainter(startSquareNr, endSquareNr).drawWormhole(g, from, to);
		}
	}
	
	private void drawLadder(Graphics g, Rectangle from, Rectangle to) {
		System.out.println("Painting ladder from " + startSquareNr + " to " + endSquareNr);
		
		g.setColor(new Color(5, 5, 90));
		
		// Global vectors pointing to the center of the start and end squares
		Vector2 startCenter = new Vector2(from.getCenterX(), from.getCenterY()); 
		Vector2 endCenter = new Vector2(to.getCenterX(), to.getCenterY());
		
		// Local vector pointing in the direction from start to end
		Vector2 startToEnd = endCenter.minus(startCenter);

		// Local vector perpendicular (90 degrees relative) to the direction of start to end
		Vector2 perpendicularDirection = startToEnd.perpendicular();
		
		double ladderWidth = from.getWidth() / 3;
		
		// Local vector pointing from the ladders center to its edge the ladders horizontal plane
		Vector2 localHorizontalEdge = perpendicularDirection.scaledToMagnitude(ladderWidth / 2);
		
		// Global vectors pointing to the each corner of the ladder
		Vector2 globalStart1 = startCenter.plus(localHorizontalEdge);
		Vector2 globalStart2 = startCenter.minus(localHorizontalEdge);
		Vector2 globalEnd1 = endCenter.plus(localHorizontalEdge);
		Vector2 globalEnd2 = endCenter.minus(localHorizontalEdge);

		drawLine(g, globalStart1, globalEnd1);
		drawLine(g, globalStart2, globalEnd2);
		
		double ladderHeight = startToEnd.magnitude();
		double stepSpaceDistance = ladderWidth / 2;
		double currentStepHeight = stepSpaceDistance;
		
		while(currentStepHeight < ladderHeight) {
			Vector2 localStepHeight = startToEnd.scaledToMagnitude(currentStepHeight);
			Vector2 globalStepStart = globalStart1.plus(localStepHeight);
			Vector2 globalStepEnd = globalStart2.plus(localStepHeight);
			
			drawLine(g, globalStepStart, globalStepEnd);
			
			currentStepHeight += stepSpaceDistance;
		}
	}
	
	private static void drawLine(Graphics g, Vector2 start, Vector2 end) {
		g.drawLine(
				(int) start.x(), (int) start.y(), 
				(int) end.x(), (int) end.y());
	}
	
	private void drawSnake(Graphics g, Rectangle from, Rectangle to) {
		System.out.println("Painting snake from " + startSquareNr + " to " + endSquareNr);
		
		g.setColor(new Color(120, 10, 10));
		
		// Global vectors pointing to the center of the start and end squares
		Vector2 startCenter = new Vector2(from.getCenterX(), from.getCenterY()); 
		Vector2 endCenter = new Vector2(to.getCenterX(), to.getCenterY());
		
		// Local vector pointing in the direction from start to end
		Vector2 startToEnd = endCenter.minus(startCenter);
		
		// Vectors pointing to the middle between start and end square
		Vector2 localMiddle = startToEnd.scaled(0.5);
		Vector2 globalMiddle = startCenter.minus(localMiddle);
		
		double radius = localMiddle.magnitude();
		double width = radius * 2;
		double height = width;
		
		double startAngle = Math.toDegrees(startToEnd.angle()) + 45;
		double endAngle = Math.toDegrees(startToEnd.scaled(-1).angle()) + 45;
		 System.out.println(globalMiddle + " " + radius);
		drawArc(g, globalMiddle, width, height, endAngle, startAngle);
	}
	
	private static void drawArc(Graphics g, Vector2 middle, double width, double height, double startAngle, double endAngle) {
		g.drawArc(
				(int) middle.x(), (int) middle.y(), 
				(int) width, (int) height, 
				(int) 0, (int) 359);
	}
	
}
