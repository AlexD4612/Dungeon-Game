import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MonsterFactoryTest {

	@Test
	void testCreateMonster1() {
		MonsterFactory test = new MonsterFactory();
		int monsterNum = 0;
		if(monsterNum == 1) {
			assertTrue(test.createMonster(1) == new Gremlin());
		}
		else if(monsterNum == 2) {
			assertTrue(test.createMonster(2) == new Ogre());
		}
		else if(monsterNum == 3) {
			assertTrue(test.createMonster(3) == new Skeleton());
		}
		else if(monsterNum == 4) {
			assertTrue(test.createMonster(4) == new Gargoyle());
		}
		else if(monsterNum == 5) {
			assertTrue(test.createMonster(5) == new Ooze());
		}
	}

}
