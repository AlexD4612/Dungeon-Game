import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SorceressAttackTest {

	@Test
	void testSpecialAttack1() {
		String key = "";
		SorceressAttack test = new SorceressAttack(key);
		assertTrue(25 <= test.specialAttack() && test.specialAttack() <= 50);
	}

}
