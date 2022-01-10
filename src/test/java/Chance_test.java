import fields.Field_Chance;
import fields.Field_Ownable;
import game.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class Chance_test {
    Field_Chance chance = new Field_Chance();
    Player p1 = new Player("tester", 20);
    Field_Ownable empty = new Field_Ownable(0);

    @Test
    // Testing the random draw function
    public void draw() {
        boolean one = false, two = false, three = false;
        for (int i = 0; i < 100; i++) {
            int draw = chance.draw(3);
            assertTrue(draw >= 1 && draw <= 3); // The draw should be between 1 and 3
            if (draw == 1) { one = true; }
            if (draw == 2) { two = true; }
            if (draw == 3) { three = true; }
        }
        assertTrue(one && two && three); // All numbers from 1 to 3 are practically guaranteed to show at least once
    }
    @Test
    // The first card: "Move to start"
    public void card1() {
        p1.setPosition(21);
        chance.chooseCard(p1,1);
        assertEquals(0,p1.getPosition()); // Player was moved to Start (field 0)
        assertEquals(22,p1.getAccount().getBal()); // Player reached Start and earned 2$
    }
    @Test
    // The second card: "Pay the bank 2$"
    public void card2() {
        chance.chooseCard(p1,2);
        assertEquals(0,p1.getPosition()); // Player didn't move
        assertEquals(18,p1.getAccount().getBal()); // Player lost 2$
    }
    @Test
    // The second card: "Receive 2$ from the bank"
    public void card3() {
        chance.chooseCard(p1, 3);
        assertEquals(0, p1.getPosition()); // Player didn't move
        assertEquals(22, p1.getAccount().getBal()); // Player earned 2$
    }
}
