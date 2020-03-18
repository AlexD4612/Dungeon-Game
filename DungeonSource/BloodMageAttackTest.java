import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BloodMageAttackTest {

	@Test
	void testBloodMageAttack1() {
		String key = "";
		BloodMageAttack test = new BloodMageAttack(key);
		assertTrue((0 <= test.specialAttack() && test.specialAttack() <= 70) || test.specialAttack() == 0);
	}
}
