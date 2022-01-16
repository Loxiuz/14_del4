package game;

public class ChanceDeck {

    int randomNr = (int) (Math.random() * 24 + 1);

    public void chanceDeck(Player player, int card) {

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
            player.getAccount().withdraw(amount[card]);
        }
        else if (card < 23) {
            player.getAccount().deposit(amount[card]);
        }
        else{
            switch (card) {
                case 23: case23(player);
                    break;
                case 24: case24(player);
                    break;
            }
        }
    }

    private void case24(Player player) {
        player.setGOJC(1 + player.getGOJC()); //player recieves GOJC.
    }

    private void case23(Player player) {
        player.movePlayer(19 - player.getPosition());
        //player goes to jail.
    }

    public void drawRandomCard(Player player) {
        chanceDeck(player, randomNr-1);
    }

    public void cardDesc() {
        GUIController.getInstance().setChanceCard(Language.getLine("card" + randomNr));
        GUIController.getInstance().displayChanceCard();
    }
}

