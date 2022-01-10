import game.Dice;
import org.junit.Test;

import static org.junit.Assert.*;


public class Dice_test {
    Dice d6 = new Dice(6);

    @Test
    // Roll a 6 sided dice 100 times, ensure all rolls are within 1-6
    public void rollDie() {
        for (int i = 0; i < 100; i++) {
            int eyes = d6.rollDice();
            assertTrue(eyes >= 1 && eyes <= 6); // The roll should show between 1 and 6 eyes
        }
    }
    @Test
    // Ensure all rolls between 1 and 6 eyes are possible
    public void eyes() {
        boolean one = false, two = false, three = false, four = false, five = false, six = false;
        for (int i = 0; i < 100; i++) {
            int eyes = d6.rollDice();
            if (eyes == 1) { one = true; }
            if (eyes == 2) { two = true; }
            if (eyes == 3) { three = true; }
            if (eyes == 4) { four = true; }
            if (eyes == 5) { five = true; }
            if (eyes == 6) { six = true; }
        }
        assertTrue(one && two && three && four && five && six); // All 6 options are almost guaranteed to be rolled at least once
    }
    @Test
    // Test getShowingFace method
    public void getFace() {
        int eyes = d6.rollDice();
        assertEquals(eyes,d6.getShowingFace()); // getShowingFace should show the latest roll
    }
}
