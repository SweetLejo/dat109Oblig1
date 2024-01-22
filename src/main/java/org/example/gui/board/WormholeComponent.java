package org.example.gui.board;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JComponent;

public abstract class WormholeComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	
	protected Component startSquare;
	protected Component endSquare;
	
	public WormholeComponent(Component startSquare, Component endSquare) {
		this.startSquare = startSquare;
		this.endSquare = endSquare;
	}

}
