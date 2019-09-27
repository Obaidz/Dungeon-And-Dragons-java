
import java.util.*;
import java.io.*;
import java.util.Random;
class game {
	public static void main(String[] args) {	
	values();
   
	}
	
	
	public static void values() {
	
	Scanner L = new Scanner(System.in);
	Random R = new Random(); 
	int PH = R.nextInt(250)+ 130; int PA = R.nextInt(50)+ 25; int PD = R.nextInt(50)+ 25; int PI = 0; //Making Random values for player
	System.out.print("Enter your Name: ");
	String N = L.nextLine();
	
	
	PrintWriter File;
	System.out.print("Enter File Name For Game Log: ");
	String file = L.nextLine();
	file = file + ".txt";
		
	character kb1 = new character(N , PH, PA, PD, PI); // Calling Object and assigning random values
	
	
	System.out.println("Pick game setting, enter 1 for easy, 2 for medium and 3 for hard and 'Q' to quit game");
	String gamemode = L.nextLine();
	int r = 0;
	int[] dungeon = new int [r]; // Making Dungeon.
	
	
	try {
	File = new PrintWriter(new FileWriter(file,true));	
	if (gamemode.equals("1")) {
		r = R.nextInt(4)+3;
		dungeon = new int [r];  //Populating Dungeon. (Low)  Range starts from 3 -6
		System.out.println(Arrays.toString(dungeon));
		System.out.println("Total Number of Rooms Are: " + dungeon.length);
		File.println("Total Number of Rooms Are: " + dungeon.length);
	}
	else if (gamemode.equals("2")) {
		r = R.nextInt(5)+7;	//Populating Dungeon. (med)  starts from 7 - 11
		dungeon = new int [r];
		System.out.println(Arrays.toString(dungeon));
		System.out.println("Total Number of Rooms Are: " + dungeon.length);
		File.println("Total Number of Rooms Are: " + dungeon.length);
	}
	else if (gamemode.equals("3")) {
		r = R.nextInt(9)+12;	//Populating Dungeon.(High) starts from 12 - 20
		dungeon = new int [r];
		System.out.println(Arrays.toString(dungeon));
		System.out.println("Total Number of Rooms Are: " + dungeon.length);
		File.println("Total Number of Rooms Are: " + dungeon.length);
	}
	else if (gamemode.equals("Q")){
		System.exit(0);	//Quitting state at any point
	}
	else if (!gamemode.equals("1") || !gamemode.equals("2") || !gamemode.equals("3") || !gamemode.equals("Q") ){
		System.out.println("Not a game option, choose again or press 'Q' to exit");
		gamemode = L.nextLine();
	}
	
	
	
	String[] EnemiesNames = {"Temo" , "Chukie", "Nugget", "Londa", "Sleldon"}; //Names for enemies
	String name = kb1.getname();
	File.println();
	File.println("Name of player " + name);
	int Attack = kb1.getattackvalue();  //Calling values from obeject.
	int defence = kb1.getdefencevalue();
	int health = kb1.gethealthvalue();
	int item = kb1.getitems();
	System.out.println();
	
	System.out.println(name + " Attack value: "+ Attack);
	System.out.println(name + " Defence Value: "+ defence );
	
	
	int[] playervalues = {health, item, 0}; // Here 0 represents Score of the player.
	
	
	
	
	
	for (int i = 0 ; i < dungeon.length; i++) { // Dungeon
		
		int Enemies = R.nextInt(4) + 1;
		
		int score = playervalues[2];

		if ( i > 0 ) {
			System.out.println();
			System.out.println(               "                   #############");
			System.out.println(               "                   :           :");
			System.out.println(               "                   : Next Room :");
			System.out.println(               "                   :   Room    :");
			System.out.println(               "                   :    "+(i+1)+"      :");
			System.out.println(               "                   :           :");
			System.out.println(               "                   #############");
			System.out.println();
		}
		
		
	
		while (Enemies > 0) {  //Room
		
		int EH = R.nextInt(60)+ 45; int EA = R.nextInt(35)+ 15; int ED = R.nextInt(35)+ 15;  // Making Random Values foR enemies
		character kb2 = new character("goblin" , EH, EA, ED, 0); // Enemies have 0 items on them.
		
		String goblin = kb2.getname();
		int gAttack = kb2.getattackvalue();
		int gdefence = kb2.getdefencevalue();
		int ghealth = kb2.gethealthvalue();

		
		health = playervalues[0]; //Storing values for next iteretions.
		item = playervalues[1];
		System.out.println(name +" health value: " + health);
		File.println(name +" health value: " + health);
		System.out.println(name +" items: "+ item);
		File.println(name +" items: "+ item);
		
		System.out.println();
		goblin = kb2.getname();
		gAttack = kb2.getattackvalue();
		gdefence = kb2.getdefencevalue();
		ghealth = kb2.gethealthvalue();
		System.out.println("Enemy Info...");
		System.out.println("Name: " + EnemiesNames[(Enemies-1)]);
		File.println();
		File.println("Enemy Info...");
		File.println("Name: " + EnemiesNames[(Enemies-1)]);
		System.out.println("Attack value: "+ gAttack);
		File.println("Attack value: "+ gAttack);
		System.out.println("Defence Value: "+ gdefence );
		File.println("Defence Value: "+ gdefence );
		System.out.println("health value: " + ghealth);
		File.println("health value: " + ghealth);
		System.out.println();
		System.out.println("Total Number of Enemies in the Room "+ (i+1) + " left Are: " + Enemies);
		File.println("Total Number of Enemies in the Room "+ (i+1) + " Are: " + Enemies);
		
        
		
		
		while ( health >0 || ghealth > 0 ) { //Enemy
			
			System.out.println();
			System.out.println("Press Enter to Play " + name);
			System.out.println();
			System.out.println();
			System.out.println();
			File.println();
			File.println();
			File.println();
			String e = L.nextLine();
			
			if ( e.equals("")) {
			   Random rand = new Random();
				
			   Attack = rand.nextInt(PA) + 1;
			   gAttack = rand.nextInt(EA) + 1;
			   defence = rand.nextInt(PD)+ 1;
			   gdefence = rand.nextInt(ED)+ 1;
			   // obaid attacking
			 
			if ( Attack > gdefence) { //Player Attack
				
				System.out.println("The "+ name  + " hit " + EnemiesNames[(Enemies-1)]);
				File.println("The "+ name  + " hit " + EnemiesNames[(Enemies-1)]);
				int damage = Attack- gdefence;
				score = damage;
				System.out.println("Damaged done: " + damage);
				File.println("Damaged done: " + damage);
				System.out.println("Score gain: " + score);
				File.println("Score gain: " + score);
				playervalues[2] = playervalues[2] + score;
				ghealth = ghealth-damage;
				System.out.println("health of " + EnemiesNames[(Enemies-1)] + " is: " + ghealth);
				File.println("The "+ name  + " hit " + EnemiesNames[(Enemies-1)]);
				System.out.println();
				File.println();
				
			}
			else {
				System.out.println(name + " Attack missed");
				File.println(name + " Attack missed");
				System.out.println();
				File.println();
			}
			// goblin attack
			
			if ( gAttack > defence) {
				System.out.println("The "+ EnemiesNames[(Enemies-1)]  + " hit " + name);
				File.println("The "+ EnemiesNames[(Enemies-1)]  + " hit " + name);
				int damage = gAttack - defence;
				health = health-damage;
				System.out.println("Damaged done: " + damage);
				File.println("Damaged done: " + damage);
				System.out.println("health of " + name + " is: " + health);
				File.println("health of " + name + " is: " + health);
				System.out.println();
				File.println();
				
			}
			else {
				System.out.println(EnemiesNames[(Enemies-1)] + " Attack missed");
				File.println(EnemiesNames[(Enemies-1)] + " Attack missed");
			}
			System.out.println();
			
			System.out.println(name+ "'s Total score is: " + playervalues[2] );
			System.out.println();
			System.out.println();
			System.out.println();
			File.println();
			File.println();
			File.println();
			int RandomPickup = R.nextInt(58) + 1;
			items kb3 = new items(10 , 40, 15, 40, 15, 40,playervalues[2]); // Using Object for items
			score (kb3, kb1, playervalues); //Method for Showing Scores.
			if (health <= 0 ) {
				System.out.println(name + " lost the game against " + EnemiesNames[(Enemies-1)] + ". " + EnemiesNames[(Enemies-1)] + " Wins");
				File.println(name + " lost the game against " + EnemiesNames[(Enemies-1)] + ". " + EnemiesNames[(Enemies-1)] + " Wins");
				System.out.println(name+ "'s Total score is: " + playervalues[2] );
				File.println(name+ "'s score Total is: " + playervalues[2] );
				System.exit(0);
			}	
			else if (ghealth <= 0 ) { 
				System.out.println(EnemiesNames[(Enemies-1)] + " Loses ");
				File.println(EnemiesNames[(Enemies-1)] + " Loses ");
				System.out.println( name + " Wins");
				File.println( name + " Wins");
				System.out.println(name+ "'s Current score for this room is: " + playervalues[2]);
				File.println(name+ "'s Current score for this room is: " + playervalues[2] );
				System.out.println("--------------------------");	
				File.println("--------------------------");
				System.out.println();
				File.println();
				int Helmet = kb3.getHelmet();  //Using Items when enemy dies.
				int Armour = kb3.getArmour();
				int Stick =  kb3.getStick();
				int Sword =  kb3.getSword();
				int Potion = kb3.getPotion();
				int DragonSeed = kb3.getDragonSeed();
				int healthpickup = 0;
				int attackpickup = 0;
				int defencepickup = 0;
				if(playervalues[1] < 3) {
				if (RandomPickup > 0  && RandomPickup < 16 ) {  // Using Random as a percentage for items.
					System.out.println("You gained Potion for Health gain");
					File.println("You gained Potion for Health gain");
					System.out.println("Previous health Value: "+ health);
					File.println("Previous health Value: "+ health);
					health = health + Potion;
					System.out.println("New health Value: "+ health);
					File.println("New health Value: "+ health);
				}
				if (RandomPickup > 15 && RandomPickup < 19 ) {
					if (healthpickup > 0) {
						System.out.println("Already Have this Item");
					}	
					else {
					System.out.println("You gained DragonSeed (Health 40+)");
					File.println("You gained DragonSeed (Health 40+)");
					System.out.println("Previous health Value: "+ health);
					File.println("Previous health Value: "+ health);
					health = health + DragonSeed;
					System.out.println("New Health Value: "+ health);
					File.println("New Health Value: "+ health);
					healthpickup = healthpickup + 1;
					}
				}
				if(RandomPickup > 18 && RandomPickup < 24 ) {
					if (attackpickup == 1) {
						System.out.println("Already Have this Item");
					}
					else {
					System.out.println("You gained Stick For Attack");
					File.println("You gained Stick For Attack");
					System.out.println("Previous Attack Value: "+ PA);
					File.println("Previous Attack Value: "+ PA);
					PA = PA + Stick;
					System.out.println("New Attack Value: "+ PA);
					File.println("New Attack Value: "+ PA);
					attackpickup = attackpickup + 1;
					}
				}
				
				if(RandomPickup > 23 && RandomPickup < 29 ) { 
					if ( attackpickup == 1) {
						PA = PA - Stick;
						System.out.println("Dropping Stick to gain Sword");
						attackpickup = attackpickup - 1;
					}						
					System.out.println("You gained Sword For Attack");
					File.println("You gained Sword For Attack");
					System.out.println("Previous Attack Value: "+ PA);
					File.println("Previous Attack Value: "+ PA);
					PA = PA + Sword;
					System.out.println("New Attack Value: "+ PA);
					File.println("New Attack Value: "+ PA);
					attackpickup = attackpickup + 1;
				}
				if(RandomPickup > 28 && RandomPickup < 37 ) {
					if (defencepickup == 1) {
						System.out.println("Already Have this Item");
					}
					else {
					System.out.println("You gained Tin Helmet");
					File.println("You gained Tin Helmet");
					System.out.println("Previous defence Value: "+ PD);
					File.println("Previous defence Value: "+ PD);
					PD = PD + Helmet;
					System.out.println("New defence Value: "+ PD);
					File.println("New defence Value: "+ PD);
					defencepickup = defencepickup + 1;
					}
				}
				if(RandomPickup > 36 && RandomPickup < 43 ) {
					if ( defencepickup == 1) {
						PD = PD - Helmet;
						System.out.println("Dropping Helmet to gain Armour");
						defencepickup = defencepickup - 1;
					}
					System.out.println("You gained Body armour");
					File.println("You gained Tin Body Armour");
					System.out.println("Previous defence Value: "+ PD);
					File.println("Previous defence Value: "+ PD);
					PD = PD + Armour;
					System.out.println("New defence Value: "+ PD);
					File.println("New defence Value: "+ PD);
					defencepickup = defencepickup + 1;
				}
				if(RandomPickup > 42 && RandomPickup < 59 ) {
					System.out.println("You gained Nothing");
					File.println("You gained Nothing");
				}
				playervalues[1] = playervalues[1] + attackpickup + healthpickup + defencepickup;
				}
				else if (playervalues[1] >= 3 && Enemies > 0 ) {
					System.out.println("Already Have 3 items");
					File.println("Already Have 3 items");
				}
				
				break;
			} 
			
			}
			else if ( e.equals("Q")) {
				System.out.println("Quitting...");
				System.exit(0);
			}
			else {
				System.out.println("Wrong Menu Option, Press Enter to Play Q to Quit");
			}
				
				playervalues[0] = health;  //Saving Player values for next iterations.
				playervalues[1] = item;	
				
			}
			Enemies--;	
		}
		
		if ( i == dungeon.length-1 && Enemies == 0){
			Won(kb1, playervalues);		
		}
	}
	File.close();
	
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	
	
	
}
	public static void score (items kb3, character kb1, int[] playervalues) {
		
	PrintWriter pw ;
	int score = playervalues[2];
	String name = kb1.getname();
	
	try {
		int[] highscores = new int[4];
		pw = new PrintWriter("Highscore.txt");
		for (int x = 0;  x < highscores.length; x++) {
		if (score > highscores[x]) {
			highscores[0] = score;
			pw.println("highscore of " + name + " is: " + highscores[0]);
			break;
		}
		else if (score > highscores[x]) {
			highscores[1] = score;
			pw.println("highscore of " + name + " is: " + highscores[1]);
			break;
		}
		else if (score > highscores[x]) {
			highscores[2] = score;
			pw.println("highscore of " + name + " is: " + highscores[2]);
			break;
		}
		else if (score > highscores[x]) {
			highscores[3] = score;
			pw.println("highscore of " + name + " is: " + highscores[3]);
			break;
		}
		else if (score > highscores[x]) {
			highscores[4] = score;
			pw.println("highscore of " + name + " is: " + highscores[4]);
			break;
		}
		}
	pw.close();
	}
	
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	}
	
	public static void Won(character kb1, int[] playervalues) {          //On Win Method USING ASCII CODES.
		int score = playervalues[2];
		String name = kb1.getname();
		System.out.println();
		System.out.println("		/*************************************************************************************************************************************/");
		System.out.println("		/*               db   d8b   db                                                                                                       */");
		System.out.println("		/*               88   I8I   88                                                                                                       */");
		System.out.println("		/*               88   I8I   88                                                                                                       */");
		System.out.println("		/*               Y8   I8I   88                                                                                                       */");
		System.out.println("		/*               `8b d8'8b d8'                                                                                                       */");
		System.out.println("		/*                `8b8' `8d8'                                                                                                        */");
		System.out.println("                /*                                                                                                                                */");
		System.out.println("		/*                 d888888b                                                                                                          */");
		System.out.println("		/*                   `88'                                                                                                            */");
		System.out.println("		/*                    88                                                                                                             */");
		System.out.println("		/*                    88                                                                                                             */");
		System.out.println("		/*                   .88.                                                                                                            */");
		System.out.println("		/*                 Y888888P                                                                                                          */");
		System.out.println("                /*                              	                    0    .-^^^-.                                                            */");
		System.out.println("		/*                 d8b   db                               ooo   / .===. \\      0                                                     */");
		System.out.println("		/*                 888o  88                               \\ \\   \\/ 6 6 \\/    ooo                                                     */");
		System.out.println("		/*                 88V8o 88                                \\ \\  (  ***  )   / /                                                   */");
		System.out.println("		/*                 88 V8o88                                 \\ \\  \\_***_/   / /                                                      */");
		System.out.println("		/*                 88  V888                                  \\ \\  _| |_   / /                                                      */");
		System.out.println("		/*                 VP   V8P                                   \\ \\/     \\_/ /                                                      */");
		System.out.println("                /*                                    		               \\_   I    _/                                                     */");
		System.out.println("		/*                 d8b   db                                      |  AM  |                                                            */");
		System.out.println("		/*                 888o  88                                      |Winner|                                                            */");
		System.out.println("		/*                 88V8o 88                                      \\______/                                                           */");
		System.out.println("		/*                 88 V8o88                                        |_|_|                                                             */");
		System.out.println("		/*                 88  V888                                        |_|_|                                                             */");
		System.out.println("		/*                 VP   V8P                                        |_|_|                                                             */");
		System.out.println("                /*                                     				   |_|_|                                                                 */");
		System.out.println("		/*                 d88888b                                         /-Y-\\                                                            */");
		System.out.println("		/*                 88'                                           ((_/\\_))                                                           */");
		System.out.println("		/*                 88ooooo                                                                                                           */");
		System.out.println("		/*                 88~~~~~                                   "+name+"                                                                */");
		System.out.println("		/*                 88.                                       SCORE:"+playervalues[2]+"                                               */");
		System.out.println("		/*                 Y88888P                                                                                                           */");
		System.out.println("                /*                                                                                                                           */");
		System.out.println("		/*                 d8888b.                                                                                                           */");
		System.out.println("		/*                 88  `8D                                                                                                           */");
		System.out.println("		/*                 88oobY'                                                                                                           */");
		System.out.println("		/*                 88`8b                                                                                                             */");
		System.out.println("		/*                 88 `88.                                                                                                           */");                                      
		System.out.println("		/*************************************************************************************************************************************/");	
																							
 }
	


}