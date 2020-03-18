import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BloodMageTest {
	
	@Test
	void testhandleSpecial1() {
		BloodMage test = new BloodMage();
		Gremlin grem = new Gremlin();
		test.handleSpecial(grem);
		assertTrue(test.getHitPoints() > 90 && grem.getHitPoints() <= 75);	
	}

	@Test
	void testattack1() {
		BloodMage test1 = new BloodMage();
		Gremlin grem1 = new Gremlin();
		test1.attack(grem1);
		test1.attack(grem1);
		assertTrue(grem1.getHitPoints() <= 60);
	}	
}
