package javasim; //package

import java.util.HashMap; //stores key and value into put() and retrieves values using get() method
import java.util.Scanner; //user input, can type in Strings and ints
import java.util.Random; //generates random numbers
import java.util.concurrent.TimeUnit; //delay the print ln, sleeps a few seconds

public class Pokemon { //class
	
	static Scanner input = new Scanner(System.in); //scanner is shared between all instances of the class
	
	private static String[] pokemonName = {"Pikachu", "Bulbasaur", "Charmander", "Squirtle"};	 //names and data
	private static String[] strengths = {"electric, flying, and steel", "water and fairy", "bug, steel, grass, and ice", "ground, rock, and fire"};
	private static String[] weaknesses = {"ground", "flying, fire, psychic, and ice", "ground, rock, and water", "electric and grass"};
	private static String[] ability1 = {"lightning", "chlorophyll", "blaze", "torrent"};
	private static String[] ability2 = {"static", "overgrow", "solar", "rain dish"};
	private static int[] attack = {55, 49, 52, 48};
	private static int[] defense = {40, 49, 43, 65};
	private static int[] health = {35, 45, 39, 44};
	private static int[] speed = {90, 45, 65, 43}; //arrays

	private static int newHealth, enemyNewHealth; //private variables
	private static boolean run;
	
	public Pokemon() {} //default constructor
	
	public Pokemon(String[] pokemonName, String[] strengths, String[] weaknesses, String[] ability1, String[] ability2, 
				  int[] attack, int[] defense, int[] health, int[] speed, int newHealth, int enemyNewHealth, boolean run) {
		
		Pokemon.pokemonName = pokemonName; //initialize variables
		Pokemon.strengths = strengths;
		Pokemon.weaknesses = weaknesses;
		Pokemon.ability1 = ability1;
		Pokemon.ability2 = ability2;
		Pokemon.attack = attack;
		Pokemon.defense = defense;
		Pokemon.health = health;
		Pokemon.speed = speed;
		Pokemon.newHealth = newHealth;
		Pokemon.enemyNewHealth = enemyNewHealth; 
		Pokemon.setRun(run); }

