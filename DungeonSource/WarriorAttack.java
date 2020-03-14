
public class WarriorAttack extends Attack {
	
	public WarriorAttack(String key) {
		super(key);
	}

	@Override
	public int specialAttack() {
		if (Math.random() <= .4)
		{
			return(int)(Math.random() * 76) + 100;
		}
		else {
			return 0;
		}
	}

}


