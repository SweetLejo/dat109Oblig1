/*
package org.example.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.example.gui.board.StandardBoardBuilder;
import org.example.gui.board.StandardBoardMap;
import org.example.gui.board.piece.CirclePiecePainter;
import org.example.gui.board.piece.PiecePainter;
import org.example.gui.board.wormhole.LineWormholePainter;
import org.example.gui.board.wormhole.WormholePainter;
import org.example.snakesAndLadders.board.Board;

public class TestMain {

	public static void main(String[] args) {
		StandardBoardMap map = createSimpleMap();
		Board board = new Board();
		GameController controller = new GameController(map, board);
		
		
		JFrame frame = new JFrame("Test Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 700);
		frame.getContentPane().add(controller.getGamePanel());
		frame.setVisible(true);
		
		controller.getGamePanel().revalidate();
		
		System.out.println(map.getSize());
		System.out.println(map.getSquares().getSize());
		System.out.println(map.getWormholes().getSize());
		System.out.println(map.getPieces().getSize());
		System.out.println(map.getSquares().getSquare(1).getSize());
		
		long start = System.currentTimeMillis();
	
		while(System.currentTimeMillis() < start + 1000);
		
		map.movePiece("2", 6);
	}
	
	private static StandardBoardMap createSimpleMap() {
		return new StandardBoardBuilder()
				.withMapSquares(TestMain::createMapSquare)
				.addWormholes(createWormholes())
				.addPiece("1", createPiece(1, Color.BLUE))
				.addPiece("2", createPiece(1, Color.PINK))
				.addPiece("3", createPiece(3, Color.GREEN))
				.addPiece("4", createPiece(2, Color.RED))
				.build();
	}
	
	private static JComponent createBackground() {
		JPanel panel = new JPanel();
		
		panel.setBackground(Color.RED);
		
		return panel;
	}
	
	private static JComponent createMapSquare(int squareNr) {
		JPanel panel = new JPanel(new FlowLayout());
		
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		panel.add(new JLabel("" + squareNr));
		
		return panel;
	}
	
	private static List<WormholePainter> createWormholes() {
		List<WormholePainter> wormholes = new ArrayList<>();
		Random random = new Random();
		
		for(int i = 0; i < 12; i++) {
			int start = random.nextInt(1, 100);
			int end = random.nextInt(1, 100);
			
			wormholes.add(createWormhole(start, end));
		}
		
		return wormholes;
	}
	
	private static WormholePainter createWormhole(int fromSquareNr, int toSquareNr) {
		return new LineWormholePainter(fromSquareNr, toSquareNr);
	}
	
	private static PiecePainter createPiece(int currentSquareNr, Color color) {
		return new CirclePiecePainter(currentSquareNr, color);
	}
	
}
*/
