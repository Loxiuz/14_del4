package fieldpack;

import game.*;

public class Field_Parking extends Field
{
    @Override
    public void landedOn(Player player)
    { // Do nothing
        GUIController.getInstance().showMessage(player.getName() + " " + Language.getLine("fPark_desc"));
    }
}
