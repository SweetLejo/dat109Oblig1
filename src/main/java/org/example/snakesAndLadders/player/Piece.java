package org.example.snakesAndLadders.player;

import java.awt.Color;
import java.util.Arrays;
import java.util.stream.Collectors;

public enum Piece {
    GREEN, BLUE, RED, YELLOW, PINK, PURPLE;

	public Color getColor() {
		return switch(this) {
		case GREEN -> Color.GREEN;
		case BLUE -> Color.BLUE;
		case RED -> Color.RED;
		case YELLOW -> Color.YELLOW;
		case PINK -> Color.PINK;
		case PURPLE -> Color.MAGENTA;
		};
	} 
	
    public static Piece findColor(String color){
        boolean found = false;

        return Arrays.stream(Piece.values())
                .filter(p -> p.toString().equals(color.toUpperCase()))
                .toList().getFirst();

    }
}
