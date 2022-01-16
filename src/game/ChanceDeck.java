package game;

public class ChanceDeck {

    int randomNr = (int) (Math.random() * 24 + 1);
    GameBoard gameBoard = new GameBoard();
    int field = 0;

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
                case 25: case25(player);
                    break;
                case 26: case26();
                    break;
                case 27: case27();
                    break;
                case 28: case28();
                    break;
                case 29: case29();
                    break;
                case 30: case30();
                    break;
                case 31: case31();
                    break;
                case 32: case32(player);
                    break;
                case 33: case33(player);
                    break;
            }
            if (field > 0){
                player.movePlayer(field - player.getPosition() - 1);
                gameBoard.getField(field).landedOn(player);
            }
        }
    }
    private void case23(Player player){ // Player goes to jail.
        player.setPosition(10);
        player.getJailed();
    }
    private void case24(Player player){ // Player recieves GOJC.
        player.setGOJC(1 + player.getGOJC());
    }
    private void case25(Player player){ // Ryk frem til start
        player.movePlayer(40 - player.getPosition());
    }
    private void case26(){field = 12;} // Ryk frem til Frederiksberg Allé

    private void case27(){field = 16;} // Tag med Mols-Linien

    private void case28(){field = 20;} //Ryk frem til Strandvejen

    private void case29(){field = 25;} // Ryk frem til Grønningen

    private void case30(){field = 33;} // Ryk frem til Vimmelskaftet

    private void case31(){field = 40;} // Tag til Rådhuspladsen

    private void case32(Player player){ // Ryk 3 felter frem
        player.movePlayer(3);
    }
    private void case33(Player player){ // Ryk 3 felter tilbage
        player.movePlayer(-3);
    }



    public void drawRandomCard(Player player){
        chanceDeck(player, randomNr-1);
    }

    public void cardDesc() {
        GUIController.getInstance().setChanceCard(Language.getLine("card" + randomNr));
        GUIController.getInstance().displayChanceCard();
    }
}

