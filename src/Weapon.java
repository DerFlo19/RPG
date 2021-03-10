
public class Weapon {
	
	private String name;
	private int dmg;
	
	public Weapon(String _name, int _dmg) {
		name = _name;
		setDmg(_dmg);
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	public String getName() {
		return name;
	}

}
