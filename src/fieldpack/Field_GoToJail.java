package fieldpack;

import game.*;

public class Field_GoToJail extends Field
{
	/** Moves the player straight to the jail and takes 1$ from them */
	@Override
	public void landedOn(Player player)
	{
		player.setPosition(10);
		player.getJailed();
		GUIController.getInstance().showMessage(player.getName() + " " + Language.getLine("jail"));
	}
}
