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
		String buyMsg = player.getName() + " " + Language.getLine("want_buy");
		String tButton = Language.getLine("buy_field");
		String fButton = Language.getLine("dont_buy");

		if (nearby.getOwner() == player) // Do nothing
		{
		}
		if (nearby.getOwner() != player && nearby.getOwner() != null) {
			player.getAccount().withdraw(m_rent);
			getOwner().getAccount().deposit(m_rent);
			GUIController.getInstance().showMessage(player.getName() + " " + Language.getLine("pay") + " " + m_rent + " " + "kr." + " " + Language.getLine("to") + " " + getOwner().getName());
		}

		if (nearby.getOwner() != player && nearby.getOwner() != null && nearby.getOwner().getJailed()) { /* Do nothing */ } else if (nearby.getOwner() == null) {
			boolean buy = GUIController.getInstance().getUserLeftButtonPressed(buyMsg, tButton, fButton);

			if (buy) {
				player.getAccount().withdraw(m_price);
				setOwner(player);
			} else {
				/* Do nothing */
			}
		}
	}
}