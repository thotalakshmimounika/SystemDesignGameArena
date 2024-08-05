package controller;

import model.Dice;
import model.Game;
import model.Player;
import service.WinningStrategy.WinningStrategy;

import java.util.List;

public class GameController {
    public Game createGame(List<Player> players, Dice attackingDice, Dice defendingDice, WinningStrategy winningStrategy) {
        return new Game.Builder()
                .setPlayers(players)
                .setAttackingDice(attackingDice)
                .setDefendingDice(defendingDice)
                .setWinningStrategy(winningStrategy)
                .build();
    }
    public void startGame(Game game) {
        game.startGame();
    }

}
