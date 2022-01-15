package fieldpack;

import game.*;

public class Field_ExtraTax extends Field {

    @Override
    public void landedOn(Player player)
    { player.getAccount().withdraw(2000);
    }
}