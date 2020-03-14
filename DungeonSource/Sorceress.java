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
	private Attack specialAttack;

    public Sorceress()
	{
		super("Sorceress", 75, 5, .7, 25, 50, .3);
		this.specialAttack = wFactory.getAttack("Sorceress");

    }

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " casts a spell of fireball at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}
	
	@Override
	protected void handleSpecial(DungeonCharacter opponent) {
		int hPoints = specialAttack.specialAttack();
		addHitPoints(hPoints);
		System.out.println(getName() + " added [" + hPoints + "] points.\n"
				+ "Total hit points remaining are: "
				+ getHitPoints());
		System.out.println();
	}
	
	@Override
	protected String getSpecialAttackName() {
		return "Increase Hitpoints";
	}

	@Override
	protected Attack getSpecialAttack() {
		return specialAttack;
	}
	
}
