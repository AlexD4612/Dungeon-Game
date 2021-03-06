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


public abstract class Hero extends DungeonCharacter
{
	private double chanceToBlock;
	private int numTurns;
	private int healthPotions;
	private int visionPotions;
	private int pillars;
	protected AttackFlyweightFactory wFactory;
	
//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
  public Hero(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax, double chanceToBlock) {
	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
	this.chanceToBlock = chanceToBlock;
	readName();
	wFactory = new AttackFlyweightFactory();
  }

public int getVisionPotions() {
	return visionPotions;
}

public void setVisionPotions(int visionPotions) {
	this.visionPotions = visionPotions;
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
calculations. getSpecialAttack.specialAttack() delegates to 
subclasses what the special attack calculation is and handleSpecial(opponent)
handles the integer that is returned from getSpecialAttack.specialAttack().

Step delegated to subclasses:
getSpecialAttackName()
getSpecialAttack()
handleSpecial(DungeonCharacter opponent)
---------------------------------------------------------*/

protected abstract String getSpecialAttackName();
protected abstract Attack getSpecialAttack();
protected abstract void handleSpecial(DungeonCharacter opponent);

public final void battleChoices(DungeonCharacter opponent)
	{
		 numTurns = getAttackSpeed()/opponent.getAttackSpeed();
	
			if (numTurns == 0)
				numTurns++;
	
			System.out.println("Number of turns this round is: " + numTurns);
		
		String choice;
		Scanner kb = new Scanner(System.in);
	
		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. " + getSpecialAttackName());
		    System.out.print("Choose an option: ");
		    choice = kb.next();
		    
		    if(choice.equals("1")) {
		    	attack(opponent);
	
		    }
		    else if (choice.equals("2") ) {
		    	getSpecialAttack().specialAttack();
		    	handleSpecial(opponent);
		    }
		    else {
		    	System.out.println("invalid choice!");
		    }
		   
			setNumTurns(getNumTurns()-1);
		    if (getNumTurns()> 0)
			    System.out.println("Number of turns remaining is: " + getNumTurns());
	
		} while(getNumTurns() > 0 && getHitPoints() > 0 && opponent.getHitPoints() > 0);
	
	}

public void play(Room[][] dung,Hero theHero,Dungeon dungeon) {
	Scanner kb = new Scanner(System.in);
	int i = 0;
	int j = 0;
	Room room = dung[i][j];
	System.out.println("you awaken in the dungeon");
	if(theHero.pillars!=4) {
		while(theHero.isAlive()){
		room = dung[i][j];
		System.out.print(room+"\n");
		checkKey(room,theHero,dung);
		
		
		if(!theHero.isAlive()||(room==dung[4][4]&&theHero.pillars==4)) {
			break;
		}
		
		System.out.println("1. Use potion\n2. Move");
		
		String choice =kb.next();
		if(choice.equals("1")) Potions(theHero,dung,i,j);
		else if (choice.equals("3")) System.out.print(dungeon.toString(dung)+"\n");
		else if(choice.equals("2")) { 
			System.out.println("Choose a direction using W-A-S-D keys");
			String move = kb.next();
		
			if(move.equals("d")) {
				if(j!=4) {
					j++;
			}
			else {
				System.out.print("Can't go further right\n");
			}
		}
		else if(move.equals("a")) {
			if(j!=0) {
				j--;
			}
			else {
				System.out.print("Can't go further left\n");
			}
		}
		else if(move.equals("w")) {
			if(i!=0) {
				i--;
			}
			else {
				System.out.print("Can't go further up\n");
			}
		}
			else if(move.equals("s")) {
				if(i!=4) {
					i++;
				}
				else {
					System.out.print("Can't go further down\n");
				}
		}
		}	
		else {
			System.out.println("Invalid choice!");
		}
	}	
	}
	else {
		checkKey(room,theHero,dung);
	}
	
	System.out.println("Game over!");
	
}


public static void checkKey(Room room, Hero theHero,Room[][] dung) {
	int random = (int)(Math.random() * 3) + 1;
	Monster theMonster =  new MonsterFactory().createMonster(random);
	if(room!=dung[4][4]) {
	if(room.getKey().equals("I")) {
		System.out.println("You are at the entrance of the dungeon");
	}
	else if(room.getKey().equals("X")) {
		System.out.println("You encountered a monster!");
		Dungeon.battle(theHero,theMonster);
		room.setKey("E");
		
	}
	else if(room.getKey().equals("P")) {
		pit(theHero);
		
	}
	else if(room.getKey().equals("p")) {
		theHero.setPillars(theHero.getPillars()+1);
		System.out.println("You found pillar "+theHero.getPillars()+"/4");
		room.setPillars(room.getPillars() - 1);
		room.setKey("E");
		
	}
	
	else if (room.getKey().equals("H")) {
		System.out.println("You found a healing potion");
		room.setHealthPotions(room.getHealthPotions() - 1);
		theHero.setHealthPotions(theHero.getHealthPotions() + 1);
		room.setKey("E");
		
		
	}
	else if (room.getKey().equals("V")) {
		System.out.println("You found a Vision potion");
		room.setVisionPotions(room.getVisionPotions() - 1);
		theHero.visionPotions++;
		room.setKey("E");
	}
	else if (room.getKey().equals("E")){
		System.out.println("this room is empty");
	}
	else if (room.getKey().equals("M")) {
		theHero.visionPotions++;
		theHero.healthPotions++;
		room.setKey("E");
		
	}
	}
	else if (room.getKey().equals("O")) {
		if(theHero.getPillars()<4) {
			System.out.println("You found the exit, but you don't have enough pillars of OO!");
		}
		else {
			System.out.println("You escaped the dungeon with all 4 pillars of OO!");
		}
	}
}



public int getPillars() {
	return pillars;
}

public void setPillars(int pillars) {
	this.pillars = pillars;
}

public static void pit(Hero theHero) {
	int random = (int)(Math.random()*15)+1;
	theHero.setHitPoints(theHero.getHitPoints()-random);
	System.out.println(theHero.getName()+" fell in a pit and lost "+random+" hitpoints");
}



public static void useHealPotion(Hero Hero) {
	if(Hero.getHealthPotions()>0) {
	
	
	double randomDouble = Math.random();
	randomDouble = randomDouble * 15 + 1;
	int randomInt = (int) randomDouble;
	Hero.addHitPoints(randomInt);
	System.out.println(Hero.getName() +" healed "+randomInt+" hitpoints");
	Hero.setHealthPotions(Hero.getHealthPotions()-1);
	}
	else {
		System.out.println("You have no health potions left!");
	}
}


public void Potions(Hero Hero,Room[][] dung,int i,int j) {
	Scanner kb = new Scanner(System.in);
	System.out.println("Health Potions: "+Hero.healthPotions+
					  "\nVision Potions: "+Hero.visionPotions);
	System.out.println("Which potion would you like to use?\n1. Health\n2. Vision \n3. Back");
	String choice = kb.next();
	if (choice.equals("1")) {
	  useHealPotion(Hero);
	}
	else if (choice.equals("2")){
		useVisionPotion(Hero,dung,i,j);
	}
	else if (choice.equals("3")) {
		return;
	}
	
}

public void useVisionPotion(Hero hero,Room[][]dung,int i,int j) {
	if(i!=4) {
	System.out.print(dung[i][j+1].toString()+"\n");
	}
	if(i!=0) {
	System.out.print(dung[i-1][j].toString());
	}
	System.out.print(dung[i][j].toString());
	if(i!=4) {
	System.out.print(dung[i+1][j].toString()+"\n");
	}
	if(i!=0) {
	System.out.print(dung[i][j-1].toString());
	}
	hero.visionPotions--;
}

public int getHealthPotions() {
	return healthPotions;
}

public void setHealthPotions(int healthPotions) {
	this.healthPotions = healthPotions;
	}
}

