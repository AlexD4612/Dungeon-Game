

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Gargoyle extends Monster
{
	public Gargoyle()
	{
		super("Cheogh the Gargoyle", 170, 3, .7, .2, 35, 60, 10, 20);


    }

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " swipes his stone claws towards " +
							opponent.getName() + ":");
		super.attack(opponent);

	}
	
}
