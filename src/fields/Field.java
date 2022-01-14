package fields;

import game.*;

public abstract class Field
{
	protected Field()
	{
	}

	public Field getField(int position){
		return new GameController().fields[position];
	}

	// All field subclasses must have a landedOn method
	public abstract void landedOn(Player player);

	}

