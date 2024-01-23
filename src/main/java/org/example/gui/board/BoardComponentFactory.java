package org.example.gui.board;

import javax.swing.JComponent;

import org.example.gui.board.wormhole.WormholeComponent;

public interface BoardComponentFactory {

	JComponent createMapSquare(int squareNr);
	
	JComponent createPathSquare(int squareNr);
	
	WormholeComponent createLadder(int fromSquareNr, int toSquareNr);
	
	WormholeComponent createSnake(int fromSquareNr, int toSquareNr);
	
}
