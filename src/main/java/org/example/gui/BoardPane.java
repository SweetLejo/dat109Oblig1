package org.example.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class BoardPane extends JLayeredPane {

	private static final long serialVersionUID = 1L;
	
	private final BoardComponentFactory componentFactory;
	
	private BoardGrid tileLayer;
	private JPanel wormholeLayer;
	private JPanel piecesLayer;
	private Map<Color, Component> pieces = new HashMap<>();
	
	public BoardPane(BoardComponentFactory componentFactory) {
		this.componentFactory = componentFactory;
		this.tileLayer = new BoardGrid(componentFactory.createTileComponents());
		this.wormholeLayer = new JPanel();
		this.piecesLayer = new JPanel();
	}
	
	public void addLadder(int fromTileNr, int toTileNr) {
		Component startTile = tileLayer.getTileComponent(fromTileNr);
		Component endTile = tileLayer.getTileComponent(toTileNr);

		wormholeLayer.add(componentFactory.createLadderComponent(startTile, endTile));
		wormholeLayer.
	}
	
	public void addSnake(int fromTileNr, int toTileNr) {
		Component startTile = tileLayer.getTileComponent(fromTileNr);
		Component endTile = tileLayer.getTileComponent(toTileNr);
	}
	
	public void addPiece(Color color) {
		PieceComponent piece = componentFactory.createPieceComponent(color);
		
		piecesLayer.
		pieces.put(color, piece);
	}
	
	public void movePiece(Color color, int toTile) {
		Component piece = pieces.get(color);
	}

}
