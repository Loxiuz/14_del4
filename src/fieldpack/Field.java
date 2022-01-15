package fieldpack;

import game.*;

public abstract class Field
{
	protected Field()
	{
	}

	// All field subclasses must have a landedOn method
	public abstract void landedOn(Player player);

	}