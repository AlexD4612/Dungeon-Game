import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WarriorAttackTest {

	@Test
	void testSpecialAttack1() {
		String key = "";
		WarriorAttack test = new WarriorAttack(key);
		assertTrue((100 <= test.specialAttack() && test.specialAttack() <= 176) || test.specialAttack() == 0);
	}

}
