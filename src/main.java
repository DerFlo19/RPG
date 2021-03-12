
public class Main {

	public static void main(String[] args) {
		
		Player player = new Player("Florian", 100, 10);
		Shop shop = new Shop(player);
		
		player.addItem(new Item("Bones", 10));
		shop.addItem(new Item("eeeeeeeeeeeeeeeeeeeeee", 20));
		
		shop.enterShop();
		
	}

}
