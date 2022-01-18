package fieldpack;

import game.*;

public class Field_Start extends Field {
	@Override
	public void landedOn(Player player) {

		if (player.getPosition() < player.movePlayer(player.getPosition())) {
			player.getAccount().deposit(4000);
			GUIController.getInstance().showMessage(player.getName() + " " + Language.getLine("pass_start"));
		} else if (player.getPosition() < player.movePlayer(player.getPosition()) && player.isInJail) {
			player.getAccount().deposit(0);
		}
	}
}