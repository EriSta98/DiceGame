package se.jensen.erik.dicegame;



import java.util.Scanner;

public class Game {
    // Behöver göra  av någon anledning?
    Scanner scanner = new Scanner(System.in);
    DiceRoll diceRoll = new DiceRoll();

    // Skicka in player objekten så att vi kan använda dom här
    Player player1 = new Player();
    Player player2 = new Player();

    private int roundNumber = 0;


    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        // Text meny
        System.out.println("Welcome to the Dice Game");
        System.out.println();
        System.out.println("Press 1 to Play");
        System.out.println("Press 2 to quit");
        int choice = scanner.nextInt();


        // Hantera användarens svar
        if (choice == 1) {
            scanner.nextLine();
            askForName();
            playGameLoop();
        } else if (choice == 2) {
            System.out.println("Thanks for playing!");
            scanner.close();
            System.exit(0);
        }
    }


    public void askForName() {
        boolean valid;

        // Loop för att hantera felaktig inmatning av förnamn på spelare 1
        valid = false;
        while (!valid) {
            try {
                System.out.println("\nPlayer number 1, what is your first name?");
                String input = scanner.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("First name cannot be null or empty. Enter a valid first name");
                }
                player1.setFirstName(input);
                valid = true;  // skriver personen korrekt namn så blir valid true och vi lämnar loopen
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Meddelandet i throw skrivs ut av e.getMessage
            }
        }

        // Loop för att hantera felaktig inmatning av efternamn på spelare 1
        valid = false;
        while (!valid) {
            try {
                System.out.println("\nAnd what is your last name?");
                String input = scanner.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Last name cannot be null or empty. Enter a valid first name");
                }
                player1.setLastName(input);
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Loop för att hantera felaktig inmatning av förnamn på spelare 2
        valid = false;
        while (!valid) {
            try {
                System.out.println("\nPlayer number 2, what is your first name?");
                String input = scanner.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("First name cannot be null or empty. Enter a valid first name");
                }
                player2.setFirstName(input);
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Loop för att hantera felaktig inmatning av efternamn på spelare 2
        valid = false;
        while (!valid) {
            try {
                System.out.println("\nAnd what is your last name?");
                String input = scanner.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Last name cannot be null or empty. Enter a valid first name");
                }
                player2.setLastName(input);
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public void playGameLoop() {
        boolean keepPlaying = true;

        while (keepPlaying) {
            roundNumber++;
            System.out.println("\n========== Round " + roundNumber + " ===========");

            playRound(player1, player2);




            System.out.println("\nRound result:");
            System.out.println(player1.getFullName() + " Has won: " + player1.getRoundsWon());
            System.out.println(player2.getFullName() + " Has won: " + player2.getRoundsWon());

            System.out.println("\nDo you want to play another round? (1 = Yes, 2 = No)");
            int choice = scanner.nextInt();

            if (choice != 1) {
                keepPlaying = false;
                System.out.println("\nQuitting......");
                System.out.println("End Result:");
                System.out.println(player1.getFullName() + " Won: " + player1.getRoundsWon());
                System.out.println(player2.getFullName() + " Won: " + player2.getRoundsWon());

            }
        }

    }





    /*
    public  void throwingDice(){
        System.out.println("\nIts " + player1.getFullName() + " VS " + player2.getFullName());


        // Här gör vi en loop så att spelet kan hantera andra svar än 1 och därmed inte kraschar.
        int choice;
        while(true){
            System.out.println("Press 1 to continue and throw the dice for each player!");

            //  Kollar om choice = 1, om ja, spelar vi spelet
            if(scanner.hasNextInt()){
                choice = scanner.nextInt();
                // scanner.nextLine();

                if(choice == 1){
                    playRound(player1, player2);
                    break;  // Här har vi fått ett korrekt val och kan därmed lämna loopen
                } else{  // Skrivar man nån annan siffra än 1 hanteras det här
                    System.out.println("You have to press 1 to continue! Try again.");
                }
            } else{ // Skriver man till exempel bokstäver hanteras även det
                System.out.println("Invalid input! Please enter a number");

            }
        }
    }
    */


        /* Denna metoden använder roll metoden för att ge ett random värde till två fält per person.
         * Sen skriver vi ut vad tärningen landar på och plussar värdena av tärningskasten till en total.
         * */
        public void playRound (Player player1, Player player2){

            // roll 1 och roll 2 representerar de 2 kasten för spelare nummer 1, 3 respektive 4 för spelare nummer 2.
            int roll1 = diceRoll.roll();
            int roll2 = diceRoll.roll();
            // Addera båda tärningskasten för spelare 1
            int total1 = roll1 + roll2;

            int roll3 = diceRoll.roll();
            int roll4 = diceRoll.roll();
            // Addera båda tärningskasten för spelare 2
            int total2 = roll3 + roll4;

            // Printa ut individuella tärningskasten och sen visa totalen för båda spelare
            System.out.println();
            System.out.println(player1.getFullName() + " kastar: " + roll1 + " och " + roll2 + " (Totalt: " + total1 + ")");
            System.out.println(player2.getFullName() + " kastar: " + roll3 + " och " + roll4 + " (Totalt: " + total2 + ")");

            // lägg till totalen till score
            player1.addToScore(total1);
            player2.addToScore(total2);

            if (total1 > total2) {
                player1.incrementRoundsWon();
                System.out.println(player1.getFullName() + " Vinner matchen!");
            } else if (total1 < total2) {
                player2.incrementRoundsWon();
                System.out.println(player2.getFullName() + " Vinner matchen!");
            } else {
                System.out.println("\nMatchen slutar lika!");
            }

        }


}