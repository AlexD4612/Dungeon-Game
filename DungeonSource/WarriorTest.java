import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WarriorTest {
	
	@Test
	void testattack1() {
		Warrior test = new Warrior();
		Gremlin grem = new Gremlin();
		test.attack(grem);
		test.attack(grem);
		assertTrue(grem.getHitPoints() <= 55);
	}

	@Test
	void testhandleSpecial1() {
		Warrior test1 = new Warrior();
		Gremlin grem1 = new Gremlin();
		test1.handleSpecial(grem1);
		assertTrue(grem1.getHitPoints() <= 30);	
	}
}
