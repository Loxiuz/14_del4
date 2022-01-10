import game.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class Player_test {
    game.Player player1 = new game.Player("tester",20);
    game.Player player2 = new game.Player("tester2",30);
    game.Player player3 = new game.Player("tester",20);
    game.Dice d6 = new game.Dice(6);


    @Test
    // Checking new players are registered properly
    public void newPlayer() {
        assertEquals("tester",player1.getName()); // Player1 is called tester
        assertNotEquals(player1.getID(),player2.getID()); // The players have different IDs
        assertEquals(0,player1.getPosition()); // The players start at Start (field 0)
        assertEquals(20,player1.getAccount().getBal()); // Player1 started with 20$
    }
    @Test
    // Checking setPosition method
    public void setPosition() {
        player1.setPosition(12);
        assertEquals(12,player1.getPosition()); // Player1 has been moved to field 12
        player1.setPosition(3);
        assertEquals(3,player1.getPosition()); // Player1 has been moved to field 3
        assertEquals(20,player1.getAccount().getBal()); // setPosition doesn't pass start
    }
    @Test
    // Checking movePlayer method
    public void movePlayer() {
        player1.movePlayer(9);
        player1.movePlayer(4);
        player2.movePlayer(6);
        assertEquals(13,player1.getPosition()); // Player1 started at 0 and has moved 9+4 steps
        assertEquals(6,player2.getPosition()); // Player2's position is independent of player1's
        player1.movePlayer(50);
        assertEquals(15,player1.getPosition()); //Player1 has moved 2 laps (48 steps) and 2 steps
        assertEquals(24,player1.getAccount().getBal()); // Player1 has passed Start twice and earned 4$
    }
    @Test
    // Checking equals method
    public void equals() {
        assertTrue(player1.equals(player1)); // Player1 is player1
        assertFalse(player1.equals(player2)); // Player1 is not player2
        assertFalse(player1.equals(player3)); // Player1 is not player3, even though most parameters are the same
        assertFalse(player2.equals(d6)); // d6 is not even a player
        assertFalse(player2.equals(null)); // Player2 exists
    }
}
