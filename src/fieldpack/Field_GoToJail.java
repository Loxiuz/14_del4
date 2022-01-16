package fieldpack;

import game.*;

		public class Field_GoToJail extends Field {
			Dice m_dice1 = new Dice(6);
			Dice m_dice2 = new Dice(6);

			@Override
			public void landedOn(Player player) {
				GUIController.getInstance().showMessage(player.getName() + " " + Language.getLine("jail"));
				Dice dice1 = m_dice1;
				Dice dice2 = m_dice2;
				player.setPosition(10);
				boolean sameEyes = dice1.getShowingFace() == dice2.getShowingFace();

				for (int a = 0; a < 3; a++) {
					dice1.rollDice();
					dice2.rollDice();
					GUIController.getInstance().setDice(dice1.rollDice(), dice2.rollDice());

					if (!sameEyes) {
						player.setPosition(10);
					}

					if (sameEyes) {
						break;
					}
				}
				if (sameEyes) {
					GUIController.getInstance().showMessage(player.getName() + " " + "free");
				} else {
					player.getAccount().withdraw(1000); // with no GOJC or luck with dice, player bribes the jail staff :)
					//player rolls the dice and moves, as usual.
					GUIController.getInstance().getUserButtonPressed(player.getName() + " " + "free", Language.getLine("roll_dice"));
				}
				GUIController.getInstance().setDice(dice1.rollDice(), dice2.rollDice());
				player.movePlayer(dice1.getShowingFace() + dice2.getShowingFace());
			}
		}