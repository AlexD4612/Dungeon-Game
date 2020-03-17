import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AttackFlyweightTest {

	private ArrayList<Attack> pool;
	
	@Test
	void test() {
		AttackFlyweightFactory test = new AttackFlyweightFactory();
		pool = new ArrayList<Attack>();
		assertTrue(pool.isEmpty() == true);
	}
	
	@Test
	void test2() {
		AttackFlyweightFactory test = new AttackFlyweightFactory();
		pool = new ArrayList<Attack>();
		pool.add(new SorceressAttack("Sorceress"));
		assertTrue(pool.isEmpty() == false);
	}

}
