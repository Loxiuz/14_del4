import game.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class Language_test {


    @Test
    // Attempts to call a line with getLine
    public void callLine() {
        game.Language.setLanguage("english");
        assertEquals("Draw a Chance card", game.Language.getLine("fC_desc")); // 'fC_desc' refers to the chance card description
    }
    @Test
    // Changes the language
    public void changeLanguage() {
        game.Language.setLanguage("english");
        assertEquals("Draw a Chance card", game.Language.getLine("fC_desc")); // 'fC_desc' refers to the chance card description
        game.Language.setLanguage("dansk");
        assertEquals("Træk et chancekort", game.Language.getLine("fC_desc")); // 'fC_desc' refers to the chance card description
    }
    @Test
    // Checks that getLanguages finds at least 2 languages
    public void findLanguages() {
        assertTrue(game.Language.getLanguages().length >= 2);
    }
}
