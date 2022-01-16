package fieldpack;

import game.*;

public class Field_Ownable extends Field {
	protected Player m_fieldOwner = null;
	protected int m_rent;
	protected int m_price;

	// Constructor
	public Field_Ownable(int price, int rent) {
		m_rent = rent;
		m_price = price;
	}

	public void setOwner(Player player) {
		m_fieldOwner = player;
	}

	public Player getOwner() {
		return m_fieldOwner;
	}

	public void setRent(int rent) {
		m_rent = rent;
	}

	public int getRent() {
		return m_rent;
	}

	@Override
	public void landedOn(Player player) {
		landedOn(player, null);
	}

	/**
	 * Decides what happens when a player lands on an amusement depending on who owns it
	 */
	public void landedOn(Player player, Field_Ownable nearby) {
		if (getOwner() == player) // Do nothing
		{
		}
		else // Buy amusement
		{
			player.getAccount().withdraw(m_price);
			if (player.getAccount().getBal() > 0) {
				setOwner(player);
			}

			{
				if (nearby != null && getOwner().equals(nearby.getOwner())) {
					player.getAccount().payTo(getOwner(), m_rent * 2);
				} else {
					player.getAccount().payTo(getOwner(), m_rent);
				}
			}

			{ // getPosition([10]) == jail position
				if (getOwner().getJailed()) {
				} else {
					player.getAccount().payTo(getOwner(), m_rent);
				}
			}
		}
	}
}