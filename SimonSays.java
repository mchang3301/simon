import java.util.Scanner;

public class SimonSays {
    public static void main(String[] args) {
        NewGame.clearScreen();
        System.out.println("Welcome to Matthew's Simon Says Text Game");
        System.out.println("Rules :");
        System.out.println("i. player with the highest score wins");
        System.out.println("ii. Don't begin to repeat the sequence until prompted");

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
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Player " + (i + 1) + ":");
            games[i].startGame();
        }

        // Compare scores and determine winner
        int maxScore = -6;
        int winnerIndex = -1;
        for (int i = 0; i < numOfPlayers; i++) {
            int score = games[i].getScore();
            System.out.println("Player " + (i + 1) + " score: " + score);
            if (score > maxScore) {
                maxScore = score;
                winnerIndex = i;
            }
        }

        // Output winner
        if (winnerIndex != -1) {
            System.out.println("Player " + (winnerIndex + 1) + " wins!");
        } else {
            System.out.println("It's a tie!");
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
            System.out.println("Enter: '1' for singleplayer");
            System.out.println("Enter: '2' for multiplayer");
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