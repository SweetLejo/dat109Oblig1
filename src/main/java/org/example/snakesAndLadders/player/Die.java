package org.example.snakesAndLadders.player;

import java.util.Random;

public class Die {

    private Random random = new Random();


    public int roll(){
        return random.nextInt(1, 7);
    }

}
