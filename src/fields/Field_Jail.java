package fields;

import game.Player;

public class Field_Jail extends fields.Field
{
	/** Moves the player straight to the jail and takes 1$ from them */
	@Override
	public void landedOn(Player player)
	{
		player.setPosition(6);
		player.getAccount().withdraw(1);
	}
}
