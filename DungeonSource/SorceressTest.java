import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SorceressTest {
	
	@Test
	void testhandleSpecial1() {
		Sorceress test = new Sorceress();
		Gremlin grem = new Gremlin();
		test.handleSpecial(grem);
		assertTrue(test.getHitPoints() > 75);	
	}

	@Test
	void testattack1() {
		Sorceress test1 = new Sorceress();
		Gremlin grem1 = new Gremlin();
		test1.attack(grem1);
		test1.attack(grem1);
		assertTrue(grem1.getHitPoints() <= 45);
	}
}
