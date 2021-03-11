
public class Weapon extends Item {
	
	private int dmg;
	
	public Weapon(String _name, int _worth, int _dmg) {
		super(_name, _worth);
		dmg = _dmg;
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

}
