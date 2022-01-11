package game;

public class ChanceCard {

    public void chanceCard(String type, int cardNr){
        GUIController.getInstance().setChanceCard(Language.getLine("card"+ cardNr));
        GUIController.getInstance().displayChanceCard();
    }

}
