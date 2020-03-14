
public class WarriorAttack implements Attack {
	
	private final String KEY;
	
	public WarriorAttack(String key) {
		this.KEY = key;
	}
	
	public String getKey() {
		return this.KEY;
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

