
public class Player {
	
	private String name;
	private int hp; 	// Health points
	private int maxHp;  // Max hp
	
	public Player(String _name, int _hp) {
		// Assigning Attributes
		name = _name;
		hp = _hp;
		maxHp = _hp;
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
	
	public int damage(int dmg) {
		// dmg is short for Damage
		// damage the enemy
		hp -= dmg;
		
		// If dead return 1 other wise return 0
		if(hp <= 0) {
			return 1; 
		}
		
		return 0;
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

}
