package game;

public class ChanceDeck {

    public void drawRandomChance(Player player) {
        chanceDeck(player, (int) (Math.random() * 23));
    }

    private void ChanceCardDesc(int cardNr) {
        GUIController.getInstance().setChanceCard(Language.getLine("card" + cardNr));
        GUIController.getInstance().displayChanceCard();
    }

    public void chanceDeck(Player player, int card) {

        ChanceCardDesc(card);

        int[] amount = new int[23];
        //Betal:
        amount[2] = 1000;
        amount[3] = 300;
        amount[4] = 200;
        amount[5] = 3000;
        amount[6] = 1000;
        amount[7] = 200;
        amount[8] = 1000;
        amount[9] = 200;
        amount[10] = 2000;
        //Modtag:
        amount[11] = 500;
        amount[12] = 1000;
        amount[13] = 3000;
        amount[14] = 1000;
        amount[15] = 1000;
        amount[16] = 1000;
        amount[17] = 1000;
        amount[18] = 200;
        amount[19] = 40000;
        amount[20] = 200;
        amount[21] = 500;
        amount[22] = 500;

        if (card <= 10) {
            player.getAccount().withdraw(amount[card - 1]);
        } else {
            player.getAccount().deposit(amount[card - 1]);
        }

        /*
        switch (card) {

        }

    private void case4(Player player) {
        player.movePlayer(19 - player.getPosition());
        //player goes to jail.

    }

    private void case5(Player player) {
        player.setGOJC(1 + player.getGOJC()); //player recieves GOJC.
    }

         */
    }
}