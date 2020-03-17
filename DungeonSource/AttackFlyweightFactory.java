import java.util.ArrayList;

public class AttackFlyweightFactory{
	
	private ArrayList<Attack> pool;
	
	public AttackFlyweightFactory() {
		pool = new ArrayList<Attack>();
		initialize();
	}
	
	private void initialize() {	
		pool.add(new SorceressAttack("Sorceress"));
		pool.add(new ThiefAttack("Theif"));
		pool.add(new WarriorAttack("Warrior"));
		pool.add(new BloodMageAttack("BloodMage"));
	}
	
	public Attack getAttack(String key) {
		for (Attack a : pool) {
			if (a.getKey().equals(key)) {
				return a;
			}
		}
		return null;
	}
	
}