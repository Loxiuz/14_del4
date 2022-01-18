package game;

import java.awt.Color;
import java.util.Objects;
import java.util.UUID;

import gui_fields.GUI_Car;
import gui_fields.GUI_Car.Pattern;
import gui_fields.GUI_Car.Type;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;

public class Player {
    private String m_name;
    /**
     * The GUI instance of the player
     */
    private GUI_Player m_guiPlayer;
    private game.Account m_account;
    private int m_position = 0;
    private String m_playerID = UUID.randomUUID().toString();

    /**
     * Initializes a new player
     */
    public Player(String name, int startBalance) {
        m_name = name;
        m_guiPlayer = new GUI_Player(name, startBalance, getRandomCar());
        m_account = new game.Account(m_guiPlayer);
        m_account.setBal(startBalance);
        game.GUIController.getInstance().addPlayer(m_guiPlayer);
    }

    /**
     * Creates a randomized game piece
     */
    private GUI_Car getRandomCar() {
        Type[] types = new Type[4];
        types[0] = Type.CAR;
        types[1] = Type.RACECAR;
        types[2] = Type.TRACTOR;
        types[3] = Type.UFO;
        return new GUI_Car(
                new Color((int) (Math.random() * 249) + 1, (int) (Math.random() * 249) + 1,
                        (int) (Math.random() * 249) + 1),
                Color.white, types[(int) (Math.random() * 4)], Pattern.FILL);
    }

    public game.Account getAccount() {
        return m_account;
    }

    public int movePlayer(int fields) {
        GUI_Field[] guiFields = game.GUIController.getInstance().getFields();
        for (int i = 0; i < fields; i++) {
            guiFields[m_position].setCar(m_guiPlayer, false);
            m_position++;
            if (m_position == guiFields.length) {
                m_position = 0;
                m_account.deposit(4000);
            }
            guiFields[m_position].setCar(m_guiPlayer, true);
            try {
                Thread.sleep(250L);
            } catch (Exception e) {
            }
        }
        return m_position;
    }

    public int getPosition() {
        return m_position;
    }

    public int setPosition(int position) {
        GUI_Field[] guiFields = game.GUIController.getInstance().getFields();
        guiFields[m_position].setCar(m_guiPlayer, false);
        m_position = position;
        guiFields[m_position].setCar(m_guiPlayer, true);
        return m_position;
    }

    public String getName() {
        return m_name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_playerID);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Player other = (Player) obj;
        return Objects.equals(m_playerID, other.m_playerID);
    }

    private int GOJC = 0; // number of get out of jail cards

    public int getGOJC() {
        return GOJC;
    }

    public void setGOJC(int GOJC) {
        this.GOJC = GOJC;
    }

    public boolean isInJail = false;

    int a = 0;

    public boolean getJailed() {
        return isInJail = true;
    }

    public boolean notJailed() {
        return isInJail = false;
    }

    public void setInJail(Player player) {
        while (player.isInJail) {
            player.setPosition(10);
            for (int a = 0; a <= 2; a++) {
                Dice dice1 = new Dice(6);
                Dice dice2 = new Dice(6);
                dice1.rollDice();
                dice2.rollDice();
                int diceSum = dice1.getShowingFace() + dice2.getShowingFace();
                boolean isPair = dice1.getShowingFace() == dice2.getShowingFace();

                if (!isPair) {
                    /* Do nothing */
                }
                if (isPair) {
                    player.notJailed();
                    player.movePlayer(diceSum);
                } else {
                    player.notJailed();
                    player.getAccount().withdraw(1000);
                    dice1.rollDice();
                    dice2.rollDice();
                    player.movePlayer(diceSum);
                }
            }
        }
    }
}