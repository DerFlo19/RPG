import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Fight {
	
	// Fighting System
	
	private Enemy enemy;
	private Player player;
	private ArrayList<Item> loot;
	private boolean fighting;
	private Scanner s;
	
	public Fight(Enemy _enemy, Player _player) {
		
		enemy = _enemy;
		player = _player;
		loot = new ArrayList<Item>();
		loot.add(new Item("Bones", 5));
		loot.add(new Item("Bones", 5));
		loot.add(new Item("Bones", 5));
		s = new Scanner(System.in);
		
	}
	private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
	
	public int fight() {
				
		System.out.println(enemy.getName() + " is attacking you!");
		
		fighting = true;
		while(fighting) {
			
			System.out.println("\n");
			
			if(player.getHp() <= 0) {
				System.out.println("You have died!");
				return 0;
			} else if(enemy.getHp() <= 0) {
				System.out.println("You have won!");
				
				int gold = getRandomNumberInRange(0, 25);
				System.out.println("You got " + gold + " gold for winning!");
				player.addGold(gold);
				
				return 1;
			}
			
			System.out.println("You: " + player.getHp() + " HP");
			System.out.println(enemy.getName() + ": " + enemy.getHp() + " HP");
			
			System.out.println("What Weapon do you want use?");
			for(int i = 0; i < player.getWeaponList().size(); i++) {
				System.out.println(i + " - " + player.getWeapon(i).getName());
			}
			
			if(s.hasNext()) { 
				
				int choice = s.nextInt();
				int hit = getRandomNumberInRange(0, 50);
				hit += player.getWeapon(choice).getPrecision();
					
				if(hit >= enemy.getAc()) {
					
					enemy.damage(player.getWeapon(choice).getDmg());
					System.out.println("You attacked the enemy and caused " + player.getWeapon(choice).getDmg() + " damage");
					
				} else {
					
					System.out.println("You missed!");
						
				}
				
				int hitE = getRandomNumberInRange(0, 50);
				hitE += enemy.getWeapon(0).getPrecision();
				
				if(hitE >= enemy.getAc()) {
					player.damage(enemy.getWeapon(0).getDmg());
					System.out.println("The enemy attacked you and caused " + enemy.getWeapon(0).getDmg() + " damage");
					
				} else {
					
					System.out.println("The enemy missed!");
					
				}
				
			} else {
				System.out.println("error");
			}		
			
		}
		
		return 0;
		
	}
	
}
