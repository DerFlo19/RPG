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
				int dmg = s.nextInt();
				enemy.damage(player.getWeapon(dmg).getDmg());
				System.out.println("You attacked " + enemy.getName());
			}
			
			player.damage(enemy.getWeapon(0).getDmg());
			System.out.println("The enemy attacked you and did " + enemy.getWeapon(0).getDmg() + " Damage");
			
		}
		
		s.close();
		
	}
	
}
