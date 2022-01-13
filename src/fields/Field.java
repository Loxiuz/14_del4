package fields;

import game.*;

public abstract class Field
{
	protected Field()
	{
	}

	protected static Field get(int position) {

	}

	// All field subclasses must have a landedOn method
	public abstract void landedOn(Player player);

	}

