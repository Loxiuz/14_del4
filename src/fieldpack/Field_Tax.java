package fieldpack;

import game.*;

public class Field_Tax extends Field {

    @Override
    public void landedOn(Player player)
    { player.getAccount().withdraw(4000);
        GUIController.getInstance().showMessage(player.getName() + " " + Language.getLine("tax"));
    }
}