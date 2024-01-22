package org.example.gui.board;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JComponent;

public abstract class PieceComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	
	@Override
	public abstract void paint(Graphics g);
	
}
