
public class BerserkerAttack extends Attack{
	
	public BerserkerAttack(String key) {
		super(key);
	}

	@Override
	public int specialAttack() {
		if (Math.random() <= 0.5) 
		{
			return (int)(Math.random() * 100) + 50;
		}
		else {
			return 0;
		}
	}
}
