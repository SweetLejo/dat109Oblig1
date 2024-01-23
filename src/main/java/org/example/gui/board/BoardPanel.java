package org.example.gui.board;

import javax.swing.JPanel;

import org.example.gui.board.piece.PieceComponent;

public abstract class BoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public abstract void addPiece(String id, PieceComponent piece);
	
	public abstract void movePiece(String id, int targetSquareNr);
	
	public abstract PieceComponent removePiece(String id);

}
