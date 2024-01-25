package org.example.gui.board;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.example.gui.board.wormhole.WormholeComponent;

public interface BoardMap {
	
	BoardMapSquares getPath();
	
	JComponent getComponent();
	
}
