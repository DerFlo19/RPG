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
	
	public static void main(String[] args) {
		
		System.out.println("RPG - by derFlo19");
		System.out.println("1 - Start");
		System.out.println("2 - Leave");
		
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		
		if(choice == 1) {
			
			System.out.println("\nWhat Text colour do you want?");
			System.out.println("1 - White");
			System.out.println("2 - Green");
			
			int colour = s.nextInt();
			if(colour == 2) {
			
				try {
					Process p = Runtime.getRuntime().exec("color a");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			System.out.println("\nWhat is your name?");
			String name = "Player";
			if(s.hasNext()) {
				name = s.next();
			}
			
			if(name.equals("jon") || name.equals("Jon")) {
				System.out.println("Jon hat einen Kackefetisch lol");
			}
			
			System.out.println("\nWhat class do you want to play, " + name + "?");
			System.out.println("1 - Tank - high defense");
			System.out.println("2 - Fighter - high damage");
			System.out.println("3 - Knight - average everything");
			
			Player player = null;
			int classChoice = s.nextInt();
			if(classChoice == 1) {
				player = new Player(name, 200, 0, 75);
				player.equipWeapon(new Weapon("Long Sword", 0, 20, 20));
			} else if(classChoice == 2) {
				player = new Player(name, 100, 0, 35);
				player.equipWeapon(new Weapon("Short Sword", 0, 10, 40));
			} else if(classChoice == 3) {
				player = new Player(name, 150, 0, 50);
				player.equipWeapon(new Weapon("Sword", 0, 15, 30));
			}
			
			System.out.println("Everything is now setup!\nYou will now start your first fight");
			
			ArrayList<Enemy> enemies = new ArrayList<Enemy>();
			
			
//			enemies.add(new Enemy("Knight", 120, new Weapon("Sword", 0, 40, 30), 40));
			enemies.add(new Enemy("Goblin", 70, new Weapon("Mace", 0, 20, 10), 20));
			enemies.add(new Enemy("Goblin", 70, new Weapon("Mace", 0, 20, 10), 20));
			
			boolean playing = true;
			while(playing) {
				
				Scanner sc = new Scanner(System.in);
				Enemy e = enemies.get(getRandomNumberInRange(0, enemies.size() - 1));
				Fight f1 = new Fight(e, player);
				
				int alive = f1.fight();
				if(alive == 0) {
					System.out.println("Restart?");
					System.out.println("1 - yes");
					System.out.println("2 - no");
					if(sc.hasNext()) {
						int restart = sc.nextInt();
						if(restart == 1) {
							continue;
						} else {
							break;
						}
					}
				}
				
				player.heal(1000000);
				e.heal(1000000000);
				System.out.println("\n");
				
			}
			
		}
		
	}

}
