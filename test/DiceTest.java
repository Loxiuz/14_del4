import game.Dice;
import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.Arrays;

public class DiceTest extends TestCase {

    Dice dice = new Dice(6);
    Dice dice1 = new Dice(6);
    Dice dice2 = new Dice(6);

    /** Test af terninger hen over titusind kast,
     *  hvor der bliver optalt antallet af hver af de forskellige sider,
     *  og sammenligner resultatet af hver terning
     *  med det forventet antal (10000/6=1666) ved at benytte arrays **/
    @Test
    public void testRollDice() {

        float[] expected = new float[6];
        Arrays.fill(expected, 1666);

        for (int a = 0; a < 2; a++) {

            int rolls = 0;

            float[] actual = new float[6];
            //Antal kast
            while (rolls < 10000) {

                dice.rollDice();
                int roll = dice.getShowingFace();

                for (int i = 0; i < 6; i++) {
                    //Optælling af de forskellige sider på terningen
                    if (roll == i + 1) {
                        actual[i] += 1;
                    }
                }
                rolls++;
            }
            //Sammenligner resultaterne med forventet array
            //samt en tolerance
            assertArrayEquals(expected, actual, 100);
        }
    }

    /** Test for summen af terningerne, hvor der sørges for,
     *  at resultatet er indenfor de korrekte grænser (1-12) **/
    @Test
     void getSumTest(){
        dice1.rollDice();
        dice2.rollDice();
        int sum = dice1.getShowingFace() + dice2.getShowingFace();
        Assertions.assertTrue(sum > 0 && sum <= 12);
    }
}