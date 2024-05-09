import java.util.Scanner;

public class SimonSays {
    public static void main(String[] args) {
        NewGame.clearScreen();
        System.out.println("Welcome to Matthew's Simon Says Text Game");
        System.out.println("Rules :");
        System.out.println("i. Player with the highest score wins");
        System.out.println("ii. Don't begin to repeat the Simon until prompted");

        // launches game
        launchGame();
    }

    // Method for beginning multiplayer game
    public static void multiplayer(Scanner b) {
        System.out.println("Enter number of players: ");
        int numOfPlayers = b.nextInt();
        NewGame[] games = new NewGame[numOfPlayers];
    
        // Initialize games for each player
        for (int i = 0; i < numOfPlayers; i++) {
            games[i] = new NewGame();
        }
    
        // Play the game for each player
        b.nextLine(); // newline is consumed by the nextLine() call
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Player " + (i + 1) + ":");
            System.out.println("Press Enter to start game: ");
            b.nextLine(); // Wait for Enter press
            games[i].startGame();
        }
    
        // Compare scores and determine winner
        int maxScore = -1; // must be less than 0
        int winnerIndex = 0;
        int[] scores = new int[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++) {
            scores[i] = games[i].getScore();
            System.out.println("Player " + (i + 1) + " score: " + scores[i]);
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                winnerIndex = i;
            }
        }
    
        // Check for a tie
        boolean tie = false;
        for (int i = 0; i < numOfPlayers; i++) {
            if (scores[i] == maxScore && i != winnerIndex) {
                tie = true;
                break;
            }
        }
    
        // Output winner or tie
        if (tie) {
            System.out.println("It's a tie!");
        } else {
            System.out.println("Player " + (winnerIndex + 1) + " wins!");
        }
    }

    // Method for beginning singleplayer game
    public static void singleplayer() {
        NewGame onePlayer = new NewGame();
        onePlayer.startGame();
    }

    // Method for selecting game type
    public static void launchGame() {
        Scanner scanner = new Scanner(System.in);
        int gameType = 0;
        do {
            System.out.println("Enter: '1' for SINGLEPLAYER");
            System.out.println("Enter: '2' for MULTIPLAYER");
            gameType = scanner.nextInt();
            if (gameType == 1 || gameType == 2) {
                break;
            } else {
                System.out.println("Invalid input");
            }
        } while (gameType != 1 && gameType != 2);

        if (gameType == 2) {
            multiplayer(scanner);
        }
        if (gameType == 1) {
            singleplayer();
        }
    }
}