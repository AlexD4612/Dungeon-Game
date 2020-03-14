
public class ThiefAttack implements Attack {
	
	private final String KEY;
	
	public ThiefAttack(String key) {
		this.KEY = key;
	}
	
	public String getKey() {
		return this.KEY;
	}
	
	@Override
	public int specialAttack() {
		double surprise = Math.random();
		if (surprise <= .4) {
			return 1;
		}
		else if (surprise >= .9){
			return -1;
		}
		else {
			return 0;
		}
	}

}