	public static void main(String[] args) throws InterruptedException {
		Pokemon game = new Pokemon(); //create new game
		
		HashMap<String, Integer> hmap_health = new HashMap<String, Integer>();
		hmap_health.put("Pikachu health: ", 35); //adds elements to HashMap, (key, value)
		hmap_health.put("Bulbasaur health: ", 45); 
		hmap_health.put("Charmander health: ", 39);
		hmap_health.put("Charizard health: ", 78);
		
		while(setRun(true)) { //loop condition
		game.startGame(); //start game
	    	int pokemon = input.nextInt(); //reader chooses number from 1-4
	        	if (pokemon == 1) {
	        		System.out.println("You chose " + pokemonName[0] + "! :) \n"); //prints pokemon's name and data
	        		TimeUnit.SECONDS.sleep(1);
	        		System.out.println("Strengths: " + strengths[0]); //pokemon types that it can win against
	        		TimeUnit.SECONDS.sleep(1);
	        		System.out.println("Weaknesses: " + weaknesses[0]); //pokemon types that it may or may not win against
	        		TimeUnit.SECONDS.sleep(1);
	        		System.out.println("Abilities: " + ability1[0] + " and " + ability2[0] + "\n"); 
	        		TimeUnit.SECONDS.sleep(1);
	        		System.out.println("Get ready to face...");
	        		TimeUnit.SECONDS.sleep(2);
	        		
	        		Random number = new Random(); //calls random number for battle from 1-3
	    		    int battle = number.nextInt(3) + 1;
	    		    
	            		if (battle == 1) { 
	            			System.out.println(pokemonName[1] + "! ;(( \n");
	            			game.continueGame(); //continue game
	            			game.battlefield(pokemonName[0], pokemonName[1], ability1[0], ability2[0], ability1[1], ability2[1], 
	            					attack[0], attack[1], defense[0], defense[1], health[0], health[1]); //actions in game
	            			
	            			game.determineWinner(attack[0], attack[1], defense[0], defense[1], health[0], health[1]); //winner between two Pokemon
	            			System.out.println("Would you like to play again?");
	                 		System.out.println("Press 0 to restart or 1 to exit the game.");
	            			int restart = input.nextInt(); //restart game
	                		if (restart == 0) { continue; } //goes in a loop til false
	                			System.out.println("Thank you for playing! Hope to see you again! (x o x) "); 
	                			System.exit(0); } //exit game
	        	
	            		else if (battle == 2) {
	            			System.out.println(pokemonName[2] + "! ;(( \n");
	            			game.continueGame(); 
	            			game.battlefield(pokemonName[0], pokemonName[2], ability1[0], ability2[0], ability1[2], ability2[2], 
	            					attack[0], attack[2], defense[0], defense[2], health[0], health[2]);
	            			
	            			game.determineWinner(attack[0], attack[2], defense[0], defense[2], health[0], health[2]);
	            			System.out.println("Would you like to play again?");
	                 		System.out.println("Press 0 to restart or 1 to exit the game.");
	            			int restart = input.nextInt(); 
	                		if (restart == 0) { continue; }
	                			System.out.println("Thank you for playing! Hope to see you again! (x o x) "); 
	                			System.exit(0); } //exit game
	            		
	            		else if (battle == 3) {
	            			System.out.println(pokemonName[3] + "! ;(( \n");
	            			game.continueGame(); 
	            			game.battlefield(pokemonName[0], pokemonName[3], ability1[0], ability2[0], ability1[3], ability2[3], 
	            					attack[0], attack[3], defense[0], defense[3], health[0], health[3]);
	            			
	            			game.determineWinner(attack[0], attack[3], defense[0], defense[3], health[0], health[3]);
	            			System.out.println("Would you like to play again?");
	                 		System.out.println("Press 0 to restart or 1 to exit the game.");
	            			int restart = input.nextInt(); 
	                		if (restart == 0) { continue; }
	                			System.out.println("Thank you for playing! Hope to see you again! (x o x) "); 
	                			System.exit(0); }} //exit game
	        
	        if (pokemon == 2) {
	        	System.out.println("You chose " + pokemonName[1] + "! :) \n");
	        	TimeUnit.SECONDS.sleep(1);
	    		System.out.println("Strengths: " + strengths[1]);
	    		TimeUnit.SECONDS.sleep(1);
	    		System.out.println("Weaknesses: " + weaknesses[1]);
	    		TimeUnit.SECONDS.sleep(1);
	    		System.out.println("Abilities: " + ability1[1] + " and "+ ability2[1] + "\n");
	    		TimeUnit.SECONDS.sleep(1);
	    		System.out.println("Get ready to face...");
	    		TimeUnit.SECONDS.sleep(2);
	        		
	        		Random number = new Random();
	        		int battle = number.nextInt(3) + 1;
	        		
	                if (battle == 1) {
	                		System.out.println(pokemonName[0] + "! ;(( \n");
	                		game.continueGame(); 
	                		game.battlefield(pokemonName[1], pokemonName[0], ability1[1], ability2[1], ability1[0], ability2[0], 
	            					attack[1], attack[0], defense[1], defense[0], health[1], health[0]);
	                		
	                		game.determineWinner(attack[1], attack[0], defense[1], defense[0], health[1], health[0]);
	                		System.out.println("Would you like to play again?");
	                 		System.out.println("Press 0 to restart or 1 to exit the game.");
	                		int restart = input.nextInt(); 
	                		if (restart == 0) { continue; }
	                			System.out.println("Thank you for playing! Hope to see you again! (x o x) "); 
	                			System.exit(0); } //exit game
	                
	                else if (battle == 2) {
	                		System.out.println(pokemonName[2] + "! ;(( \n");
	                		game.continueGame(); 
	                		game.battlefield(pokemonName[1], pokemonName[2], ability1[1], ability2[1], ability1[2], ability2[2], 
	            					attack[1], attack[2], defense[1], defense[2], health[1], health[2]);
	                		
	                		game.determineWinner(attack[1], attack[2], defense[1], defense[2], health[1], health[2]);
	                		System.out.println("Would you like to play again?");
	                 		System.out.println("Press 0 to restart or 1 to exit the game.");
	                		int restart = input.nextInt(); 
	                		if (restart == 0) { continue; }
	                			System.out.println("Thank you for playing! Hope to see you again! (x o x) "); 
	                			System.exit(0); } //exit game
	                
	                else if (battle == 3) {
	                		System.out.println(pokemonName[3] + "! ;(( \n");
	                		game.continueGame(); 
	                		game.battlefield(pokemonName[1], pokemonName[3], ability1[1], ability2[1], ability1[3], ability2[3], 
	            					attack[1], attack[3], defense[1], defense[3], health[1], health[3]);
	                		
	                		game.determineWinner(attack[1], attack[3], defense[1], defense[3], health[1], health[3]);
	                		System.out.println("Would you like to play again?");
	                 		System.out.println("Press 0 to restart or 1 to exit the game.");
	                		int restart = input.nextInt(); 
	                		if (restart == 0) { continue; }
	                			System.out.println("Thank you for playing! Hope to see you again! (x o x) "); 
	                			System.exit(0); }} //exit game
	     
	        else if (pokemon == 3) {
	        	System.out.println("You chose " + pokemonName[2] + "! :) \n");
	        	TimeUnit.SECONDS.sleep(1);
	    		System.out.println("Strengths: " + strengths[2]);
	    		TimeUnit.SECONDS.sleep(1);
	    		System.out.println("Weaknesses: " + weaknesses[2]);
	    		TimeUnit.SECONDS.sleep(1);
	    		System.out.println("Abilities: " + ability1[2] + " and "+ ability2[2] + "\n");
	    		TimeUnit.SECONDS.sleep(1);
	    		System.out.println("Get ready to face...");
	    		TimeUnit.SECONDS.sleep(2);
	        		
	        		Random number = new Random();
	        		int battle = number.nextInt(3) + 1;
	        		
	        			if (battle == 1) {
	                		System.out.println(pokemonName[0] + "! ;(( \n");
	                		game.continueGame(); 
	                		game.battlefield(pokemonName[2], pokemonName[0], ability1[2], ability2[2], ability1[0], ability2[0], 
	            					attack[2], attack[0], defense[2], defense[0], health[2], health[0]);
	                		
	                		game.determineWinner(attack[2], attack[0], defense[2], defense[0], health[2], health[0]);
	                		System.out.println("Would you like to play again?");
	                 		System.out.println("Press 0 to restart or 1 to exit the game.");
	                		int restart = input.nextInt(); 
	                		if (restart == 0) { continue; }
	                			System.out.println("Thank you for playing! Hope to see you again! (x o x) "); 
	                			System.exit(0); } //exit game
	        			
	                else if (battle == 2) {
	                		System.out.println(pokemonName[1] + "! ;(( \n");
	                		game.continueGame(); 
	                		game.battlefield(pokemonName[2], pokemonName[1], ability1[2], ability2[2], ability1[1], ability2[1], 
	            					attack[2], attack[1], defense[2], defense[1], health[2], health[1]);
	                		
	                		game.determineWinner(attack[2], attack[1], defense[2], defense[1], health[2], health[1]);
	                		System.out.println("Would you like to play again?");
	                 		System.out.println("Press 0 to restart or 1 to exit the game.");
	                		int restart = input.nextInt(); 
	                		if (restart == 0) { continue; }
	                			System.out.println("Thank you for playing! Hope to see you again! (x o x) "); 
	                			System.exit(0); } //exit game
	        			
	                else if (battle == 3) {
	                		System.out.println(pokemonName[3] + "! ;(( \n");
	                		game.continueGame(); 
	                		game.battlefield(pokemonName[2], pokemonName[3], ability1[2], ability2[2], ability1[3], ability2[3], 
	            					attack[2], attack[3], defense[2], defense[3], health[2], health[3]);
	                		
	                		game.determineWinner(attack[2], attack[3], defense[2], defense[3], health[2], health[3]);
	                		System.out.println("Would you like to play again?");
	                 		System.out.println("Press 0 to restart or 1 to exit the game.");
	                		int restart = input.nextInt(); 
	                		if (restart == 0) { continue; }
	                			System.out.println("Thank you for playing! Hope to see you again! (x o x) "); 
	                			System.exit(0); }} //exit game
	        
	        else if (pokemon == 4) {
	        	System.out.println("You chose " + pokemonName[3] + "! :) \n");
	        	TimeUnit.SECONDS.sleep(1);
	    		System.out.println("Strengths: " + strengths[3]);
	    		TimeUnit.SECONDS.sleep(1);
	    		System.out.println("Weaknesses: " + weaknesses[3]);
	    		TimeUnit.SECONDS.sleep(1);
	    		System.out.println("Abilities: " + ability1[3] + " and "+ ability2[3] + "\n");
	    		TimeUnit.SECONDS.sleep(1);
	    		System.out.println("Get ready to face...");
	    		TimeUnit.SECONDS.sleep(2);
	        		
	        		Random number = new Random();
	        		int battle = number.nextInt(3) + 1;
	        		
	                if (battle == 1) {
	                		System.out.println(pokemonName[0] + "! ;(( \n");
	                		game.continueGame(); 
	                		game.battlefield(pokemonName[3], pokemonName[0], ability1[3], ability2[3], ability1[0], ability2[0], 
	            					attack[3], attack[0], defense[3], defense[0], health[3], health[0]);
	                		
	                		game.determineWinner(attack[3], attack[0], defense[3], defense[0], health[3], health[0]);
	                		System.out.println("Would you like to play again?");
	                 		System.out.println("Press 0 to restart or 1 to exit the game.");
	                		int restart = input.nextInt(); 
	                		if (restart == 0) { continue; }
	                			System.out.println("Thank you for playing! Hope to see you again! (x o x) "); 
	                			System.exit(0); } //exit game
	                		
	                		
	                else if (battle == 2) {
	                		System.out.println(pokemonName[1] + "! ;(( \n");
	                		game.continueGame(); 
	                		game.battlefield(pokemonName[3], pokemonName[1], ability1[3], ability2[3], ability1[1], ability2[1], 
	            					attack[3], attack[1], defense[3], defense[1], health[3], health[1]);
	                		
	                		game.determineWinner(attack[3], attack[1], defense[3], defense[1], health[3], health[1]);
	                		System.out.println("Would you like to play again?");
	                 		System.out.println("Press 0 to restart or 1 to exit the game.");
	                		int restart = input.nextInt(); 
	                		if (restart == 0) { continue; }
	                			System.out.println("Thank you for playing! Hope to see you again! (x o x) "); 
	                			System.exit(0); } //exit game
	                
	                else if (battle == 3) {
	                		System.out.println(pokemonName[2] + "! ;(( \n");     
	                		game.continueGame(); 
	                		game.battlefield(pokemonName[3], pokemonName[2], ability1[3], ability2[3], ability1[2], ability2[2], 
	                				attack[3], attack[2], defense[3], defense[2], health[3], health[2]);
	                		
	                		game.determineWinner(attack[3], attack[2], defense[3], defense[2], health[3], health[2]);
	                		System.out.println("Would you like to play again?");
	                 		System.out.println("Press 0 to restart or 1 to exit the game.");
	                		int restart = input.nextInt(); 
	                		if (restart == 0) { continue; }
	                			System.out.println("Thank you for playing! Hope to see you again! (x o x) "); 
	                			System.exit(0); }} //exit game
			}
		}
	private void startGame() throws InterruptedException { //introduction to game and concept
		System.out.println("Welcome to the world of Pokémon! What is your name?");
	    String name = input.next(); //reads user input (name)
	    
	    System.out.println("Hello " + name + "! My name is Uriah and people call me the Pokémon Prof! ;) \n"); 
	    TimeUnit.SECONDS.sleep(2);
	    System.out.println("You might be wondering, what are Pokémon? Well " + name + ", Pokémon is short for pocket monsters.\n"); 
	    TimeUnit.SECONDS.sleep(3);
	    System.out.println("There are several categories of Pokémon which have advantages and disadvantages when battling other types.\n");
	    TimeUnit.SECONDS.sleep(3);
	    System.out.println("Each creature possesses a different set of abilities. Now, are you ready to choose your Pokémon and fight? (* 0 *) \n");
	    TimeUnit.SECONDS.sleep(1);
	    System.out.println("Please press 0 to begin.");
	    
	    int start = input.nextInt(); //reads user input (0)
	    if (start == 0) {
	    	
			System.out.println("Choose your pokemon! (> v <) \n"); //I included keyboard facesafor decoration
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Press 1 for Pikachu         Press 2 for Bulbasaur\n");
	      	System.out.println("Attack      55              Attack      49"); //Pokemon data
	        System.out.println("Defense     40              Defense     49");
	        System.out.println("Health      35              Health      45");
	        System.out.println("Speed       90              Speed       45\n");
	
	        System.out.println("Press 3 for Charmander      Press 4 for Squirtle\n");
	        System.out.println("Attack      52              Attack      48");
	        System.out.println("Defense     43              Defense     65");
	        System.out.println("Health      39              Health      44");       
	        System.out.println("Speed       65              Speed       43\n"); }}
	
