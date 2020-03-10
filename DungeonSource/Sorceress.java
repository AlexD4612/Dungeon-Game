import java.util.Scanner;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */



public class Sorceress extends Hero 
{
	private final int MIN_ADD = 25;
	private final int MAX_ADD = 50;


    public Sorceress()
	{
		super("Sorceress", 75, 5, .7, 25, 50, .3);


    }

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " casts a spell of fireball at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}

	@Override
	public void specialAttack(DungeonCharacter opponent)
	{
		int hPoints;

		hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		addHitPoints(hPoints);
		System.out.println(getName() + " added [" + hPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ getHitPoints());
		 System.out.println();
		
	}


	@Override
	protected String getSpecialAttack() {
		return "Increase Hitpoints";
	}
}
