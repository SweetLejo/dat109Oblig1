package org.example.gui.board.factory;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.example.gui.board.BoardMap;
import org.example.gui.board.StandardBoardBuilder;
import org.example.gui.board.piece.CirclePiecePainter;
import org.example.gui.board.piece.PiecePainter;
import org.example.gui.board.wormhole.LineWormholePainter;
import org.example.snakesAndLadders.board.Board;

public class SimpleBoardMapFactory implements BoardMapFactory {

	@Override
	public BoardMap createBoardMap(Board board) {
		StandardBoardBuilder builder = new StandardBoardBuilder();
		
		builder.withMapSquares(squareNr -> {
			JPanel panel = new JPanel(new FlowLayout());
			
			panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			panel.add(new JLabel("" + (squareNr + 1)));
			
			return panel;
		});
		
		board.getSquares().forEach(square -> {
			if(square.hasWormhole()) {
				int start = square.getValue();
				int end = square.getWormhole().getValue();
				
				builder.addWormhole(new LineWormholePainter(start, end));
			}
		});
		
		board.getPlayers().forEach(player -> {
			Color color = player.getPiece().getColor();
			int squareNr = player.getPosition().getValue();
			PiecePainter painter = new CirclePiecePainter(squareNr, color);
			
			builder.addPiece(player.getName(), painter);
		});
		
		return builder.build();
	}
	
}

