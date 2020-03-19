import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SkeletonTest {

	@Test
	void testattack1() {
		Skeleton test = new Skeleton();
		Warrior war = new Warrior();
		test.attack(war);
		test.attack(war);
		test.attack(war);
		assertTrue(war.getHitPoints() <= 95);
	}

}
