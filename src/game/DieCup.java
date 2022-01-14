package game;

import java.util.Arrays;

public class DieCup {

        final int MAX_DICE = 2;

        final int[] die = new int[MAX_DICE];

        private int diceSum;

        public void rollDice() {
            for (int i = 0; i < MAX_DICE; i++) {
                die[i] = (int)(Math.random()*6+1);

            }
            diceSum = Arrays.stream(die).sum();
        }

        public int getSum () {
            return diceSum;
        }

        public int getEyes ( int dieNr){
            return die[dieNr-1];
        }
    }
