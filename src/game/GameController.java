package game;

import java.util.ArrayList;

import fieldpack.*;
import gui_main.GUI;
import org.apache.commons.lang.ArrayUtils;

import static javax.swing.UIManager.get;

public class GameController {

    /**
     * Player list
     */
    private Player[] playerList;

    public GameController() {
        addPlayers();
        playGame();
    }

    private void addPlayers() {
        String numberOfPlayers[] = new String[4];
        numberOfPlayers[0] = "3";
        numberOfPlayers[1] = "4";
        numberOfPlayers[2] = "5";
        numberOfPlayers[3] = "6";
        int selectedNumberOfPlayers = Integer.parseInt(GUIController.getInstance()
                .getUserSelection(Language.getLine("select_number_of_players"), numberOfPlayers));
        int startBalance = 30000;
        playerList = new Player[selectedNumberOfPlayers];
        for (int i = 0; i < playerList.length; i++) {
            String name = GUIController.getInstance()
                    .getUserString(Language.getLine("player") + " " + (i + 1) + " "
                            + Language.getLine("enter_name"));
            playerList[i] = new Player(name, startBalance);
        }
    }

    private void playGame() {
        Dice dice1 = new Dice(6);
        Dice dice2 = new Dice(6);
        String button;
        GameBoard board = new GameBoard();
        boolean looser = false;
        while (!looser) {
            for (Player player : playerList) {
                GUIController.getInstance()
                        .getUserButtonPressed(
                                player.getName() + " " + Language.getLine("your_turn"),
                                Language.getLine("roll_dice"));
                do {
                    dice1.rollDice();
                    dice2.rollDice();
                    GUIController.getInstance().setDice(dice1.rollDice(), dice2.rollDice());
                    player.movePlayer(dice1.getShowingFace()+dice2.getShowingFace());
                    Field field = board.getField(player.getPosition());
                    Field_Ownable nearby = null;

                        if (field instanceof Field_Ownable) {
                            if (board.getField(player.getPosition()) instanceof Field_Ownable) {

                                nearby = (Field_Ownable) board.getField(player.getPosition());
                                ((Field_Ownable) field).landedOn(player, nearby);
                            }
                        }

                        if (field instanceof Field_GoToJail) {
                            if (board.getField(player.getPosition()) instanceof Field_GoToJail) {
                                ((Field_GoToJail) field).landedOn(player);
                            }
                        }

                        if (field instanceof Field_Chance) {
                            if (board.getField(player.getPosition()) instanceof Field_Chance) {
                                ((Field_Chance) field).landedOn(player);
                            }
                        }

                        if (field instanceof Field_ExtraTax) {
                            if (board.getField(player.getPosition()) instanceof Field_ExtraTax) {
                                ((Field_ExtraTax) field).landedOn(player);
                            }
                        }
                        if (field instanceof Field_Jail) {
                            if (board.getField(player.getPosition()) instanceof Field_Jail) {
                                ((Field_Jail) field).landedOn(player);
                            }
                        }

                        if (field instanceof Field_Parking) {
                            if (board.getField(player.getPosition()) instanceof Field_Parking) {
                                ((Field_Parking) field).landedOn(player);
                            }
                        }
                        if (field instanceof Field_Start) {
                            if (board.getField(player.getPosition()) instanceof Field_Start) {
                                ((Field_Start) field).landedOn(player);
                            }
                        }
                        if (field instanceof Field_Tax) {
                            if (board.getField(player.getPosition()) instanceof Field_Tax) {
                                ((Field_Tax) field).landedOn(player);
                            }
                        }
                        if (player.getAccount().getBal() == 0) {
                            looser = true;
                            break;
                        }
                    }
                while (dice1.getShowingFace() == dice2.getShowingFace());
                }
            }
        displayWinner();
    }

    private void displayWinner() {
        game.Player highestScore = null;
        for (game.Player player : playerList) {
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
}

