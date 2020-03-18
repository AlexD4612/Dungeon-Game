import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ThiefTest {

	@Test
	void testattack1() {
		Thief test = new Thief();
		Gremlin grem = new Gremlin();
		test.attack(grem);
		test.attack(grem);
		assertTrue(grem.getHitPoints() <= 60);
	}
	@Test
	void testhandleSpecial1() {
		int suprise = 0;
		Thief test1 = new Thief();
		if(suprise == 1) {
			assertTrue(test1.getNumTurns() == 2);
		}
		else if(suprise == -1) {
			assertTrue(test1.getNumTurns() == 0);
		}
	}
}
