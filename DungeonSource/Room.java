
public class Room {
	private int healthPotions;
	private int visionPotions;
	private String key;
	private int Pillars;
	public int getHealthPotions() {
		return healthPotions;
	}

	public void setHealthPotions(int healthPotions) {
		this.healthPotions = healthPotions;
	}

	public int getVisionPotions() {
		return visionPotions;
	}

	public void setVisionPotions(int visionPotions) {
		this.visionPotions = visionPotions;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getPillars() {
		return pillars;
	}

	public void setPillars(int pillars) {
		this.pillars = pillars;
	}

	private int pillars;
	
	public Room(String key) {
		this.key = key;
		if(key.equals("H")) {
			healthPotions++;
		}
		else if (key.equals("V")) {
			visionPotions++;
		}
		else if (key.equals("p")) {
			pillars++;
		}
	}
	public String toString() {
		String room ="***--***\n"
				   + "*  "+key+"   *\n"
				   + "*      *\n"
				   + "********";
		return room;
		}

}
