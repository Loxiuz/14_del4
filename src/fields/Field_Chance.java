package fields;

import game.ChanceDeck;
import game.Player;

public class Field_Chance extends fields.Field {

    ChanceDeck deck = new ChanceDeck();

    /** Draws and enacts a random chance card */
    @Override
    public void landedOn(Player player) {
        deck.drawRandomChance(player);
    }

}

