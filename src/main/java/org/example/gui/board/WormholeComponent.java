package org.example.gui.board;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JComponent;

public abstract class WormholeComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	
	protected int startSquareNr;
	protected int endSquare;
	
	public WormholeComponent(int startSquareNr, int endSquare) {
		this.startSquareNr = startSquareNr;
		this.endSquare = endSquare;
	}
	
}
