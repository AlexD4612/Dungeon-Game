public class HeroFactory {
	
	public HeroFactory() {}
	
	public Hero createHero(int heroNum) {
		if (heroNum == 1) {
				return new Warrior();
		}
		else if (heroNum == 2) {
				return new Sorceress();
		}
		else if (heroNum == 3) {
				return new Thief();
		}
		else {
				return new Warrior();
		}
	}
}
