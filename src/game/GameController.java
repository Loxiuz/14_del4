package game;

import java.util.ArrayList;

import fields.*;

public class GameController {

    /** Player list */
    private ArrayList<Player> m_players = new ArrayList<>();

    public GameController() {
        addPlayers();
        playGame();
    }

    private void playGame() {
        DieCup dice = new DieCup();
        new GameBoard();
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
                GUIController.getInstance().setDie(dice.getSum());
                player.movePlayer(dice.getSum());
                Field field = fields.get(player.getPosition());
                Field_Ownable nearby = null;
                if (field instanceof Field_Ownable)
                {
                    if (fields.get(player.getPosition() - 1) instanceof Field_Ownable)
                    {
                        nearby = (Field_Ownable) fields.get(player.getPosition() - 1);
                    }
                    else if (fields.get(player.getPosition() + 1) instanceof Field_Ownable)
                    {
                        nearby = (Field_Ownable) fields.get(player.getPosition() + 1);
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
        String numberOfPlayers[] = new String[4];
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