import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OgreTest {

	@Test
	void testattack1() {
		Ogre test = new Ogre();
		Warrior war = new Warrior();
		test.attack(war);
		test.attack(war);
		test.attack(war);
		assertTrue(war.getHitPoints() <= 95);
	}

}
