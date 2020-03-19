import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GremlinTest {

	@Test
	void testattack() {
		Gremlin test = new Gremlin();
		Warrior war = new Warrior();
		test.attack(war);
		test.attack(war);
		test.attack(war);
		assertTrue(war.getHitPoints() <= 110);
	}

}
