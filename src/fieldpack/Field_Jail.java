package fieldpack;

import game.*;
import org.apache.commons.lang.ArrayUtils;

public class Field_Jail extends Field
{
    /** Moves the player straight to the jail  */
    @Override
    public void landedOn(Player player)
    {
        player.setPosition(10);
    }
    // Der skal programmeres 3 funktioner:
    // 1. Man skal kunne løslades, hvis man trækker et prov lykken kort.
    // 2. Man skal løslades, hvis man slår to ens øjne.
    // 3. man løslades, hvis man betaler 1000.

    // is this while loop going to start, as soon as the player has been thrown in jail?
    // if so, that's not our idea.
    public void getOutofJail(Player player) {
        Dice dice1 = new Dice(6);
        Dice dice2 = new Dice(6);

		while(player.getPosition()==19){
    if(player.getGOJC() > 0){
        // player gets to roll dice, business as usual
        game.Language.getLine("you're free, roll_dice");
        dice1.rollDice();
        dice2.rollDice();
        GUIController.getInstance().setDice(dice1.rollDice(), dice2.rollDice());
        player.movePlayer(dice1.getShowingFace()+ dice2.getShowingFace());
    }
    else{ // player will try to get equal eyes, and move accordingly
        for (int attempts = 0; attempts <= 2; attempts++){
            boolean sameEyes = (dice1.getShowingFace() == dice2.getShowingFace());

            dice1.rollDice();
            dice2.rollDice();
            if(sameEyes){
                player.movePlayer(dice1.getShowingFace()+ dice2.getShowingFace());
            }
            else {
                player.getAccount().withdraw(1000); // with no GOJC or luck with dice, player bribes the jail staff :)
                //player rolls the dice and moves, as usual.
                game.Language.getLine("you're free,roll_dice");
                GUIController.getInstance().setDice(dice1.rollDice(), dice2.rollDice());
                player.movePlayer(dice1.getShowingFace()+ dice2.getShowingFace());
            }

        }
    }
}
    }
}