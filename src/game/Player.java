package game;

import java.awt.Color;
import java.util.Objects;
import java.util.UUID;

import gui_fields.GUI_Car;
import gui_fields.GUI_Car.Pattern;
import gui_fields.GUI_Car.Type;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;

public class Player
{
    private final String m_name;
    /** The GUI instance of the player */
    private final GUI_Player m_guiPlayer;
    private final game.Account m_account;
    private int m_posistion = 0;
    private final String m_playerID = UUID.randomUUID().toString();
    private Color m_color;

    /** Initializes a new player */
    public Player(String name, int startBalance)
    {
        m_name = name;
        m_guiPlayer = new GUI_Player(name, startBalance, getRandomCar());
        m_account = new game.Account(m_guiPlayer);
        m_account.setBal(startBalance);
        game.GUIController.getInstance().addPlayer(m_guiPlayer);
    }

    /** Creates a randomized game piece */
    private GUI_Car getRandomCar()
    {
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

    public game.Account getAccount()
    {
        return m_account;
    }

    public GUI_Player getGUIplayer()
    {
        return m_guiPlayer;
    }

    public void movePlayer(int fields)
    {
        GUI_Field[] guiFields = game.GUIController.getInstance().getFields();
        for (int i = 0; i < fields; i++)
        {
            guiFields[m_posistion].setCar(m_guiPlayer, false);
            m_posistion++;
            if (m_posistion == guiFields.length)
            {
                m_posistion = 0;
                m_account.deposit(2);
            }
            guiFields[m_posistion].setCar(m_guiPlayer, true);
            try
            {
                Thread.sleep(250L);
            }
            catch (Exception e)
            {
            }
        }
    }

    public int getPosition()
    {
        return m_posistion;
    }

    public void setPosition(int position)
    {
        GUI_Field[] guiFields = game.GUIController.getInstance().getFields();
        guiFields[m_posistion].setCar(m_guiPlayer, false);
        m_posistion = position;
        guiFields[m_posistion].setCar(m_guiPlayer, true);
    }

    public String getID()
    {
        return m_playerID;
    }

    public String getName()
    {
        return m_name;
    }

    public Color getColor()
    {
        return m_color;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(m_playerID);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        Player other = (Player) obj;
        return Objects.equals(m_playerID, other.m_playerID);
    }
}
