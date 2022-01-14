package game;

import java.util.ArrayList;

import fields.*;
import org.apache.commons.lang.ArrayUtils;

public class GameController {

    /** Player list */
    private ArrayList<Player> m_players = new ArrayList<>();
    public final Field[] fields = new Field[40];

    public GameController() {
        addPlayers();
        playGame();
    }

    private void playGame() {
        DieCup dice = new DieCup();

        fields[0] = new Field_Start();
        fields[1] = new Field_Ownable(100);
        fields[2] = new Field_Chance();
        fields[3] = new Field_Ownable(100);
        fields[4] = new Field_Tax();
        fields[5] = new Field_Ownable(100);
        fields[6] = new Field_Ownable(100);
        fields[7] = new Field_Chance();
        fields[8] = new Field_Ownable(100);
        fields[9] = new Field_Ownable(100);
        fields[10] = new Field_Jail();
        fields[11] = new Field_Ownable(100);
        fields[12] = new Field_Ownable(100);
        fields[13] = new Field_Ownable(100);
        fields[14] = new Field_Ownable(100);
        fields[15] = new Field_Ownable(100);
        fields[16] = new Field_Ownable(100);
        fields[17] = new Field_Chance();
        fields[18] = new Field_Ownable(100);
        fields[19] = new Field_Ownable(100);
        fields[20] = new Field_Parking();
        fields[21] = new Field_Ownable(100);
        fields[22] = new Field_Chance();
        fields[23] = new Field_Ownable(100);
        fields[24] = new Field_Ownable(100);
        fields[25] = new Field_Ownable(100);
        fields[26] = new Field_Ownable(100);
        fields[27] = new Field_Ownable(100);
        fields[28] = new Field_Ownable(100);
        fields[29] = new Field_Ownable(100);
        fields[30] = new Field_GoToJail();
        fields[31] = new Field_Ownable(100);
        fields[32] = new Field_Ownable(100);
        fields[33] = new Field_Chance();
        fields[34] = new Field_Ownable(100);
        fields[35] = new Field_Ownable(100);
        fields[36] = new Field_Chance();
        fields[37] = new Field_Ownable(100);
        fields[38] = new Field_ExtraTax();
        fields[39] = new Field_Ownable(100);
        boolean looser = false;
        while (!looser)
        {
            for (Player player : m_players)
            {
                GUIController.getInstance()
                        .getUserButtonPressed(
                                player.getName() + " " + Language.getLine("your_turn"),
                                Language.getLine("roll_dice"));
                dice.rollDice();
                GUIController.getInstance().setDice(dice.getEyes(1),dice.getEyes(2));
                player.movePlayer(dice.getSum());

                Field field = fields[ArrayUtils.indexOf(fields, player.getPosition())];
                Field_Ownable nearby = null;
                if (field instanceof Field_Ownable)
                {
                    if (fields[ArrayUtils.indexOf(fields, player.getPosition() - 1)] instanceof Field_Ownable)
                    {
                        nearby = (Field_Ownable) fields[ArrayUtils.indexOf(fields, player.getPosition() - 1)];
                    }
                    else if (fields[ArrayUtils.indexOf(fields, player.getPosition() + 1)] instanceof Field_Ownable)
                    {
                        nearby = (Field_Ownable) fields[ArrayUtils.indexOf(fields, player.getPosition() - 1)];
                    }
                    ((Field_Ownable) field).landedOn(player, nearby);
                }
                else
                {
                    field.landedOn(player);
                }
                if (player.getAccount().getBal() == 0)
                {
                    looser = true;
                    break;
                }
            }
        }
        displayWinner();
    }

    private void displayWinner() {
        game.Player highestScore = null;
        for (game.Player player : m_players) {
            if (highestScore == null
                    || player.getAccount().getBal() > highestScore.getAccount().getBal()) {
                highestScore = player;
            }
        }
        game.GUIController.getInstance()
                .getUserButtonPressed(game.Language.getLine("winner_is") + " " + highestScore.getName(),
                        game.Language.getLine("close_game"));
        game.GUIController.getInstance().close();
    }

    private void addPlayers()
    {
        String[] numberOfPlayers = new String[4];
        numberOfPlayers[0] = "3";
        numberOfPlayers[1] = "4";
        numberOfPlayers[2] = "5";
        numberOfPlayers[3] = "6";
        int selectedNumberOfPlayers = Integer.parseInt(GUIController.getInstance()
                .getUserSelection(Language.getLine("select_number_of_players"), numberOfPlayers));
        int startBalance = selectedNumberOfPlayers == 2 ? 20
                : selectedNumberOfPlayers == 3 ? 18 : 16;
        for (int i = 0; i < selectedNumberOfPlayers; i++)
        {
            String name = GUIController.getInstance()
                    .getUserString(Language.getLine("player") + " " + (i + 1) + " "
                            + Language.getLine("enter_name"));
            m_players.add(new Player(name, startBalance));
        }
    }
}