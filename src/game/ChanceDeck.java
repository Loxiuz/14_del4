package game;

public class ChanceDeck {

    public ChanceDeck(){

        int randomNr = (int)(Math.random()*36+1);

        ChanceCard(randomNr);
        switch(randomNr){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:

        }


    }

    private void ChanceCard(int cardNr){
        GUIController.getInstance().setChanceCard(Language.getLine("card"+ cardNr));
        GUIController.getInstance().displayChanceCard();
    }

}
