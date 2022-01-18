package fieldpack;

import game.*;

		public class Field_GoToJail extends Field {

			@Override
			public void landedOn(Player player) {
				GUIController.getInstance().showMessage(player.getName() + " " + Language.getLine("in_jail"));
			}
		}