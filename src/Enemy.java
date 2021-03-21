import java.util.ArrayList;

public class Enemy {
	
	private String name;
	private int hp; 	// Health points
	private int maxHp;  // Max hp
	private ArrayList<Weapon> weapon;
	private int ac;
	
	public Enemy(String _name, int _hp, Weapon _weapon , int _ac) {
		// Assigning Attributes
		name = _name;
		hp = _hp;
		maxHp = _hp;
		weapon = new ArrayList<Weapon>();
		weapon.add(_weapon);
		setAc(_ac);
	}
	
	public int getHp() {
		return hp;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public String getName() {
		return name;
	}
	
	public void damage(int dmg) {
		// dmg is short for Damage
		// damage the enemy
		hp = hp - dmg;
	}
	
	public void heal(int heal) {
		// heal the enemy
		// heal = amount of hp that has been added
		
		if(hp == maxHp) {
			// If hp is already maxed then stop
			return;
		} else {
			hp += heal;
			// remove extra hp if hp > maxHp
			if(hp > maxHp) {
				
				int temp = hp;
				hp = hp - (temp - maxHp);
				
			}
		}
		
	}
	
	public ArrayList<Weapon> getWeaponList() {
		return weapon;
	} 
	public void removeWeapon(int i) {
		weapon.remove(i);
	}
	public Weapon getWeapon(int i) {
		return weapon.get(i);
	}

	public void addWeapon(Weapon _weapon) {
		weapon.add(_weapon);
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}

}
