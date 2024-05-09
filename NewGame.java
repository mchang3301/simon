import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class NewGame {
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);
    private int score = 0;
    
    //creates string array of actions
    private String[] generateActions(int length) {
        String[] sequence = new String[length];
        String[] actions = { "jump", "clap", "spin", "wiggle", "dance", "hop", "march", "snap", "stand", "skip", "flap", "shake", "wink", "crouch", "run"};
        for (int i = 0; i < length; i++) {
            sequence[i] = actions[random.nextInt(actions.length)];
        }
        return sequence;

    }

    //pauses execution for a set amount of time
    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //clears console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //displays the sequence created in the generateActions method
    private static void displayActions(String[] sequence) {
        sleep(2);
        clearScreen();
        System.out.println("Simon says type: ");
        sleep(1);
        clearScreen();
        for (int i = 0; i < sequence.length; i++) {
            System.out.println(sequence[i]);
            sleep(2);
            clearScreen();
        }
        clearScreen();
    }

    // Collects the repitition of the typed actions from the user. Stores and returns in an array.
    private String[] getUserActions(int length) {
        System.out.println("Your turn, repeat the sequence:");
        String[] userSequence = new String[length];
        for (int i = 0; i < length; i++) {
            userSequence[i] = scanner.next().toLowerCase();
        }
        return userSequence;
    }

    // Checks the two arrays the actions generated and the actions inputted by user.
    private boolean checkActions(String[] userSequence, String[] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            if (!userSequence[i].equals(sequence[i])) {
                return false;
            }
        }
        return true;
    }

    // method begins the game
    public void startGame() {
        score = 0;
        while (true) {
            String[] sequence = generateActions(score + 1);
            displayActions(sequence);
            sleep(1);
            String[] userSequence = getUserActions(sequence.length);
            if (checkActions(userSequence, sequence)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! Game Over. Your score: " + score);
                break;
            }
        }
    }

    //returns the score of the game
    public int getScore() {
        return score;
    }

}
