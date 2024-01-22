package org.example.gui.board;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

public abstract class BoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public abstract void addPiece(String id, PieceComponent piece);
	
	public abstract void movePiece(String id, int targetSquareNr);
	
	public abstract PieceComponent removePiece(String id);

	public abstract void addWormhole(WormholeComponent wormhole);
	
	public abstract WormholeComponent removeWormhole(WormholeComponent wormhole);
	
}
