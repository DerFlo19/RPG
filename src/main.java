
public class Main {

	public static void main(String[] args) {
		
		Player player = new Player("Florian", 100, 0, 30);
		player.equipWeapon(new Weapon("Sword", 10, 20, 30));
		Enemy enemy = new Enemy("EEEEE", 100, new Weapon("e", 10, 10, 10), 30);
		Fight f = new Fight(enemy, player);
		
	}

}
