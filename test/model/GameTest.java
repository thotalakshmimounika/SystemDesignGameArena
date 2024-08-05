package model;

import constant.GameStatus;
import service.WinningStrategy.WinningStrategy;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private Player player1, player2;
    private Dice attackingDice, defendingDice;
    private WinningStrategy winningStrategy;
    private Game gameArena;

    @BeforeEach
    void setUp() {
        player1 = new Player("Player 1", 100, 10, 20);
        player2 = new Player("Player 2", 100, 15, 25);
        List<Player> players = Arrays.asList(player1, player2);

        attackingDice = new Dice(6);
        defendingDice = new Dice(6);
        winningStrategy = (currentDefender, currentAttacker) -> null; // Mock strategy with a lambda that does nothing/returns null

        gameArena = new Game.Builder()
                .setPlayers(players)
                .setAttackingDice(attackingDice)
                .setDefendingDice(defendingDice)
                .setWinningStrategy(winningStrategy)
                .build();
    }

    @Test
    void builderSuccessfullyInitializesGameArena() {
        assertNotNull(gameArena.getPlayers());
        assertEquals(2, gameArena.getPlayers().size());
        assertEquals(attackingDice, gameArena.getAttackingDice());
        assertEquals(defendingDice, gameArena.getDefendingDice());
        assertEquals(winningStrategy, gameArena.getWinningStrategy());
        assertEquals(GameStatus.IN_PROGRESS, gameArena.getGameStatus());
    }

    @Test
    void builderThrowsExceptionForInvalidNumberOfPlayers() {
        Player player3 = new Player("Player 3", 100, 20, 30);
        List<Player> invalidPlayers = Arrays.asList(player1, player2, player3);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Game.Builder()
                        .setPlayers(invalidPlayers)
                        .setAttackingDice(attackingDice)
                        .setDefendingDice(defendingDice)
                        .setWinningStrategy(winningStrategy)
                        .build()
        );

        String expectedMessage = "Invalid number of players. Game requires exactly 2 players.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void gameStatusCanBeChanged() {
        gameArena.setGameStatus(GameStatus.FINISHED);
        assertEquals(GameStatus.FINISHED, gameArena.getGameStatus());
    }
}
