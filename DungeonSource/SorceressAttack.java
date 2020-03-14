
public class SorceressAttack extends Attack {
	
	private final int MIN_ADD = 25;
	private final int MAX_ADD = 50;
	
	public SorceressAttack(String key) {
		super(key);
	}

	public int specialAttack() {
		return (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;	
	}

}


