package org.example.gui;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class TileGrid {

	private Map<Integer, TileComponent> tileComponents;
	
	public TileGrid() {
		this.tileComponents = new HashMap<>();
		
		tiles.forEach(null);
	}
	
	public TileComponent getTileComponent(int tileNr) {
		return tileComponents.get(tileNr);
	}
	
}
