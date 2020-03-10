import java.util.Scanner;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Thief extends Hero
{

    public Thief()
	{
		super("Thief", 75, 6, .8, 20, 40, .5);
    }
    
    public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " back stabs " +
							opponent.getName() + ":");
		super.attack(opponent);
	}
    
	@Override
	public void specialAttack(DungeonCharacter opponent)
	{	
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								getName() + " gets an additional turn.");
			setNumTurns(getNumTurns()+1);
			attack(opponent);
		}
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
		    attack(opponent);
	}

	@Override
	protected String getSpecialAttack() {
		return "Suprise Attack";
	}
}