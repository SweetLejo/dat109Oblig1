package org.example.gui;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * This class is the graphics component for the board.
 * It is a layered component, meaning that tiles, wormholes and pieces are 
 * are put on top of each other in layers.
 */
public class BoardPane extends JLayeredPane {

	private static final long serialVersionUID = 1L;
	
	private JPanel tileLayer = new JPanel(new GridLayout(10, 10, 0, 0));
	private JPanel wormholeLayer = new JPanel();
	private JPanel piecesLayer = new JPanel();
	
	private Map<Integer, Component> tiles;
	private List<Component> ladders;
	private List<Component> snakes;
	private List<Component> pieces;
	
	public BoardPane(BoardComponentFactory componentFactory) {
		JPanel tilePanel = new JPanel();
		
		// Add components to their respective layers
		super.add(tiles, 0);
	}
	
	private 
	

	
	
}
