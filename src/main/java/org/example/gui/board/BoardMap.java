package org.example.gui.board;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

public abstract class BoardMap {

	private static final long serialVersionUID = 1L;
	
	public abstract void addWormhole(WormholeComponent wormhole);
	
	public abstract WormholeComponent removeWormhole(WormholeComponent wormhole);
	
}
