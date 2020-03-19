import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OozeTest {

	@Test
	void testattack() {
		Ooze test = new Ooze();
		Warrior war = new Warrior();
		test.attack(war);
		test.attack(war);
		test.attack(war);
		assertTrue(war.getHitPoints() <= 110);
	}

}
