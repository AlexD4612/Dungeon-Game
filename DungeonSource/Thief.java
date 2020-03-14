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

	private Attack specialAttack;
	
    public Thief()
	{
		super("Thief", 75, 6, .8, 20, 40, .5);
		this.specialAttack = wFactory.getAttack("Thief");
    }
    
    public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " back stabs " +
							opponent.getName() + ":");
		super.attack(opponent);
	}

	@Override
	protected Attack getSpecialAttack() {
		return this.specialAttack;
	}

	@Override
	protected String getSpecialAttackName() {
		return "Suprise Attack";
	}

	@Override
	protected void handleSpecial(DungeonCharacter opponent) {
		int surprise = this.specialAttack.specialAttack();
		if (surprise == 1)
		{
			System.out.println("Surprise attack was successful!\n" +
								getName() + " gets an additional turn.");
			setNumTurns(getNumTurns()+1);
			attack(opponent);
		}
		else if (surprise == -1)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else {
		    attack(opponent);
		}
	}
}