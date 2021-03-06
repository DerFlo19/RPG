import java.util.ArrayList;

public class Player {
	
	private String name;
	private int hp; 	// Health points
	private int maxHp;  // Max hp
	private ArrayList<Weapon> weapon;
	private ArrayList<Item> inventory;
	private int gold;
	private int ac; 	// Armor class
	public int x, y;
	public int keys;
	
	public Player(String _name, int _hp, int _gold, int _ac, int _x, int _y) {
		// Assigning Attributes
		name = _name;
		hp = _hp;
		maxHp = _hp;
		weapon = new ArrayList<Weapon>();
		gold = _gold;
		inventory = new ArrayList<>();
		x = _x;
		y = _y;
		keys = 0;
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
	
	// Functions to manipulate Gold variable
	public void addGold(int amount) {
		gold += amount;
	}
	public void removeGold(int amount) {
		gold -= amount;
	}
	public int getGold() {
		return gold;
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

	public Weapon getWeapon(int i) {
		return weapon.get(i);
	}

	public void equipWeapon(Weapon _weapon) {
		weapon.add(_weapon);
	}
	public void deequipWeapon(int i) {
		weapon.remove(i);
	}
	public ArrayList<Weapon> getWeaponList() {
		return weapon;
	}
	
	public void addItem(Item _item) {
		inventory.add(_item);
	}
	public void removeItem(int i) {
		inventory.remove(i);
	}
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	public Item getItem(int i) {
		return inventory.get(i);
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}
}
