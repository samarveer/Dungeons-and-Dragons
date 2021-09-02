/* Player class where everything but attacking happens
 * @author Samarveer Sandhu
 * @version 1.0
 */
public class Player extends Move {
	
	//Creating Instance Variables
	private int potions = 3;
	private int potionAmount = 30;
	private int points = 0;
	
	/* Constructor - creates player
	 * @param name
	 * @param health
	 * @param damage
	 */
	public Player(String name, int health, int damage) {
		//Super used to invoke things from the parent class
		super(name, health, damage);
	}
	
	/* Checking to see if there are any potions
	 * @return true/false
	 */
	public boolean hasPotions() {
		return potions > 0;
	}
	
	/* Getting an extra potion
	 * 
	 */
	public void getExtraPotion() {
		if (points < 5) {
			System.out.println("You need at least 5 points to get a potion.");
		} else {
			points -= 5;
			potions++;
		}
	}
	
	/* Getting the number of points 
	 * @return points
	 */
	public int getPoints() {
		return points;
	}
	
	/* Getting the number of potions
	 * @return potions
	 */
	public int getPotions() {
		return potions;
	}
	
	/* What happens when you drink a potion
	 * 
	 */
	public void drinkPotion() {
		//Checking if there are any potions left
		if (hasPotions()) {
			health += potionAmount;
			potions--;
			System.out.println("You drank a potion, it healed you for " + potionAmount + " HP");
			System.out.println("You now have " + health + " HP\n\n");
		} else {
			System.out.println("No more potions left!");
		}
	}
	
	/* What happens when an enemy is defeated
	 * 
	 */
	public void defeat() {
		System.out.println("------------------------------------------");
		System.out.println(" # The enemy was defeated! # ");
		System.out.println(" # You have " + health + " HP left. #");
		points++;
	}
}
