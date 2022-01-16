import game.ChanceDeck;
import game.Player;
import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ChanceDeckTest extends TestCase {

    Player player = new Player("Navn",30000);
    ChanceDeck deck = new ChanceDeck();

    @Test
    void chanceDeckPayOrReceive() {
        deck.chanceDeck(player, 14);
        int actual = player.getAccount().getBal();

        Assertions.assertEquals(30000 + 1000, actual);
    }

}
