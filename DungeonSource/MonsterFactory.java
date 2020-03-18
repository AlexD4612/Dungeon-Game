public class MonsterFactory {
	
	public MonsterFactory() {}
	
	public Monster createMonster(int monsterNum) {
		if (monsterNum == 1) {
			return new Gremlin();
		}
		else if (monsterNum == 2) {
			return new Ogre();
		}
		else if (monsterNum == 3) {
			return new Skeleton();
		}
		else if (monsterNum == 4) {
			return new Gargoyle();
		}
		else if (monsterNum == 5) {
			return new Ooze();
		}
		else {
			return new Skeleton();
		}
	}
}
