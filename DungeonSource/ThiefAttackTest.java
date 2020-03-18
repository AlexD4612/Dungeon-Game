import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ThiefAttackTest {

	@Test
	void testSpecialAttack1() {
		String key = "";
		ThiefAttack test = new ThiefAttack(key);
		double suprise = Math.random();
		if(suprise <= .4) {
			assertTrue(test.specialAttack() == 1);
		}
		if(suprise >= .9) {
			assertTrue(test.specialAttack() == -1); 
		}
		else {
			assertTrue(test.specialAttack() == 0);
		}
	}
}
