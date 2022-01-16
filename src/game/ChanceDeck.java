package game;

public class ChanceDeck {

    int randomNr = (int) (Math.random() * 31);
    GameBoard gameBoard = new GameBoard();
    int field = 0;

    public void chanceDeck(Player player, int card) {

        int[] amount = new int[23];

        //Betal:
        amount[0] = 1000;
        amount[1] = 300;
        amount[2] = 200;
        amount[3] = 3000;
        amount[4] = 1000;
        amount[5] = 200;
        amount[6] = 1000;
        amount[7] = 200;
        amount[8] = 2000;
        //Modtag:
        amount[9] = 500;
        amount[10] = 1000;
        amount[11] = 3000;
        amount[12] = 1000;
        amount[13] = 1000;
        amount[14] = 1000;
        amount[15] = 1000;
        amount[16] = 200;
        amount[17] = 40000;
        amount[18] = 200;
        amount[19] = 500;
        amount[20] = 500;

        if (card <= 8) {
            player.getAccount().withdraw(amount[card]);
        }
        else if (card <= 20) {
            player.getAccount().deposit(amount[card]);
        }
        else{
            switch (card) {
                case 21: case21(player);
                    break;
                case 22: case22(player);
                    break;
                case 23: case23(player);
                    break;
                case 24: case24();
                    break;
                case 25: case25();
                    break;
                case 26: case26();
                    break;
                case 27: case27();
                    break;
                case 28: case28();
                    break;
                case 29: case29();
                    break;
                case 30: case30(player);
                    break;
                case 31: case31(player);
                    break;
            }
            if (field > 0){
                player.movePlayer(field - player.getPosition() - 1);
                gameBoard.getField(field).landedOn(player);
            }
        }
    }

    private void case21(Player player){ // Spiller kommer i fængsel.
        player.setPosition(10);
        player.getJailed();
    }
    private void case22(Player player){ // Spiller får et løsladelseskort.
        player.setGOJC(1 + player.getGOJC());
    }
    private void case23(Player player){ // Ryk frem til start
        player.movePlayer(40 - player.getPosition());
    }
    private void case24(){field = 12;} // Ryk frem til Frederiksberg Allé

    private void case25(){field = 16;} // Tag med Mols-Linien

    private void case26(){field = 20;} //Ryk frem til Strandvejen

    private void case27(){field = 25;} // Ryk frem til Grønningen

    private void case28(){field = 33;} // Ryk frem til Vimmelskaftet

    private void case29(){field = 40;} // Tag til Rådhuspladsen

    private void case30(Player player){ // Ryk 3 felter frem
        player.movePlayer(3);
    }
    private void case31(Player player){ // Ryk 3 felter tilbage
        player.movePlayer(-3);
    }

    public void drawRandomCard(Player player){
        chanceDeck(player, randomNr);
    }

    public void cardDesc() {
        GUIController.getInstance().setChanceCard(Language.getLine("card" + randomNr));
        GUIController.getInstance().displayChanceCard();
    }
}

