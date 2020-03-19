import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GargoyleTest {

	@Test
	void testattack1() {
		Gargoyle test = new Gargoyle();
		Warrior war = new Warrior();
		test.attack(war);
		test.attack(war);
		test.attack(war);
		assertTrue(war.getHitPoints() <= 90);
	}
}
