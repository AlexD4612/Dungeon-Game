
public class BloodMageAttack extends Attack{

	public BloodMageAttack(String key) {
		super(key);
	}

	@Override
	public int specialAttack() {
		if (Math.random() <= .65)
		{
			return(int)(Math.random() * 50) + 20;
		}
		else {
			return 0;
		}
	}
}
