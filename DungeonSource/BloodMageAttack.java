
public class BloodMageAttack extends Attack{

	public BloodMageAttack(String key) {
		super(key);
	}

	@Override
	public int specialAttack() {
		if (Math.random() <= .95)
		{
			return(int)(Math.random() * 30) + 20;
		}
		else {
			return 0;
		}
	}
}
