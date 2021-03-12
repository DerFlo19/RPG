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
					System.out.println("You have " + player.getGold() + " gold");
					System.out.println("0 - Cancel");
					for(int i = 0; i < stock.size(); i++) {
						
						System.out.println(i + 1 + " - " + stock.get(i).getName() + " - " + stock.get(i).getWorth() + " gold");
						
					}
					
					int choice = s.nextInt();
					if(choice > 0) {
						if(stock.get(choice - 1).worth > player.getGold()) {
							System.out.println("You dont have enought gold!");
						} else {
							
							player.removeGold(stock.get(choice - 1).worth);
							player.addItem(stock.get(choice - 1));
							
						}
					}
				}
			} else if(option == 3) {
				shopping = false;
			} else if(option == 2) {
				
				System.out.println("What do you want to sell");
				System.out.println("You have " + player.getGold() + " gold");
				System.out.println("0 - Cancel");
				
				for(int i = 0; i < player.getInventory().size(); i++) {
					
					System.out.println(i + 1 + " - " + player.getItem(i).getName() + " - " + player.getItem(i).worth);
					
				}
				
				int choice = s.nextInt();
				if(choice > 0) {
					player.addGold(player.getItem(choice - 1).worth);
					player.removeItem(choice - 1);
				} 
			}
		}
		s.close();
		
	}
	
	public void addItem(Item _item) {
		stock.add(_item);
	}

}
