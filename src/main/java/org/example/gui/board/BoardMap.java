package org.example.gui.board;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.example.gui.board.wormhole.WormholeComponent;

public abstract class BoardMap extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public abstract void addWormhole(WormholeComponent wormhole);
	
	public abstract WormholeComponent removeWormhole(WormholeComponent wormhole);
	
	public abstract BoardMapSquares getPath();
	
}
