
public class Weapon extends Item {
	
	private int dmg;
	private int precision;
	
	public Weapon(String _name, int _worth, int _dmg, int _precision) {
		super(_name, _worth);
		dmg = _dmg;
		setPrecision(_precision);
		
	}
	
	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

}
