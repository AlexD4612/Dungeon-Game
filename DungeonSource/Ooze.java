
public class Ooze extends Monster{

	public Ooze() {
		super("Slimey the Ooze", 90, 2, 0.5, 0.7, 15, 45, 25, 60);
	}

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " engulfs " +
							opponent.getName() + " in slime:");
		super.attack(opponent);

	}
}