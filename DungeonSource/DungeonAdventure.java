import java.util.Scanner;

public class DungeonAdventure {
		public static void main(String[] args)
		{
			Scanner kb = new Scanner(System.in);
			do
			{
				System.out.println("Choose a hero:\n" +
					       "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief");
				int random = (int)(Math.random() * 3) + 1;
			    Hero theHero = new HeroFactory().createHero(kb.nextInt());
			    Dungeon dungeon = new Dungeon();
				Room[][] dung = dungeon.createDungeon();
				theHero.play(dung,theHero);
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
