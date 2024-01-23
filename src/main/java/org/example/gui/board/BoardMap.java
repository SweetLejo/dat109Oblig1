package org.example.gui.board;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.example.gui.board.wormhole.WormholeComponent;

public interface BoardMap {
	
	void addWormhole(WormholeComponent wormhole);
	
	WormholeComponent removeWormhole(WormholeComponent wormhole);
	
	BoardMapSquares getPath();
	
	JComponent getComponent();
	
}
