package org.example.snakesAndLadders.player;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Piece {
    GREEN, BLUE, RED, YELLOW, PINK, PURPLE

    public static Piece findColur(String color){
        boolean found = false;

        return Arrays.stream(Piece.values())
                .filter(p -> p.toString().equals(color.toUpperCase()))
                .toList().getFirst();

    }
}
