package service.WinningStrategy;

import model.Player;

public class HealthWinningStrategy implements WinningStrategy {

    @Override
    public Player checkWinner(Player currentDefender, Player currentAttacker) {
        if (currentDefender.getHealth() <= 0) {
            return currentAttacker; // Attacker wins if defender's health reaches zero
        } else if (currentAttacker.getHealth() <= 0) {
            return currentDefender; // Defender wins if attacker's health reaches zero
        } else {
            // Neither player has reached zero health, compare their health points
            if (currentDefender.getHealth() > currentAttacker.getHealth()) {
                return currentDefender;
            } else if (currentAttacker.getHealth() > currentDefender.getHealth()) {
                return currentAttacker;
            } else {
                return null; // Return null if both players have equal health
            }
        }
    }
}
