package org.example.gui.board;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class BoardBackground extends JPanel {

	private static final long serialVersionUID = 1L;

	private final JLayeredPane layerPane = new JLayeredPane(); 
	private int nextLayer = 0;
	
	private BoardGrid squares;
	private List<WormholeComponent> wormholes;
	
	public BoardBackground(BoardGrid squares, List<WormholeComponent> wormholes) {
		this.squares = squares;
		this.wormholes = wormholes;
		
		layerPane.add(squares, nextLayer);
		nextLayer++;
		
		while(nextLayer <= wormholes.size()) {
			addWormholeToLayer(wormholes.get(nextLayer));
		}
	}
	
	private void addWormholeToLayer(WormholeComponent wormhole) {
		layerPane.add(wormhole, nextLayer);
		nextLayer++;
	}
	
	public void addWormhole(WormholeComponent wormhole) {
		wormholes.add(wormhole);
		addWormholeToLayer(wormhole);
	}
	
}
