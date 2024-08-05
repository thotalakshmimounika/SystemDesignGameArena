import controller.GameController;
import model.Dice;
import model.Game;
import model.Player;
import service.WinningStrategy.HealthWinningStrategy;
import service.WinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);

        // Create players
        Player playerA = createPlayer(scanner, "A");
        Player playerB = createPlayer(scanner, "B");

        // Create a list of players and add as per the health condition
        List<Player> players = new ArrayList<>();
        if(playerA.getHealth()<=playerB.getHealth()){
            players.add(playerA);
            players.add(playerB);
        }
        else{
            players.add(playerB);
            players.add(playerA);
        }
        // Create game dice
        Dice attackingDice = new Dice(6);
        Dice defendingDice = new Dice(6);
        // Create a winning strategy
        WinningStrategy winningStrategy = new HealthWinningStrategy();

        // Create the game
        Game game = gameController.createGame(players, attackingDice, defendingDice, winningStrategy);

        // Start the game
        gameController.startGame(game);
    }
    private static Player createPlayer(Scanner scanner, String suffix) {
        System.out.println("Enter details for Player " + suffix );

        String name = getValidName(scanner, "Please enter the Player name: ");
        int health = getIntInput(scanner, "Please enter the Player Health points: ");
        int strength = getIntInput(scanner, "Please enter the Player Strength points: ");
        int attack = getIntInput(scanner, "Please enter the Player attack points: ");
        return new Player(name, health, strength, attack);
    }
    private static String getValidName(Scanner scanner, String prompt) {
        String name="";
        boolean valid = false;
        while (!valid) {
            System.out.println(prompt);
            name = scanner.nextLine();
            if (name.matches("[a-zA-Z ]+")) {
                valid = true;
            } else {
                System.out.println("Invalid name. The name should only contain letters and spaces.");
            }
        }
        return name.trim();
    }
    private static int getIntInput(Scanner scanner, String prompt) {
        int input = 0;
        boolean valid = false;
        while (!valid) {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return input;
    }
}