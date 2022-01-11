package game;


import java.util.Arrays;

public class DieCup {

    final int MAX_DICE = 2;

    final Die[] die = new Die[MAX_DICE];
    final int[] dice = new int[MAX_DICE];

    private int diceSum;

    public void rollDice(){
        for(int i = 0; i < MAX_DICE; i++){
          dice[i] = die[i].rollDie();
        }
        diceSum = Arrays.stream(dice).sum();
    }

    public int getSum(){
        return diceSum;
    }

    public int getEyes(int dieNr){
        return dice[dieNr];
    }
}
