import game.DieCup;
import junit.framework.TestCase;
import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.Arrays;

public class DieCupTest extends TestCase {


    public void testRollDice() {

        DieCup dieCup = new DieCup();

        float[] expected = new float[6];
        Arrays.fill(expected, 1666);

        for (int a = 0; a < 2; a++) {

            int rolls = 0;

            float[] actual = new float[6];
            //Antal kast
            while (rolls < 10000) {

                dieCup.rollDice();
                int roll = dieCup.getEyes(a + 1);

                for (int i = 0; i < 6; i++) {
                    //Optælling af øjnene på terningen
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
}