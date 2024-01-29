package org.example.gui.board.factory;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.example.gui.board.BoardMap;
import org.example.gui.board.StandardBoardBuilder;
import org.example.gui.board.piece.CirclePiecePainter;
import org.example.gui.board.piece.PiecePainter;
import org.example.gui.board.wormhole.LadderAndSnakePainter;
import org.example.gui.board.wormhole.LineWormholePainter;
import org.example.snakesAndLadders.board.Board;

public class BetterBoardMapFactory implements BoardMapFactory {

	@Override
	public BoardMap createBoardMap(Board board) {
		StandardBoardBuilder builder = new StandardBoardBuilder();
		
		builder.withMapSquares(squareNr -> {
			JPanel panel = new JPanel(new FlowLayout());
			
			panel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
			panel.setBackground(squareNr % 2 == 0 ? Color.ORANGE : Color.WHITE);
		
			JLabel nrLabel = new JLabel("" + (squareNr + 1));
			
			nrLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
			
			panel.add(nrLabel);
					
			return panel;
		});
		
		board.getSquares().forEach(square -> {
			if(square.hasWormhole()) {
				int start = square.getValue();
				int end = square.getWormhole().getValue();
				
				builder.addWormhole(new LadderAndSnakePainter(start, end));
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
