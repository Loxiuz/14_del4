package game;

import fields.*;
import gui_fields.GUI_Player;

public class Account {

    private int balance = 0;
    private GUI_Player m_guiPlayer;

//Constructor

    public Account(GUI_Player player)
    {
        m_guiPlayer = player;
    }

// acount's deposit

    public void deposit(int amount)
    {
        if (balance + amount < 0)
        {
            balance = 0;
        }
        else
        {
            balance += amount;  // balance= balance+amount
        }
        m_guiPlayer.setBalance(balance);
    }

    // account's withdraw, when balance can not be 0
    public void withdraw(int amount)
    {
        if (balance - amount < 0)
        {
            balance = 0;
        }
        else
        {
            balance -= amount; // balance= balance - amount
        }
        m_guiPlayer.setBalance(balance);
    }

//  betales til anden spiller

    public void payTo(Player player, int amount)
    {
        if (balance > amount) {
            balance -= amount;
        }
        else {
            balance = 0;
        }
        player.getAccount().balance += amount;
        m_guiPlayer.setBalance(balance);
    }

    // get balance of account
    public int getBal()
    {
        return balance;
    }

    // set balance of account
    public void setBal(int balance)
    {
        if (balance < 0)
        {
            balance = 0;
        }

        else
        {
            balance = balance;
        }
        m_guiPlayer.setBalance(balance);
    }

    public boolean hasFeildGroup(Field field)
    {
        return false;
    }

    public void builtHouse (Field field)
    {

    }

    public boolean hasFeildGroupHouse (Field field)
    {
        return false;
    }

    public void builtHotel(Field feild)
    {
    }
}