 	private void continueGame() { 
		System.out.println("Press any key to start your match.");
	    try { System.in.read(); }  //reads user input (key)
	    catch (Exception a) {}}
 	
 	private void battlefield(String me, String enemy, String ability1, String ability2, String enemyAbility1, String enemyAbility2, 
 							int attack, int enemyAttack, int defense, int enemyDefense, int health, int enemyHealth) throws InterruptedException {
 		
 		System.out.println(me + " sees " + enemy + " across the field. (^ . ^) \n"); //game action
 		TimeUnit.SECONDS.sleep(2);
 		System.out.println("What should " + me + " do?");
 		TimeUnit.SECONDS.sleep(2);
 		System.out.println("Choose an ability: " + ability1 + " or " + ability2);
 		String ability = input.next(); //reads user input (ability)
 		System.out.println(me + " used " + ability + "! (n _ n) \n");
 		
 		System.out.println("----------------------------------------------------\n");
 		System.out.println("Darn it! " + enemy + " used their speed and dodged " + me + "'s " + "attack. (> _ <) ");
 		System.out.println("Quick! Take cover!\n");
 		TimeUnit.SECONDS.sleep(2);
 		
 		System.out.println("----------------------------------------------------\n");
 		System.out.println("Oh no! " + enemy + " used " + enemyAbility1 + "!");
 		TimeUnit.SECONDS.sleep(3);
 		System.out.println("Luckily, " + me + " was fast enough to hide. (o _ o) \n");
 		TimeUnit.SECONDS.sleep(3);
 		
 		System.out.println("Fire back! Do you want to use " + ability1 + " or "  + ability2 + "?");
 		String _ability = input.next(); 
 		System.out.println(me + " used " + _ability + "!\n");
 		TimeUnit.SECONDS.sleep(3);
 		
 		System.out.println("----------------------------------------------------\n");
 		System.out.println(enemy + " got hit! XD ");
 		enemyNewHealth = enemyHealth - attack + enemyDefense; //determines enemy's new health by subtracting attack and adding it's defense
 		
 		System.out.println("Run before " + enemy + " attacks again! ");
 		TimeUnit.SECONDS.sleep(3);
 		System.out.println(enemy + " used " + enemyAbility2 + "! (; _ ;) \n");
 		TimeUnit.SECONDS.sleep(2);
 		
 		System.out.println("----------------------------------------------------\n");
 		System.out.println(me + " used it's defense and fought back! (~ v ~) ");
 		TimeUnit.SECONDS.sleep(2);
 		
 		System.out.println(enemy + " is regaining strength. You must attack now before it is too late.");
 		TimeUnit.SECONDS.sleep(1);
 		System.out.println("Would you like to use your special ability? Type in a special ability.");
 		String specialAbility = input.next(); 
 		TimeUnit.SECONDS.sleep(2);
 		System.out.println(me + " used " + specialAbility + "! (. o . ') \n");
 		TimeUnit.SECONDS.sleep(3);
 		
 		System.out.println("----------------------------------------------------\n");
 		System.out.println("But " + enemy + "'s " + enemyAbility1 + " cuts " + me + "'s " + specialAbility + "! :(( ");
 		TimeUnit.SECONDS.sleep(2);
 		System.out.println(enemy + " fires back with " + enemyAbility2 + "!\n");
 		TimeUnit.SECONDS.sleep(2);
 		
 		System.out.println("----------------------------------------------------\n");
 		System.out.println(me + " could not outrun the attack and got injured. (; o ;) ");
 		TimeUnit.SECONDS.sleep(4);
 	 	newHealth = health - enemyAttack + defense; //determines new health by subtracting enemy's attack and adding it's defense
 	 	
 	 	System.out.println(me + " is regaining strength. But " + enemy + " is getting ready to attack! (. _ .) \n");
 	 	TimeUnit.SECONDS.sleep(2);
 	 		
 	 	System.out.println("----------------------------------------------------\n");
 	 	System.out.println("Use your hidden ability now! (@ _ @) ");
 	 	TimeUnit.SECONDS.sleep(2);
 	 	String hiddenAbility = input.next();
 	 	System.out.println(me + " fought " + enemy + "'s attack and unleashed " + hiddenAbility + "! (* - *) \n");
 	 	TimeUnit.SECONDS.sleep(3);
 	 	System.out.println("*GRRRRRR* Attack now to finish " + enemy + " off. Choose an ability: " + ability1 + " or " + ability2);
 	 	TimeUnit.SECONDS.sleep(2);
 	 	String _attack1 = input.next();
 	 	System.out.println(me + " used " + _attack1 + "! (^ - ^) ");
 	 	TimeUnit.SECONDS.sleep(1);
 	 	System.out.println("But wait! " + enemy + " attacked back! (= _ =) \n");
 	 	TimeUnit.SECONDS.sleep(3);
 	 	
 	 	System.out.println("----------------------------------------------------\n");
 	 	System.out.println("Foe " + enemy + " and " + me + " are paralyzed and unable to move. (o _ o) ");
 	 	TimeUnit.SECONDS.sleep(1);
 	 	System.out.println("Too much damage has been taken!");
 	 	TimeUnit.SECONDS.sleep(2);
		System.out.println("Game Over. (* ^ *) \n"); }
 	 		
	private void determineWinner(int attack, int enemyAttack, int defense, int enemyDefense, int health, int enemyHealth) {
		newHealth = health - enemyAttack + defense;
		enemyNewHealth = enemyHealth - attack + enemyDefense;
		System.out.println("----------------------------------------------------\n");
		if (newHealth > 0 && newHealth > enemyNewHealth) { System.out.println("You won! (* o *) \n"); } 
			else { System.out.println("You lost! 8(> _ <)8 \n"); }} 	
		
 	public static int[] getSpeed() { return speed; }
	public static void setSpeed(int[] speed) { Pokemon.speed = speed; }

	public static boolean isRun() { return run; }
	public static boolean setRun(boolean run) { Pokemon.run = run;
												return run; }
	
}









