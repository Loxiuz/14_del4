package fields;

import game.*;

public class Field_Jail extends Field
{
DieCup dice = new DieCup();
    /** Moves the player straight to the jail  */
    @Override
    public void landedOn(Player player)
    {
        player.setPosition(19);
    }
    // der skal programmeres 3 funktioner:
    // 1. Man skal kunne løslades, hvis man trækker et prov lykken kort.
    // 2. Man skal løslades, hvis man slår to ens øjne.
    // 3. man løslades, hvis man betaler 1000.

    // is this while loop going to start, as soon as the player has been thrown in jail?
    // if so, that's not our idea.
    public void getOutofJail(Player player) {

		while(player.getPosition()==19){
    if(player.getGOJC() > 0){
        // player gets to roll dice, business as usual
        game.Language.getLine("you're free, roll_dice"));
        game.GUIController.getInstance().setDie(dice.getSum());
        player.movePlayer(dice.getSum());
        Field field = fields.Field.get(player.getPosition());
    }
    else{ // player will try to get equal eyes, and move accordingly
        for (int attemps = 0; attemps <= 2; attemps ++){
            boolean sameEyes = (dice.getEyes(1) == dice.getEyes(2));

            dice.rollDice();
            if(sameEyes){
                player.movePlayer(dice.getSum());
            }
            else {
                player.getAccount().withdraw(1000); // with no GOJC or luck with dice, player bribes the jail staff :)
                //player rolls the dice and moves, as usual.
                game.Language.getLine("you're free,roll_dice");
                game.GUIController.getInstance().setDie(dice.getSum());
                player.movePlayer(dice.getSum());
                Field field = Field(player.getPosition());
            }

        }
    }
}
    }
}