package game;

import java.util.ArrayList;

import fields.Field;
import fields.Field_Chance;
import fields.Field_Ownable;
import fields.Field_Start;

public class GameController
{
    /** Player list */
    private ArrayList<game.Player> m_players = new ArrayList<>();

    public GameController()
    {
        addPlayers();
        playGame();
    }

    private void playGame()
    {
        DieCup dieCup = new DieCup();
        ArrayList<fields.Field> fields = new ArrayList<>();
        fields.add(new fields.Field_Start());
        fields.add(new fields.Field_Ownable(1));
        fields.add(new fields.Field_Ownable(1));
        fields.add(new fields.Field_Chance());
        fields.add(new fields.Field_Ownable(1));
        fields.add(new fields.Field_Ownable(1));
        fields.add(new Field_Start());
        fields.add(new fields.Field_Ownable(2));
        fields.add(new fields.Field_Ownable(2));
        fields.add(new fields.Field_Chance());
        fields.add(new fields.Field_Ownable(2));
        fields.add(new fields.Field_Ownable(2));
        fields.add(new fields.Field_Parking());
        fields.add(new fields.Field_Ownable(3));
        fields.add(new fields.Field_Ownable(3));
        fields.add(new fields.Field_Chance());
        fields.add(new fields.Field_Ownable(3));
        fields.add(new fields.Field_Ownable(3));
        fields.add(new fields.Field_Jail());
        fields.add(new fields.Field_Ownable(4));
        fields.add(new fields.Field_Ownable(4));
        fields.add(new Field_Chance());
        fields.add(new fields.Field_Ownable(5));
        fields.add(new fields.Field_Ownable(5));
        boolean looser = false;
        while (!looser)
        {
            for (game.Player player : m_players)
            {
                game.GUIController.getInstance()
                        .getUserButtonPressed(
                                player.getName() + " " + game.Language.getLine("your_turn"),
                                game.Language.getLine("roll_dice"));
                game.GUIController.getInstance().setDie(dieCup.getSum());
                player.movePlayer(dieCup.getSum());
                Field field = fields.get(player.getPosition());
                fields.Field_Ownable nearby = null;
                if (field instanceof fields.Field_Ownable)
                {
                    if (fields.get(player.getPosition() - 1) instanceof fields.Field_Ownable)
                    {
                        nearby = (fields.Field_Ownable) fields.get(player.getPosition() - 1);
                    }
                    else if (fields.get(player.getPosition() + 1) instanceof fields.Field_Ownable)
                    {
                        nearby = (fields.Field_Ownable) fields.get(player.getPosition() + 1);
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

    private void displayWinner()
    {
        game.Player highestScore = null;
        for (game.Player player : m_players)
        {
            if (highestScore == null
                    || player.getAccount().getBal() > highestScore.getAccount().getBal())
            {
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
        String numberOfPlayers[] = new String[4];
        numberOfPlayers[0] = "3";
        numberOfPlayers[1] = "4";
        numberOfPlayers[2] = "5";
        numberOfPlayers[3] = "6";
        int selectedNumberOfPlayers = Integer.parseInt(game.GUIController.getInstance()
                .getUserSelection(game.Language.getLine("select_number_of_players"), numberOfPlayers));
        int startBalance = selectedNumberOfPlayers == 2 ? 20
                : selectedNumberOfPlayers == 3 ? 18 : 16;
        for (int i = 0; i < selectedNumberOfPlayers; i++)
        {
            String name = game.GUIController.getInstance()
                    .getUserString(game.Language.getLine("player") + " " + (i + 1) + " "
                            + game.Language.getLine("enter_name"));
            m_players.add(new game.Player(name, startBalance));
        }
    }
}
