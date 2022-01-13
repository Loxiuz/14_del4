package game;

import gui_fields.GUI_Player;

public class Account
{
    /** The account balance */
    private int m_balance = 0;
    /** The GUI_Player instance */
    private GUI_Player m_guiPlayer;

    /**
     * Constructor initializes account
     */

    public Account(GUI_Player player)
    {
        m_guiPlayer = player;
    }

    /**
     * Make deposit to account.
     */

    public void deposit(int amount)
    {
        if (m_balance + amount < 0)
        {
            m_balance = 0;
        }
        else
        {
            m_balance += amount;
        }
        m_guiPlayer.setBalance(m_balance);
    }

    /**
     * Make withdrawal from account. Balance cannot be under 0.
     */

    public void withdraw(int amount)
    {
        if (m_balance - amount < 0)
        {
            m_balance = 0;
        }
        else
        {
            m_balance -= amount;
        }
        m_guiPlayer.setBalance(m_balance);
    }

    /**
     * Pay to another player. Balance cannot be 0.
     */

    public void payTo(Player player, int amount) {
        if (m_balance > amount) {
            m_balance -= amount;
        }
        else {
            m_balance = 0;
        }
        player.getAccount().m_balance += amount;
        m_guiPlayer.setBalance(m_balance);
    }

    /**
     * Get balance of account
     */

    public int getBal()
    {
        return m_balance;
    }

    /**
     * Set balance of account
     */

    public void setBal(int balance)
    {
        if (balance < 0)
        {
            m_balance = 0;
        }

        else
        {
            m_balance = balance;
        }
        m_guiPlayer.setBalance(m_balance);
    }
}