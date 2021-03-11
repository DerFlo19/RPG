
public class Main {

	public static void main(String[] args) {
		
		Player player = new Player("Florian", 100, new Weapon("E", 0, 0), 100000);
		Shop shop = new Shop(player);
		shop.addItem(new Item("Cock and ball torture", 20));
		shop.enterShop();
		
	}

}
