import java.util.Scanner;

/**
 * Title: Dungeon.java
 *
 * Description: Driver file for Heroes and Monsters project
 *
 * Copyright:    Copyright (c) 2001
 * Company: Code Dogs Inc.
 * I.M. Knurdy
 *
 * History:
 *  11/4/2001: Wrote program
 *    --created DungeonCharacter class
 *    --created Hero class
 *    --created Monster class
 *    --had Hero battle Monster
 *    --fixed attack quirks (dead monster can no longer attack)
 *    --made Hero and Monster abstract
 *    --created Warrior
 *    --created Ogre
 *    --made Warrior and Ogre battle
 *    --added battleChoices to Hero
 *    --added special skill to Warrior
 *    --made Warrior and Ogre battle
 *    --created Sorceress
 *    --created Thief
 *    --created Skeleton
 *    --created Gremlin
 *    --added game play features to Dungeon.java (this file)
 *  11/27/2001: Finished documenting program
 * version 1.0
 */


/*
  This class is the driver file for the Heroes and Monsters project.  It will
  do the following:

  1.  Allow the user to choose a hero
  2.  Randomly select a monster
  3.  Allow the hero to battle the monster

  Once a battle concludes, the user has the option of repeating the above
*/
public class Dungeon
{
	private static Scanner kb = new Scanner(System.in);
	
    public static void main(String[] args)
	{
		do
		{
			System.out.println("Choose a hero:\n" +
				       "1. Warrior\n" +
					   "2. Sorceress\n" +
					   "3. Thief");
			int random = (int)(Math.random() * 3) + 1;
		    Hero theHero = new HeroFactory().createHero(kb.nextInt());
		    Monster theMonster =  new MonsterFactory().createMonster(random);
			battle(theHero, theMonster);

		} while (playAgain());
		kb.close();
	}

   
/*-------------------------------------------------------------------
playAgain allows gets choice from user to play another game.  It returns
true if the user chooses to continue, false otherwise.
---------------------------------------------------------------------*/
	public static boolean playAgain()
	{
		String again;

		System.out.println("Play again (y/n)?");
		again = kb.next();
		return (again.equals("Y") || again.equals("y"));
	}


/*-------------------------------------------------------------------
battle is the actual combat portion of the game.  It requires a Hero
and a Monster to be passed in.  Battle occurs in rounds.  The Hero
goes first, then the Monster.  At the conclusion of each round, the
user has the option of quitting.
---------------------------------------------------------------------*/
	public static void battle(Hero theHero, Monster theMonster)
	{
		String pause = "p";
		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");


		while (theHero.isAlive() && theMonster.isAlive() && !pause.equals("q"))
		{
		 
			theHero.battleChoices(theMonster);

			
			if (theMonster.isAlive())
			    theMonster.attack(theHero);

	
			System.out.print("\n-->q to quit, anything else to continue: ");
			pause = kb.next();
			
		}

		if (!theMonster.isAlive())
		    System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else
			System.out.println("Quitters never win ;-)");

	}

}