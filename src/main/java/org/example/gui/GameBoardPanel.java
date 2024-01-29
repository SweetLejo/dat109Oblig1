package org.example.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.example.gui.board.BoardMap;

public class GameBoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private BoardMap map;
	
	public GameBoardPanel(BoardMap map) {
		setMap(map);
	}
	
	private void setMap(BoardMap map) {
		JComponent mapComponent = map.getComponent();
		
		if(this.map != null) {
			remove(map.getComponent());
		}
		
		add(mapComponent, BorderLayout.CENTER);
		addComponentListener(createResizeAdapter(mapComponent, this));
		
		this.map = map;
	}
	
	private static ComponentAdapter createResizeAdapter(JComponent board, JPanel container) {
		return new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				resizeToSquare(board, container);
			}
		};
	}
	
	private static void resizeToSquare(JComponent board, JPanel container) {
		int width = container.getWidth();
		int height = container.getHeight();
		int size = Math.min(width, height) - 5;
		
		board.setPreferredSize(new Dimension(size, size));
		container.revalidate();
	}
	
	public void movePiece(String id, int targetSquareNr) {
		map.movePiece(id, targetSquareNr);
	}

}
