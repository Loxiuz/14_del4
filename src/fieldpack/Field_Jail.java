package fieldpack;

import game.*;

public class Field_Jail extends Field {
    /**
     * Moves the player straight to the jail
     */
    @Override
    public void landedOn(Player player) {
        GUIController.getInstance().showMessage(player.getName() + " " + Language.getLine("visit_jail"));
    }
}