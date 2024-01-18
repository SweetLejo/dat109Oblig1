package org.example.gui;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

public interface BoardComponentFactory {

	default List<Component> createTileComponents() {
		List<Component> tileComponents = new ArrayList<>();
		
		for(int i = 1; i <= 100; i++) {
			tileComponents.add(createTileComponent(i));
		}
		
		return tileComponents;
	}
	
	Component createTileComponent(int tileNr);
	
	WormholeComponent createLadderComponent(Component startTile, Component endTile);
	
	WormholeComponent createSnakeComponent(Component startTile, Component endTile);
	
	PieceComponent createPieceComponent(Color color);
	
}

