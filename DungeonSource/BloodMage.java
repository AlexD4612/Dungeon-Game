
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

		super("BloodMage", 90, 3, .95, 30, 50, .3);
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
		double lifeattack = (this.specialAttack.specialAttack() * .7); 
		int lifesteal = (int) lifeattack;
		if (lifesteal != 0) {
			System.out.println(getName() + " drained a health amount of " + lifesteal
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

