import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BerserkerAttackTest {

	@Test
	void testSpecialAttack1() {
		String key = "";
		BerserkerAttack test = new BerserkerAttack(key);
		assertTrue((50 <= test.specialAttack() && test.specialAttack() <= 150) || test.specialAttack() == 0);
	}

}
