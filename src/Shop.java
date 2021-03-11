import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
	
	private ArrayList<Item> stock;
	private Player player;
	
	public Shop(Player _player) {
		
		stock = new ArrayList<>();
		player = _player;
		
	}
	
	public void enterShop() {
		
		Scanner s = new Scanner(System.in);
		boolean shopping = true;
		
		while(shopping) {
			System.out.println("Welcome to the Shop!");
			System.out.println("What do you want to do?");
			System.out.println("1 - Buy \n2 - Sell \n3 - Leave");
			int option = s.nextInt();
			if(option == 1) {
				if(stock.size() == 0) {
					System.out.println("Sorry, but we're out of stock");
				} else {
					
					System.out.println("What do you want to buy?");
					for(int i = 0; i < stock.size(); i++) {
						
						System.out.println(i + " - " + stock.get(i).getName() + " - " + stock.get(i).getWorth() + " gold");
						
					}
					
					
				}
			} else if(option == 3) {
				shopping = false;
			}
		}
		s.close();
		
	}
	
	public void addItem(Item _item) {
		stock.add(_item);
	}

}
