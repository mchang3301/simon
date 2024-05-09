
/**
 * Multiplayer SimonSays/memorization terminal game.
 * 
 * @author (Matthew Chang) 
 * @version (1.0)
 */

import java.util.Scanner;

public class SimonSays {
    public static void main(String[] args) {
        NewGame.clearScreen();
        System.out.println("Welcome to Matthew's Simon Says Text Game");
        System.out.println("Rules :");
        System.out.println("i. Player with the highest score wins");
        System.out.println("ii. Don't begin to repeat Simon until prompted");

        // launches game
        launchGame();
    }

    // Method for beginning multiplayer game
    public static void multiplayer(Scanner b) {
        System.out.println("Enter number of players: ");
        int numOfPlayers;

        // checks if user has inputted a integer
        while (true) {
            if (b.hasNextInt()) {
                numOfPlayers = b.nextInt();
                if (numOfPlayers > 0) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a positive integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter a positive integer.");
                b.next(); // Clear the invalid input
            }
        }

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
        playAgain(b);

    }

    // Method for beginning singleplayer game
    public static void singleplayer(Scanner a) {
        NewGame onePlayer = new NewGame();
        onePlayer.startGame();

        playAgain(a);
    }

    // Method for selecting game type
    public static void launchGame() {
        Scanner scanner = new Scanner(System.in);
        int gameType = 0;
        boolean check = true;
        do {
            System.out.println("Enter '1' for SINGLEPLAYER or '2' for MULTIPLAYER");
            if (scanner.hasNextInt()) {
                gameType = scanner.nextInt();
                if (gameType == 1 || gameType == 2) {
                    check = false;
                } else {
                    System.out.println("Invalid input");
                }
            } else {
                System.out.println("Invalid input");
                scanner.next(); // Clear the invalid input
            }
        } while (check);

        if (gameType == 2) {
            multiplayer(scanner);
        }
        if (gameType == 1) {
            singleplayer(scanner);
        }
    }

    // Method will give user the choice to play again or end game
    public static void playAgain(Scanner a) {
        boolean check = true;
        int playAgain = 0;
        do {
            System.out.println("Enter '1' to play again, or '2' to end game");
            if (a.hasNextInt()) {
                playAgain = a.nextInt();
                if (playAgain == 1 || playAgain == 2) {
                    check = false;
                } else {
                    System.out.println("Invalid input");
                }
            } else {
                System.out.println("Invalid input");
                a.next(); // Clear the invalid input
            }
        } while (check);

        if (playAgain == 1) {
            launchGame();
        }
    }

}