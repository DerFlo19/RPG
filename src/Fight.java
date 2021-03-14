import java.util.Random;
import java.util.Scanner;

public class Fight {
	
	// Fighting System
	
	private Enemy enemy;
	private Player player;
	
	public Fight(Enemy _enemy, Player _player) {
		enemy = _enemy;
		player = _player;
		
		fight();
	}
	
	private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
	
	private void fight() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println(enemy.getName() + " is attacking you!");
		
		boolean fighting = true;
		while(fighting) {
			
			if(player.getHp() <= 0) {
				System.out.println("You have died!");
				fighting = false;
				break;
			} else if(enemy.getHp() <= 0) {
				System.out.println("You have won!");
				fighting = false;
				break;
			}
			
			System.out.println("You: " + player.getHp() + " HP");
			System.out.println(enemy.getName() + ": " + enemy.getHp() + " HP");
			
			System.out.println("What Weapon do you want use?");
			for(int i = 0; i < player.getWeaponList().size(); i++) {
				System.out.println(i + " - " + player.getWeapon(i).getName());
			}
			if(s.hasNextLine()) {
				
				int choice = s.nextInt();
				int hit = getRandomNumberInRange(0, 50);
				hit += player.getWeapon(choice).getPrecision();
				
				if(hit >= enemy.getAc()) {
					
					enemy.damage(player.getWeapon(choice).getDmg());
					System.out.println("You attacked the enemy and caused " + player.getWeapon(choice).getDmg() + " damage");
					
				} else {
					
					System.out.println("You missed!");
					
				}
				
			}
			
			int hit = getRandomNumberInRange(0, 50);
			hit += enemy.getWeapon(0).getPrecision();
			
			if(hit >= enemy.getAc()) {
				
				player.damage(enemy.getWeapon(0).getDmg());
				System.out.println("The enemy attacked you and caused " + player.getWeapon(0).getDmg() + " damage");
				
			} else {
				
				System.out.println("The enemy missed!");
				
			}
			
		}
		
		s.close();
		
	}
	
}
