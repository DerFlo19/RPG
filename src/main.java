
public class main {

	public static void main(String[] args) {
		
		Player player = new Player("Florian", 100, new Weapon("Sword of God", 50));
		Enemy enemy = new Enemy("Dummy", 100, new Weapon("Nothingness", 0));
		
		new Fight(enemy, player);
		
	}

}
