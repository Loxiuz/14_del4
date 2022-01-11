public class DieCup {

    private final Die die1 = new Die();
    private final Die die2 = new Die();
    private int diceSum;

    public void diceRoll(){
        diceSum = die1.rollDie()
                + die2.rollDie();
    }

    public int getSum(){
        return diceSum;
    }


}
