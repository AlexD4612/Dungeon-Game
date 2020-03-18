import java.util.Scanner;

public class DungeonAdventure {
		public static void main(String[] args)
		{
			Scanner kb = new Scanner(System.in);
			do
			{
				System.out.println("Welcome to Dungeon Adventure! You mysteriously arrived at\na dungeon and have to collect all four pillars of OO!\nWatch out for Monsters and Pits, and keep an eye open for potions!");
				System.out.println("Choose a hero:\n" +
					       "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief\n" +
						   "4. Blood Mage");
				int random = (int)(Math.random() * 3) + 1;
			    Hero theHero = new HeroFactory().createHero(kb.nextInt());
			    Dungeon dungeon = new Dungeon();
				Room[][] dung = dungeon.createDungeon();
				theHero.play(dung,theHero,dungeon);
			} while (playAgain());
			kb.close();
		}
		public static boolean playAgain()
		{
			Scanner kb = new Scanner(System.in);
			String again;

			System.out.println("Play again (y/n)?");
			again = kb.next();
			return (again.equals("Y") || again.equals("y"));
		}

	}
