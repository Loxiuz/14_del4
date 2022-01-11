package game;

public class ChanceCard {

    public void makeChanceCard(int cardNr){
        GUIController.getInstance().setChanceCard(Language.getLine("card"+ cardNr));
        GUIController.getInstance().displayChanceCard();
    }

}
