package se.jensen.erik.dicegame;

import java.util.Random;

public class DiceRoll {

    Random random = new Random();


    // Metod för att kasta tärningen
    public int roll(){
        return random.nextInt(1,7);
    }
}
