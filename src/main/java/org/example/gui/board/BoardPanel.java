package org.example.gui.board;

import javax.swing.JPanel;

import org.example.gui.board.piece.PieceComponent;

public abstract class BoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Adds a piece with a unique id to the board.
	 * Piece is initally placed in the first square and can be moved with
	 * the method movePiece(String, int).
	 * @param id
	 * @param piece
	 */
	public abstract void addPiece(String id, PieceComponent piece);
	
	/**
	 * Moves piece with given id from its current square to target square.
	 * @param piece to move
	 * @param targetSquareNr is the number of the square we want to move to
	 */
	public abstract void movePiece(String id, int targetSquareNr);
	
	/**
	 * Removes piece with given id from the board.
	 * @param id of the piece to move
 	 * @return the removed piece
	 */
	public abstract PieceComponent removePiece(String id);

}
