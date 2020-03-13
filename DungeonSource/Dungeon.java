import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Dungeon
{
	private static Scanner kb = new Scanner(System.in);

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
	
	
	//HealPotion = 1
		//VisionPotion = 2
		//Monster = 3
		//Pit = 4
		//Multiple items==5
		public Room[][] createDungeon(){
			Room[][] dung = new Room[5][5];		
			dung[0][0]=new Room("I");
			dung[4][4] = new Room("O");
		        ArrayList<Integer> list = new ArrayList<Integer>();
		        for (int x = 1; x <= 5; x++) {
		            list.add(new Integer(x));
		        }
		        Collections.shuffle(list);
		        for(int i = 0;i<=4;i++) {
		        for (int x = 0; x <= 4; x++) {
		        	if(dung[x][i]==null) {
		        	String key = null;
		        	if(list.get(x)==1) {
		        		key = "H";
		        		Room room = new Room (key);
		        		room.setHealthPotions(room.getHealthPotions()+1);
		        		dung[x][i] = room;
		        		Collections.shuffle(list);
		        	}
		        	else if(list.get(x)==2) {
		        		key="V";
		        		Room room = new Room (key);
		        		room.setVisionPotions(room.getVisionPotions()+1);
		        		dung[x][i] = room;
		        		Collections.shuffle(list);
		       
		        	}
		        	else if (list.get(x)==3) {
		        		key="X";
		        		Room room = new Room (key);
		        		dung[x][i] = room;
		        		Collections.shuffle(list);
		        	}
		        	else if(list.get(x)==4) {
		        		key="P";
		        		Room room = new Room (key);
		        		dung[x][i] = room;
		        		Collections.shuffle(list);
		        	}
		        	else if(list.get(x)==5) {
		        		key="M";
		        		Room room = new Room (key);
		        		room.setHealthPotions(room.getHealthPotions()+1);
		        		room.setVisionPotions(room.getVisionPotions()+1);
		        		dung[x][i] = room;
		        		Collections.shuffle(list);
		        	}
		        	
		        	}
			}
		  }
		    return dung;    
		}

}