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
		else if (heroNum == 4) {
				return new BloodMage();
		}
		else if (heroNum == 5) {
			return new Berserker();
	}
		else {
			System.out.println("Invalid choice, Warrior chosen\n\n");
			return new Warrior();
		}
	}
}
