
public class ThiefAttack extends Attack {
	
	public ThiefAttack(String key) {
		super(key);
	}
	
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
