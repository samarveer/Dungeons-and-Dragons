
/* Main class where all the things that happen in the dungeon occur
 * @author Samarveer Sandhu
 * @version 1.0
 */
import java.util.Scanner; //imports

public class GameTester {

	/*
	 * Main class(heart of program)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Player p = new Player("Dungeon Master", 150, 60);

		Scanner in = new Scanner(System.in);
		// ASCII Art
		System.out.println(
				"██████╗ ██╗   ██╗███╗   ██╗ ██████╗ ███████╗ ██████╗ ███╗   ██╗███████╗     █████╗ ███╗   ██╗██████╗     ██████╗ ██████╗  █████╗  ██████╗  ██████╗ ███╗   ██╗███████╗");
		System.out.println(
				"██╔══██╗██║   ██║████╗  ██║██╔════╝ ██╔════╝██╔═══██╗████╗  ██║██╔════╝    ██╔══██╗████╗  ██║██╔══██╗    ██╔══██╗██╔══██╗██╔══██╗██╔════╝ ██╔═══██╗████╗  ██║██╔════╝");
		System.out.println(
				"██║  ██║██║   ██║██╔██╗ ██║██║  ███╗█████╗  ██║   ██║██╔██╗ ██║███████╗    ███████║██╔██╗ ██║██║  ██║    ██║  ██║██████╔╝███████║██║  ███╗██║   ██║██╔██╗ ██║███████╗");
		System.out.println(
				"██║  ██║██║   ██║██║╚██╗██║██║   ██║██╔══╝  ██║   ██║██║╚██╗██║╚════██║    ██╔══██║██║╚██╗██║██║  ██║    ██║  ██║██╔══██╗██╔══██║██║   ██║██║   ██║██║╚██╗██║╚════██║");
		System.out.println(
				"██████╔╝╚██████╔╝██║ ╚████║╚██████╔╝███████╗╚██████╔╝██║ ╚████║███████║    ██║  ██║██║ ╚████║██████╔╝    ██████╔╝██║  ██║██║  ██║╚██████╔╝╚██████╔╝██║ ╚████║███████║");
		System.out.println(
				"╚═════╝  ╚═════╝ ╚═╝  ╚═══╝ ╚═════╝ ╚══════╝ ╚═════╝ ╚═╝  ╚═══╝╚══════╝    ╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝     ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═══╝╚══════╝");
		// Welcome Message
		System.out.println("\n\nWelcome to Dungeons & Dragons");

		System.out.println("\nYou are the Dungeon Master,\nPlease enter your kind name: ");
		String name = in.nextLine();

		System.out.println("\nWelcome, " + name
				+ "\nWe are giving you the powerful role of the Dungeon Master, with great power comes great responsibility...\nAre you up for the challenge?\n(1)Yes\n(2)No");
		int challenge = in.nextInt();

		while (challenge != 1 && challenge != 2) {
			System.out.println("Please answer correctly");
			challenge = in.nextInt();
		}

		if (challenge == 1) {
			System.out.println("GREAT!!");
			System.out.println("Every enemy defeat will give you one point.");
		} else if (challenge == 2) {
			System.out.println("Kindly go back from where you came...");
			System.exit(0);
		}

		// Starting the game
		System.out.println("\n!!!!BATTLE STARTS!!!!\n  GUARD THE DUNGEON\n\n");

		// Checking if player health is greater than 0
		while (p.isAlive()) {
			System.out.println("------------------------------------------");
			// Spawning a random enemy with a random attack and health
			Enemy opp = Enemy.spawnEnemy();
			System.out.println(opp + " appeared!");

			// Battle will run until enemy is alive
			while (opp.isAlive()) {
				System.out.println("Your health: " + p.health + " HP");
				System.out.println("Enemy health: " + opp.health + " HP");
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink Health Potion\t\t" + p.getPotions() + " left");
				System.out.println("\t3. Get More Health Potion\tPoints: " + p.getPoints());
				System.out.println("\t4. Run!");

				int choice = in.nextInt();

				// Making sure input is valid
				while (choice != 1 && choice != 2 && choice != 3) {
					System.out.println("Invalid command!");
					choice = in.nextInt();
				}

				// Attacking method
				if (choice == 1) {
					// When player attacks enemy, enemy attacks player simultaneously
					p.attackEnemy(opp);
					opp.getAttacked(p);
					// Checking to see if player is still alive
					if (p.isDying()) {
						// Thank you message
						System.out.println("You are too weak to battle, you exit the dungeon");
						System.out.println("Thank You Dungeon Master, the name " + name + " will always be remembered");
						System.out.println(
								"████████╗██╗  ██╗ █████╗ ███╗   ██╗██╗  ██╗███████╗    ███████╗ ██████╗ ██████╗     ██████╗ ██╗      █████╗ ██╗   ██╗██╗███╗   ██╗ ██████╗ ██╗");
						System.out.println(
								"╚══██╔══╝██║  ██║██╔══██╗████╗  ██║██║ ██╔╝██╔════╝    ██╔════╝██╔═══██╗██╔══██╗    ██╔══██╗██║     ██╔══██╗╚██╗ ██╔╝██║████╗  ██║██╔════╝ ██║");
						System.out.println(
								"   ██║   ███████║███████║██╔██╗ ██║█████╔╝ ███████╗    █████╗  ██║   ██║██████╔╝    ██████╔╝██║     ███████║ ╚████╔╝ ██║██╔██╗ ██║██║  ███╗██║");
						System.out.println(
								"   ██║   ██╔══██║██╔══██║██║╚██╗██║██╔═██╗ ╚════██║    ██╔══╝  ██║   ██║██╔══██╗    ██╔═══╝ ██║     ██╔══██║  ╚██╔╝  ██║██║╚██╗██║██║   ██║╚═╝");
						System.out.println(
								"   ██║   ██║  ██║██║  ██║██║ ╚████║██║  ██╗███████║    ██║     ╚██████╔╝██║  ██║    ██║     ███████╗██║  ██║   ██║   ██║██║ ╚████║╚██████╔╝██╗");
						System.out.println(
								"   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚══════╝    ╚═╝      ╚═════╝ ╚═╝  ╚═╝    ╚═╝     ╚══════╝╚═╝  ╚═╝   ╚═╝   ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝");

						System.exit(0);
					}
				}
				// Drinking potion method
				else if (choice == 2) {
					p.drinkPotion();
				}
				// Getting more potion
				else if (choice == 3) {
					p.getExtraPotion();
				}
				// Running away from enemy
				else if (choice == 4) {
					System.out.println("\t You run away from the " + opp + "!");
					continue;
				} else {
					System.out.println("Invalid command");
				}
			}
			p.defeat();
			// Checking to see if player is still alive
			if (p.isDying()) {
				System.out.println("You are too weak to battle, you exit the dungeon");
				// Thank you message
				System.out.println("Thank You Dungeon Master, the name " + name + " will always be remembered");
				System.out.println(
						"████████╗██╗  ██╗ █████╗ ███╗   ██╗██╗  ██╗███████╗    ███████╗ ██████╗ ██████╗     ██████╗ ██╗      █████╗ ██╗   ██╗██╗███╗   ██╗ ██████╗ ██╗");
				System.out.println(
						"╚══██╔══╝██║  ██║██╔══██╗████╗  ██║██║ ██╔╝██╔════╝    ██╔════╝██╔═══██╗██╔══██╗    ██╔══██╗██║     ██╔══██╗╚██╗ ██╔╝██║████╗  ██║██╔════╝ ██║");
				System.out.println(
						"   ██║   ███████║███████║██╔██╗ ██║█████╔╝ ███████╗    █████╗  ██║   ██║██████╔╝    ██████╔╝██║     ███████║ ╚████╔╝ ██║██╔██╗ ██║██║  ███╗██║");
				System.out.println(
						"   ██║   ██╔══██║██╔══██║██║╚██╗██║██╔═██╗ ╚════██║    ██╔══╝  ██║   ██║██╔══██╗    ██╔═══╝ ██║     ██╔══██║  ╚██╔╝  ██║██║╚██╗██║██║   ██║╚═╝");
				System.out.println(
						"   ██║   ██║  ██║██║  ██║██║ ╚████║██║  ██╗███████║    ██║     ╚██████╔╝██║  ██║    ██║     ███████╗██║  ██║   ██║   ██║██║ ╚████║╚██████╔╝██╗");
				System.out.println(
						"   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚══════╝    ╚═╝      ╚═════╝ ╚═╝  ╚═╝    ╚═╝     ╚══════╝╚═╝  ╚═╝   ╚═╝   ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝");

				System.exit(0);
			}
			// What happens if one enemy is defeated
			System.out.println("------------------------------------------");
			System.out.println("What would you like to do now?");
			System.out.println("1. Continue fighting");
			System.out.println("2. Exit dungeon");

			int choice2 = in.nextInt();

			// Making sure input is valid
			while (choice2 != 1 && choice2 != 2) {
				System.out.println("Invalid command!");
				choice2 = in.nextInt();
			}
			if (choice2 == 1) {
				System.out.println("Good luck on your adventure!");
			} else if (choice2 == 2) {
				System.out.println("You exited the dungeon successfully");
				System.out.println(
						"████████╗██╗  ██╗ █████╗ ███╗   ██╗██╗  ██╗███████╗    ███████╗ ██████╗ ██████╗     ██████╗ ██╗      █████╗ ██╗   ██╗██╗███╗   ██╗ ██████╗ ██╗");
				System.out.println(
						"╚══██╔══╝██║  ██║██╔══██╗████╗  ██║██║ ██╔╝██╔════╝    ██╔════╝██╔═══██╗██╔══██╗    ██╔══██╗██║     ██╔══██╗╚██╗ ██╔╝██║████╗  ██║██╔════╝ ██║");
				System.out.println(
						"   ██║   ███████║███████║██╔██╗ ██║█████╔╝ ███████╗    █████╗  ██║   ██║██████╔╝    ██████╔╝██║     ███████║ ╚████╔╝ ██║██╔██╗ ██║██║  ███╗██║");
				System.out.println(
						"   ██║   ██╔══██║██╔══██║██║╚██╗██║██╔═██╗ ╚════██║    ██╔══╝  ██║   ██║██╔══██╗    ██╔═══╝ ██║     ██╔══██║  ╚██╔╝  ██║██║╚██╗██║██║   ██║╚═╝");
				System.out.println(
						"   ██║   ██║  ██║██║  ██║██║ ╚████║██║  ██╗███████║    ██║     ╚██████╔╝██║  ██║    ██║     ███████╗██║  ██║   ██║   ██║██║ ╚████║╚██████╔╝██╗");
				System.out.println(
						"   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚══════╝    ╚═╝      ╚═════╝ ╚═╝  ╚═╝    ╚═╝     ╚══════╝╚═╝  ╚═╝   ╚═╝   ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝");

				System.exit(0);
			}

		}
		in.close();
	}
}
