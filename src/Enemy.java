/* Move class where the process of spawning a random enemy happens
 * @author Samarveer Sandhu
 * @version 1.0
 */
import java.util.Random;
public class Enemy extends Move {
	
	//Creating Instance Variables
	//The three enemies
	private static String[] enemies = { "Dragon", "Umber Hulk", "Owl Bear"};
	private static int maxHP = 50;
	private static int damage = 25;
	
	/* Constructor - creates enemy
	 * @param name
	 * @param health
	 * @param damage
	 */
	public Enemy(String name, int health, int damage) {
		//Super used to invoke things from the parent class
		super(name, health, damage);	
	}	
	
	/* Spawning a random enemy
	 * @return Enemy
	 */
	public static Enemy spawnEnemy() {
		Random rand = new Random();
		return new Enemy(enemies[rand.nextInt(enemies.length)], rand.nextInt(maxHP), damage);
	}
	
	/* Getting name of the enemy 
	 * @return name - of the enemy
	 */
	public String toString() {
		Random rand = new Random();
		return (enemies[rand.nextInt(enemies.length)]);
	}
	
	
}
