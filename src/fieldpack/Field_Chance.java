package fieldpack;

import game.*;

public class Field_Chance extends Field {

    /** Draws and enacts a random chance card */
    @Override
    public void landedOn(Player player) {
        ChanceDeck deck = new ChanceDeck();
        deck.drawRandomCard(player);
        deck.cardDesc();
    }
}

