
public abstract class Attack {
	
	private final String KEY;
	
	public Attack(String key) {
		this.KEY = key;
	}

	public abstract int specialAttack();
	
	public String getKey() {
		return this.KEY;
	}
	
}
