package org.example.gui.board;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.example.gui.board.piece.PieceComponent;
import org.example.gui.board.wormhole.WormholePainter;

public interface BoardMap {
	
	/**
	 * Adds and places a piece with a unique id on the board. Piece is
	 * initially placed in the PieceComponent's currentSquareNr. Piece can 
	 * later be moved using the given id.
	 * @param id used to move or remove piece.
	 * @param piece component to place on the board.
	 */
	void addPiece(String id, PieceComponent piece);
	
	/**
	 * Moves piece with given id to the target square.
	 * @param id of piece
	 * @param targetSquareNr number refering to the square to move piece to.
	 */
	void movePiece(String id, int targetSquareNr);
	
	/**
	 * Removes pieces with given id from the board.
	 * @param id of piece
	 * @return the removed PieceComponent
	 */
	PieceComponent removePiece(String id);
	
	/**
	 * Adds a new wormhole to the board.
	 * @param wormhole painter to draw wormhole with
	 */
	void addWormhole(WormholePainter wormhole);
	
	/**
	 * Adds all wormholes to the board.
	 * @param wormholes
	 */
	void addWormholes(List<WormholePainter> wormholes);
	
	/**
	 * Returns the Java Swing component representing the board.
	 * @return the board as a JComponent
	 */
	JComponent getComponent();
	
}
