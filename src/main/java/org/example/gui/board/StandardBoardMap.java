package org.example.gui.board;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.example.gui.board.wormhole.WormholeComponent;

public class StandardBoardMap extends BoardMap {

	private static final long serialVersionUID = 1L;
	
	private static final int BACKGROUND_LAYER = 0;
	private static final int SQUARES_LAYER = 1;
	private static final int WORMHOLE_START_LAYER = 2;
	
	private StandardBoardGrid squares;
	private List<WormholeComponent> wormholes;
	
	private StandardBoardGrid path;
	
	@Override
	public void addWormhole(WormholeComponent wormhole) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WormholeComponent removeWormhole(WormholeComponent wormhole) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardMapSquares getPath() {
		return path;
	}

}
