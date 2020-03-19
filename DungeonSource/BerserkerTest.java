import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BerserkerTest {

	@Test
	void testattack1() {
		Berserker test = new Berserker();
		Gremlin grem = new Gremlin();
		test.attack(grem);
		test.attack(grem);
		test.attack(grem);
		assertTrue(grem.getHitPoints() <= 20);
	}
	
	@Test
	void testhandleSpecial1() {
		Berserker test1 = new Berserker();
		Gremlin grem1 = new Gremlin();
		test1.handleSpecial(grem1);
		test1.handleSpecial(grem1);
		assertTrue(grem1.getHitPoints() <= 30);	
	}

}
