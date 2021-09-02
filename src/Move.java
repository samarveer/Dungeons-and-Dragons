/* Move class where the attacking in the battle
 * @author Samarveer Sandhu
 * @version 1.0
 */
import java.util.Random;
public class Move {
	
	//Creating Instance Variables
	protected String name;
	protected int health;
	protected int damage;
	
	
	/* Constructor 
	 * @param name
	 * @param health
	 * damage
	 */
	public Move(String name,int health, int damage) {
		this.name = name;
		this.health = health;
		this.damage = damage;
	}
	
	/*	What happens when you attack the enemy
	 * @param m 
	 * 
	 */
	public void attackEnemy(Move m) {
		int damage = getDamage();
		System.out.println("You strike the enemy for "+damage+" HP." );
		m.damage(damage);
	}
	
	/*	What happens when the enemy attacks you
	 * @param m 
	 * 
	 */
	public void getAttacked(Move m) {
		int damage = getDamage();
		System.out.println("The enemy strikes you for "+damage+" HP\n");
		m.damage(damage);
	}
	
	/*	Player and enemy taking damage
	 * @param damage
	 */
	public void damage(int damage) {
		health -= damage;
	}
	
	/*	Getting the amount of damage done
	 * @return damage
	 */
	public int getDamage() {
		Random rand = new Random();
		return rand.nextInt(damage);
	}
	
	/* Checking if player/enemy is still alive
	 * @return true/false
	 */
	public boolean isAlive() {
		return health> 0;		
	}
	
	/* Checking if player/enemy is dead
	 * @return true/false
	 */
	public boolean isDying() {
		return !isAlive();
	}
	
	/* Returning name
	 * @return
	 */
	public String toString() {
		return name;
	}
}
