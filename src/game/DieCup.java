public class DieCup {

    private int diceSum = 0;

    public void roll(int NUM_OF_DICE){

        for(int i = 0; i < NUM_OF_DICE; i++){
            diceSum = diceSum + (int)(Math.random()*6+1);
        }

    }

    public int getSum(){return diceSum;}
}
