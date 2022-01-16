import game.Account;
import game.Player;
import gui_fields.GUI_Player;
import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AccountTest extends TestCase {

    Player player = new Player("", 10000);
    Account acc = new Account(new GUI_Player(""));


    @Test
    void deposit() {
        acc.setBal(10000);
        acc.deposit(4000);

        int actual = acc.getBal();
        int expected = 14000;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void withdraw() {
        acc.setBal(10000);
        acc.withdraw(8000);

        int expected = 2000;
        int actual = acc.getBal();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void payTo() {
        acc.payTo(player, 6000);

        int expected = 16000;
        int actual = player.getAccount().getBal();

        Assertions.assertEquals(expected,actual);
    }
}