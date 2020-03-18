public class Berserker extends Hero {
	
	private Attack specialAttack;
	
	public Berserker() {
		super("Berserker", 150, 5, 0.4, 50, 90, 0.4);
		specialAttack = wFactory.getAttack("Berserker");
	}
	
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " swings his axes at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}

	@Override
	protected String getSpecialAttackName() {
		return "Whirlwind of Axes";
	}

	@Override
	protected Attack getSpecialAttack() {
		return this.specialAttack;
	}

	@Override
	protected void handleSpecial(DungeonCharacter opponent) {
		int blowPoints = specialAttack.specialAttack();
		if (blowPoints != 0) {
			System.out.println(getName() + " whirlwinds his axes for " + blowPoints
							+ " damage!");
			opponent.subtractHitPoints(blowPoints);
		}
		else {
			System.out.println(getName() + " spun out");
			System.out.println();
		}
	}
}
