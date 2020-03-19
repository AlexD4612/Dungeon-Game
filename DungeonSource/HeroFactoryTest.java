 import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HeroFactoryTest {

	@Test
	void testCreateHero1() {
		HeroFactory test = new HeroFactory();
		int heroNum = 0;
		if(heroNum == 1) {
			assertTrue(test.createHero(1) == new Warrior());
		}
		else if(heroNum == 2) {
			assertTrue(test.createHero(2) == new Sorceress());
		}
		else if(heroNum == 3) {
			assertTrue(test.createHero(3) == new Thief());
		}
		else if(heroNum == 4) {
			assertTrue(test.createHero(4) == new BloodMage());
		}	
		else if(heroNum == 5) {
			assertTrue(test.createHero(5) == new Berserker());
		}
	}
}
