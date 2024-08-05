package service.WinningStrategy;

import model.Player;

public interface WinningStrategy {
    Player checkWinner(Player currentDefender, Player currentAttacker);
}
