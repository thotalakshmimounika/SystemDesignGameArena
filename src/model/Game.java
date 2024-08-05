package model;

import constant.GameStatus;
import exception.InvalidDiceException;
import service.WinningStrategy.WinningStrategy;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Player> players;
    private Dice attackingDice;
    private Dice defendingDice;
    private WinningStrategy winningStrategy;
    private GameStatus gameStatus;
    private Game(List<Player> players, Dice attackingDice, Dice defendingDice, WinningStrategy winningStrategy) {
        this.players = players;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.attackingDice = attackingDice;
        this.defendingDice = defendingDice;
        this.winningStrategy = winningStrategy;
    }

    public static class Builder {
        private List<Player> players;
        private Dice attackingDice;
        private Dice defendingDice;
        private WinningStrategy winningStrategy;

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setAttackingDice(Dice attackingDice) {
            this.attackingDice = attackingDice;
            return this;
        }

        public Builder setDefendingDice(Dice defendingDice) {
            this.defendingDice = defendingDice;
            return this;
        }

        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        private void validate() {
            if (players == null || players.size() != 2) {
                throw new IllegalArgumentException("Invalid number of players. Game requires exactly 2 players.");
            }
        }

        public Game build() {
            validate();
            return new Game(players, attackingDice, defendingDice, winningStrategy);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Dice getAttackingDice() {
        return attackingDice;
    }

    public void setAttackingDice(Dice attackingDice) {
        this.attackingDice = attackingDice;
    }

    public Dice getDefendingDice() {
        return defendingDice;
    }

    public void setDefendingDice(Dice defendingDice) {
        this.defendingDice = defendingDice;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
    public void startGame() {
        System.out.println("--- Game Started ---");
        Scanner scanner = new Scanner(System.in);
        int turnCount = 0;

        while (getGameStatus() == GameStatus.IN_PROGRESS  ) {
            turnCount++;

            Player attacker = getPlayers().get(0);
            Player defender = getPlayers().get(1);

            // Roll attacking and defending dice
            int attackRoll = rollDice(scanner, attacker, getAttackingDice());
            int defenseRoll = rollDice(scanner, defender, getDefendingDice());
            // Calculate damage and apply to defender
            int attackDamage = attacker.calculateAttack(attackRoll);
            int defensePoints = defender.calculateDefense(defenseRoll);
            int damageDealt = Math.max(0, attackDamage - defensePoints);
            defender.receiveDamage(damageDealt);

            // Display player details after each turn
            displayPlayerDetails(attacker, defender);


            // Check for game end condition
            if (!defender.isAlive()) {
                setGameStatus(GameStatus.FINISHED);
                System.out.println(attacker.getName() + " wins the game in " + turnCount + " turns!");
            }

            // Swap attacker and defender for next turn
            Player temp = attacker;

            getPlayers().set(0, defender);
            getPlayers().set(1, temp);
        }
    }
    private int rollDice(Scanner scanner, Player player, Dice dice) {
        int rollValue;
        do {
            try {
                System.out.println(player.getName() + ", enter " + " dice roll (1-" + dice.getSides() + "): ");
                rollValue = scanner.nextInt();
                if (!dice.isValidRoll(rollValue)) {
                    throw new InvalidDiceException("Invalid roll value. Roll value must be between 1 and " + dice.getSides());
                }
            } catch (InputMismatchException | InvalidDiceException e) {
                System.out.println(e.getMessage());
                scanner.nextLine(); // Clear the input buffer
                continue;
            }
            break;
        } while (true);
        return rollValue;
    }
    private void displayPlayerDetails(Player attacker, Player defender) {
        System.out.println("Player A: " + attacker.getName() + " - Health: " + attacker.getHealth());
        System.out.println("Player B: " + defender.getName() + " - Health: " + defender.getHealth());
        System.out.println();
    }

}
