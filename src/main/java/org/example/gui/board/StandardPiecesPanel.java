package org.example.gui.board;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.example.gui.board.piece.PiecePainter;

public class StandardPiecesPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private BoardMapSquares squares;
	private Map<String, PiecePainter> pieces;
	
	public StandardPiecesPanel(BoardMapSquares squares) {
		super(null);
		this.squares = squares;
		this.pieces = new HashMap<>();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Iterator<String> ids = pieces.keySet().iterator();
		
		while(ids.hasNext()) {
			paintPiece(g, ids.next());
		}
	}
	
	protected void paintPiece(Graphics g, String id) {
		pieces.get(id).drawPiece(g, computePieceBounds(id));
	}
	
	protected Rectangle computePieceBounds(String id) {
		PiecePainter piece = pieces.get(id);
		int paintedInSquareCount = findPaintedPiecesInSquareCount(id, piece);
		
		Rectangle squareBounds = squares.getSquare(piece.getCurrentSquareNr()).getBounds();
		int x = (int) squareBounds.getX();
		int y = (int) squareBounds.getY();
		int width = (int) (squareBounds.getWidth() / 2);
		int height = (int) (squareBounds.getHeight() / 2);
		
		if(paintedInSquareCount == 1 || paintedInSquareCount == 3) {
			x += width;
		}
		if(paintedInSquareCount == 2 || paintedInSquareCount == 3) {
			y += height;
		}
		
		return new Rectangle(x, y, width, height);
	}
	
	private int findPaintedPiecesInSquareCount(String id, PiecePainter piece) {
		Iterator<String> allIds = pieces.keySet().iterator();
		String currentId = allIds.next();
		int count = 0;
		
		while(currentId != id && allIds.hasNext()) {
			if(pieces.get(currentId).getCurrentSquareNr() == piece.getCurrentSquareNr()) {
				count++;
			}
			
			currentId = allIds.next();
		}
		
		return count;
	}
	
	public void addPiece(String id, PiecePainter piece) {
		pieces.put(id, piece);
		repaint();
	}

	public void movePiece(String id, int targetSquareNr) {
		pieces.get(id).setCurrentSquareNr(targetSquareNr);
		repaint();
	}

	public PiecePainter removePiece(String id) {
		PiecePainter piece = pieces.get(id);
		
		pieces.remove(id);
		
		return piece;
	}
	
	public BoardMapSquares getSquares() {
		return squares;
	}
	
	public void setSquares(BoardMapSquares squares) {
		this.squares = squares;
	}
	
}
