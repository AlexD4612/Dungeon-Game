import java.util.Scanner;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */




public class BloodMage extends Hero
{

	private Attack specialAttack;
	
    public BloodMage()
	{

		super("BloodMage", 90, 4, .65, 30, 50, .3);
		this.specialAttack = wFactory.getAttack("BloodMage");
		
    }


	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " casts a life draining spell at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}
	
	@Override
	protected Attack getSpecialAttack() {
		return this.specialAttack;
	}


	@Override
	protected String getSpecialAttackName() {
		return "Life Steal";
	}


	@Override
	protected void handleSpecial(DungeonCharacter opponent) {
		double lifeattack = (this.specialAttack.specialAttack() * .5); //special attack damage should just be normal attack FIX BloodMageAttack class!
		int lifesteal = (int) lifeattack;
		if (lifesteal != 0) {
			System.out.println(getName() + " drained drained a health amount of " + lifeattack
					+ " health!");
			opponent.subtractHitPoints(lifesteal);
			addHitPoints(lifesteal);
		}
		else
		{
			System.out.println(getName() + " failed to steal enemy health");
			System.out.println();
		}
		
	}

}

