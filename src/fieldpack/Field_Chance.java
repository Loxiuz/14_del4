package fieldpack;

import game.*;

public class Field_Chance extends Field {

    /** Draws and enacts a random chance card */
    @Override
    public void landedOn(Player player) {
        ChanceDeck card = new ChanceDeck();
        card.drawRandomCard(player);
        card.cardDesc();
    }


    /** Returns a random value between 1 and max */

    /** Enacts a chosen chance card */
    public void chooseCard(Player player, int card) {
        switch (card) {
            case 1:
                GUIController.getInstance().setChanceCard(Language.getLine("card1"));
                GUIController.getInstance().displayChanceCard();
                case1(player);
                break;
            case 2:
                GUIController.getInstance().setChanceCard(Language.getLine("card2"));
                GUIController.getInstance().displayChanceCard();
                case2(player);

                break;
            case 3:
                GUIController.getInstance().setChanceCard(Language.getLine("card3"));
                GUIController.getInstance().displayChanceCard();
                case3(player);
                break;
        }
    }
    private void case1(Player player) {
        player.movePlayer(40-player.getPosition());
        GUIController.getInstance().displayChanceCard();
    }
    private void case2(Player player) {
        player.getAccount().withdraw(2000);
    }
    private void case3(Player player) { // Recieve 2$ from the bank
        player.getAccount().deposit(2000);
    }
    private void case4(Player player) { //Move to the waterfront (field 24)
        player.movePlayer(23-player.getPosition());
        //Execute landedOn(23)
    }
    private void case5(Player player) { // All players pay player 1$
        //All players payTo 1$
        //Requires a getter providing a list of players
    }
    private void case6(Player player) { // Move to the skater park (field 11). If unowned, it's free
        if (player.getPosition() < 10)
            player.movePlayer(10-player.getPosition());
        else
            player.movePlayer(24-(player.getPosition())-10);
        //Execute landedOn(10)
    }
}

