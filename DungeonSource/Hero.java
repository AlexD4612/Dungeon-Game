import java.util.Scanner;

/**
 * Title: Hero.java
 *
 * Description: Abstract base class for a hierarchy of heroes.  It is derived
 *  from DungeonCharacter.  A Hero has battle choices: regular attack and a
 *  special skill which is defined by the classes derived from Hero.
 *
 *  class variables (all are directly accessible from derived classes):
 *    chanceToBlock -- a hero has a chance to block an opponents attack
 *    numTurns -- if a hero is faster than opponent, their is a possibility
 *                for more than one attack per round of battle
 *
 *  class methods (all are public):
 *    public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
	  public void readName()
	  public boolean defend()
	  public void subtractHitPoints(int hitPoints)
	  public void battleChoices(DungeonCharacter opponent)

 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */


public abstract class Hero extends DungeonCharacter implements Attack
{
	private double chanceToBlock;
	private int numTurns;

//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
  public Hero(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax, double chanceToBlock) {
	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
	this.chanceToBlock = chanceToBlock;
	readName();
  }

/*-------------------------------------------------------
readName obtains a name for the hero from the user

Receives: nothing
Returns: nothing

This method calls: nothing
This method is called by: hero constructor
---------------------------------------------------------*/
  public void readName() {
	  Scanner kb = new Scanner(System.in);
		System.out.print("Enter character name: ");
		setName(kb.next());
  }
/*--------------------------------------------
 getChancetoBlock is a getter method for the private field chanceToBlock
 
  Recieves:nothing
  Returns: chanceToBlock
  
  this method calls: nothing
  this method is called by: hero subclasses
  
 ---------------------------------------------*/
public double getChanceToBlock() {
	return chanceToBlock;
}
/*-------------------------------------------------
 setChanceToBlock is a setter method for the private field chanceToBlock
 
 Receives: double
 Returns: nothing
 
 this method calls: nothing
 this method is called by: hero subclasses
 
 *--------------------------------------------------*/


public void setChanceToBlock(double chanceToBlock) {
	this.chanceToBlock = chanceToBlock;
}

/*--------------------------------------------
getNumTurns is a getter method for the private field numTurns

 Recieves:nothing
 Returns: numTurns
 
 this method calls: nothing
 this method is called by: hero subclasses
 
---------------------------------------------*/

public int getNumTurns() {
	return numTurns;
} 

/*-------------------------------------------------
setNumTurns is a setter method for the private field numTurns
Receives: int
Returns: nothing

this method calls: nothing
this method is called by: hero subclasses

*--------------------------------------------------*/

public void setNumTurns(int numTurns) {
	this.numTurns = numTurns;
} 

/*-------------------------------------------------------
defend determines if hero blocks attack

Receives: nothing
Returns: true if attack is blocked, false otherwise

This method calls: Math.random()
This method is called by: subtractHitPoints()
---------------------------------------------------------*/
  public boolean defend()
  {
		return Math.random() <= chanceToBlock;

  }

/*-------------------------------------------------------
subtractHitPoints checks to see if hero blocked attack, if so a message
is displayed, otherwise base version of this method is invoked to
perform the subtraction operation.  This method overrides the method
inherited from DungeonCharacter promoting polymorphic behavior

Receives: hit points to subtract
Returns: nothing

This method calls: defend() or base version of method
This method is called by: attack() from base class
---------------------------------------------------------*/
public void subtractHitPoints(int hitPoints)
	{
		if (defend())
		{
			System.out.println(getName() + " BLOCKED the attack!");
		}
		else
		{
			super.subtractHitPoints(hitPoints);
		}

	}

/*-------------------------------------------------------
battleChoices is a Template method that delegates to
subclasses about what attacks they should do. getSpecialAttack()
returns the name of the special attack. attack(opponent) 
prints out the attack then asks the super class for
calculations. specialAttack(opponent) delegates to 
subclasses what the special attack is and how it
should be performed.
---------------------------------------------------------*/

protected abstract String getSpecialAttack();

public final void battleChoices(DungeonCharacter opponent)
	{
		 numTurns = getAttackSpeed()/opponent.getAttackSpeed();
	
			if (numTurns == 0)
				numTurns++;
	
			System.out.println("Number of turns this round is: " + numTurns);
		
		int choice;
		Scanner kb = new Scanner(System.in);
	
		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. " + getSpecialAttack());
		    System.out.print("Choose an option: ");
		    choice = kb.nextInt();
		    
		    if(choice == 1) {
		    	attack(opponent);
	
		    }
		    else if (choice == 2 ) {
		    	specialAttack(opponent);
		    }
		    else {
		    	System.out.println("invalid choice!");
		    }
		   
			setNumTurns(getNumTurns()-1);
		    if (getNumTurns()> 0)
			    System.out.println("Number of turns remaining is: " + getNumTurns());
	
		} while(getNumTurns() > 0 && getHitPoints() > 0 && opponent.getHitPoints() > 0);
	
	}
}