package org.example.gui.board;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.example.gui.board.wormhole.WormholeComponent;

public class StandardBoardMap extends StandardBoardGrid implements BoardMap {
	
	private List<WormholeComponent> wormholes;
	private StandardBoardGrid path;
	
	public StandardBoardMap(int rows, int columns, List<JComponent> squares) {
		super(rows, columns, squares);
		this.wormholes = new ArrayList<>();
	}
	
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
