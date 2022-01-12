package game;

public class ChanceDeck {

    public ChanceDeck(int card){

        switch(card){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
        }


    }

    public void drawChance(){
        int randomNr = (int)(Math.random()*36+1);
        ChanceCard(randomNr);
        new ChanceDeck(randomNr);
    }

    private void ChanceCard(int cardNr){
        GUIController.getInstance().setChanceCard(Language.getLine("card"+ cardNr));
        GUIController.getInstance().displayChanceCard();
    }

}
