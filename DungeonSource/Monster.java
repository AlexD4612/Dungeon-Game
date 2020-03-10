

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */


public abstract class Monster extends DungeonCharacter
{
	private double chanceToHeal;
	private int minHeal, maxHeal;

/*------------------
 getters and setters
 ------------------*/
	public double getChanceToHeal() {
		return chanceToHeal;
	}

	public void setChanceToHeal(double chanceToHeal) {
		this.chanceToHeal = chanceToHeal;
	}

	public int getMinHeal() {
		return minHeal;
	}

	public void setMinHeal(int minHeal) {
		this.minHeal = minHeal;
	}

	public int getMaxHeal() {
		return maxHeal;
	}

	public void setMaxHeal(int maxHeal) {
		this.maxHeal = maxHeal;
	}


  public Monster(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, double chanceToHeal,
					 int damageMin, int damageMax,
					 int minHeal, int maxHeal)
  {
	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
	this.chanceToHeal = chanceToHeal;
	this.maxHeal = maxHeal;
	this.minHeal = minHeal;

  }

  public void heal()
  {
	boolean canHeal;
	int healPoints;

	canHeal = (Math.random() <= chanceToHeal) && (getHitPoints() > 0);

	if (canHeal)
	{
		healPoints = (int)(Math.random() * (getMaxHeal() - getMinHeal() + 1)) + getMinHeal();
		addHitPoints(healPoints);
		System.out.println(getName() + " healed itself for " + healPoints + " points.\n"
							+ "Total hit points remaining are: " + getHitPoints());
		System.out.println();
	}

  }


 public void subtractHitPoints(int hitPoints)
 {
		super.subtractHitPoints(hitPoints);
		heal();

 }

}