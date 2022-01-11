import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DieCupTest {


    @Test
    public void rollThousand(){

        final int DICE = 2;
        final int DICE_SUMS = 6*DICE;
        final float MAX_ROLLS = 10000;
        DieCup dieCup = new DieCup();

        float[] expected = new float[DICE_SUMS];
        Arrays.fill(expected, MAX_ROLLS/DICE_SUMS);

        float[] actual = new float[DICE_SUMS];

        int rolls = 0;

        while( rolls < MAX_ROLLS ) {

            for (int i = 0; i < DICE_SUMS; i++){

                if(dieCup.getSum() == i + 1){
                    actual[i]++;
                }

            }

            rolls++;
        }

        assertArrayEquals(expected, actual, 100);
    }


}