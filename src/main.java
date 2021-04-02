
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
	
	public static void main(String[] args) throws IOException {
		
		MapLoader ml = new MapLoader();
		
		Player player = new Player("player", 100, 20, 30, 0, 0);
		player.equipWeapon(new Weapon("Stick", 0, 5, 20));
		
		Item[] loot = {new Item("Bones", 5), new Item("Bones", 5), new Weapon("Copper Sword", 10, 25, 20)};
		Enemy[] enemies = {new Enemy("Goblin", 50, new Weapon("Club", 0, 10, 7), 10), new Enemy("Goblin", 50, new Weapon("Club", 0, 10, 7), 10)};
		
		String maplist = ml.listDirectories();
		Boolean playing = true;
		int currentMap = 0;
		Scanner s = new Scanner(System.in);
		while(playing) {
			currentMap++;
			ArrayList<ArrayList<Character>> map;
			try {
				map = ml.loadMap(maplist + "\\map" + currentMap + ".txt");
			} catch(Exception e) {
				playing = false;
				break;
			}
			Boolean onMap = true;
			for(int i = 0; i < map.size(); i++) {
				
				for(int j = 0; j < map.get(i).size(); j++) {
					
					if(map.get(i).get(j) == 'S') {
						
						player.x = j;
						player.y = i;
						
					}
					
				}
								
			}
			
			while(onMap) {
				
				int width = 30;
				int height = 10;
				
				System.out.print("+");
				for(int i = 0; i < width; i++) {
					System.out.print('-');
				}
				System.out.println("+");
				
				for(int i = height; i > 0; i--) {
					System.out.print('|');
					for(int j = width; j > 0; j--) {
						
						try {
							char tile = map.get(player.y - i + height/2).get(player.x - j + width/2);
							if(i == height/2 && j == width/2) {
								System.out.print('P');
							} else if(tile == 'S') {
								System.out.print(' ');
							} else {
								System.out.print(tile);
							}
						} catch(Exception e) {
							System.out.print('#');
						}
						
					}
					System.out.println('|');
					
				}
				System.out.print("+");
				for(int i = 0; i < width; i++) {
					System.out.print('-');
				}
				System.out.println("+");
				
				System.out.println("w - up");
				System.out.println("a - left");
				System.out.println("s - down");
				System.out.println("d - right");
				System.out.println("i - inventory");
				String direction = "eeeeeeeeeeeeeee";
				if(s.hasNext()) {
					direction = s.next();
				}
				
				if(direction.equals("i")) {
					
					for(int i = 0; i < player.getInventory().size(); i++) {
						
						System.out.println(i + 1 + " - " + player.getItem(i).getName());
						
					}
					
					int choice = s.nextInt();
					if(player.getItem(choice - 1).getClass() == Weapon.class) {
						System.out.println("What do you want to do?");
						System.out.println("1 - Equip");
						System.out.println("2 - Delete");
						System.out.println("3 - cancel");
						int action = s.nextInt();
						if(action == 1) {
							player.equipWeapon((Weapon) player.getItem(choice - 1));
						} else if(action == 2) {
							player.removeItem(choice - 1);
						} 
						
					} else {
						System.out.println("What do you want to do?");
						System.out.println("1 - Delete");
						System.out.println("2 - cancel");
						int action = s.nextInt();
						if(action == 1) {
							player.removeItem(choice - 1);
						}
					}
					
				}
				
				if(direction.equals("w") && map.get(player.y - 1).get(player.x) != '#') {
					if(map.get(player.y - 1).get(player.x) == 'D' && player.keys > 0) {
						player.keys -= 1;
						player.y -= 1;
						map.get(player.y).set(player.x, ' ');
					} else if(map.get(player.y - 1).get(player.x) == 'D' && player.keys == 0) {
						System.out.println("You need a key!");
					} else {
						player.y -= 1;
					}
				}
				if(direction.equals("a") && map.get(player.y).get(player.x - 1) != '#') {
					if(map.get(player.y).get(player.x - 1) == 'D' && player.keys > 0) {
						player.keys -= 1;
						player.x -= 1;
						map.get(player.y).set(player.x, ' ');
					} else if(map.get(player.y).get(player.x - 1) == 'D' && player.keys == 0) {
						System.out.println("You need a key!");
					} else {
						player.x -= 1;
					}
				}
				if(direction.equals("s") && map.get(player.y + 1).get(player.x) != '#') {
					if(map.get(player.y + 1).get(player.x) == 'D' && player.keys > 0) {
						player.keys -= 1;
						player.y += 1;
						map.get(player.y).set(player.x, ' ');
					} else if(map.get(player.y).get(player.x) == 'D' && player.keys == 0) {
						System.out.println("You need a key!");
					} else {
						player.y += 1;
					}
				}
				if(direction.equals("d") && map.get(player.y).get(player.x + 1) != '#') {
					if(map.get(player.y).get(player.x + 1) == 'D' && player.keys > 0) {
						player.keys -= 1;
						player.x += 1;
						map.get(player.y).set(player.x, ' ');
					} else if(map.get(player.y).get(player.x + 1) == 'D' && player.keys == 0) {
						System.out.println("You need a key!");
					} else {
						player.x += 1;
					}
				}
				
				switch(map.get(player.y).get(player.x)) {
					
				case('K'):
					System.out.println("You have found a key");
					player.keys++;
				    map.get(player.y).set(player.x, ' ');
				    break;
				case('H'):
					onMap = false;
					break;
				case('E'):
					Enemy enemy = enemies[getRandomNumberInRange(0, enemies.length - 1)];
					enemy.heal(10000);
					Fight fight = new Fight(enemy, player);
					fight.fight();
					enemy.heal(10000);
					player.heal(10000);
					map.get(player.y).set(player.x, ' ');
					break;
				case('i'):
					Item foundItem = loot[getRandomNumberInRange(0, loot.length - 1)];
					System.out.println("You have found: " + foundItem.name);
					player.addItem(foundItem);
					map.get(player.y).set(player.x, ' ');
					break;
				case('g'):
					int goldAmount = getRandomNumberInRange(1, 20);
					System.out.println("You have found: " + goldAmount + " gold");
					player.addGold(goldAmount);;
					map.get(player.y).set(player.x, ' ');
					break;
				
				}
				
			}	
		
		}
		
		s.close();
		
	}

}
