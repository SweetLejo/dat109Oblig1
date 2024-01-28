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

@FunctionalInterface
public interface BoardMapFactory {

	BoardMap createBoardMap(Board board);
	
}
