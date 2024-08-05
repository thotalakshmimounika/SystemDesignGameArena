package controller;

import constant.GameStatus;
import exception.InvalidDiceException;
import model.Dice;
import model.Game;
import model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.WinningStrategy.WinningStrategy;
import controller.GameController;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameControllerTest {

    private GameController gameController;
    private List<Player> players;
    private Dice attackingDice;
    private Dice defendingDice;
    private WinningStrategy winningStrategy;

    @BeforeEach
    void setUp() {
        gameController = new GameController();
        players = new ArrayList<>();
        attackingDice = new Dice(6);
        defendingDice = new Dice(6);
        winningStrategy = new WinningStrategy() {
            @Override
            public Player checkWinner(Player currentDefender, Player currentAttacker) {
                return null;
            }
        };
    }

    @Test
    void testCreateGame() {
        // Create players
        Player playerA = new Player("Player A", 100, 10, 20);
        Player playerB = new Player("Player B", 100, 10, 20);
        players.add(playerA);
        players.add(playerB);

        // Create game
        Game game = gameController.createGame(players, attackingDice, defendingDice, winningStrategy);

        // Assert game creation
        assertNotNull(game);
        assertEquals(players, game.getPlayers());
        assertEquals(attackingDice, game.getAttackingDice());
        assertEquals(defendingDice, game.getDefendingDice());
        assertEquals(winningStrategy, game.getWinningStrategy());
        assertEquals(GameStatus.IN_PROGRESS, game.getGameStatus());
    }

    @Test
    void testStartGame() {
        // Create players
        Player playerA = new Player("Player A", 100, 10, 20);
        Player playerB = new Player("Player B", 100, 10, 20);
        players.add(playerA);
        players.add(playerB);

        // Create game
        Game game = gameController.createGame(players, attackingDice, defendingDice, winningStrategy);

        // Start the game
        gameController.startGame(game);

        // Assert game status after starting
        assertTrue(game.getGameStatus() == GameStatus.FINISHED || game.getGameStatus() == GameStatus.IN_PROGRESS);
    }
}
