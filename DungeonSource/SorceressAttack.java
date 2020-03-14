
public class SorceressAttack implements Attack {
	
	private final int MIN_ADD = 25;
	private final int MAX_ADD = 50;
	private final String KEY;
	
	public SorceressAttack(String key) {
		this.KEY = key;
	}
	
	public String getKey() {
		return this.KEY;
	}

	@Override
	public int specialAttack() {
		return (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;	
	}

}

