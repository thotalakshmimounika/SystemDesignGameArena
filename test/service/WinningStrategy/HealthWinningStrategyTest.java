package service.WinningStrategy;

import model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HealthWinningStrategyTest {

    private HealthWinningStrategy winningStrategy;

    @BeforeEach
    void setUp() {
        winningStrategy = new HealthWinningStrategy();
    }

    @Test
    void testCheckWinner_AttackerWins() {
        // Attacker's health drops to 0, so attacker should win
        Player attacker = new Player("Attacker", 0, 10, 20);
        Player defender = new Player("Defender", 10, 10, 20);

        Player winner = winningStrategy.checkWinner(defender, attacker);

        assertEquals(attacker, winner);
    }

    @Test
    void testCheckWinner_DefenderWins() {
        // Defender's health drops to 0, so defender should win
        Player attacker = new Player("Attacker", 10, 10, 20);
        Player defender = new Player("Defender", 0, 10, 20);

        Player winner = winningStrategy.checkWinner(defender, attacker);

        assertEquals(defender, winner);
    }

    @Test
    void testCheckWinner_EqualHealth() {
        // Both players have equal health, so no winner should be determined
        Player attacker = new Player("Attacker", 10, 10, 20);
        Player defender = new Player("Defender", 10, 10, 20);

        Player winner = winningStrategy.checkWinner(defender, attacker);

        assertNull(winner);
    }

    @Test
    void testCheckWinner_DefenderHigherHealth() {
        // Defender has higher health, so defender should win
        Player attacker = new Player("Attacker", 10, 10, 20);
        Player defender = new Player("Defender", 20, 10, 20);

        Player winner = winningStrategy.checkWinner(defender, attacker);

        assertEquals(defender, winner);
    }

    @Test
    void testCheckWinner_AttackerHigherHealth() {
        // Attacker has higher health, so attacker should win
        Player attacker = new Player("Attacker", 20, 10, 20);
        Player defender = new Player("Defender", 10, 10, 20);

        Player winner = winningStrategy.checkWinner(defender, attacker);

        assertEquals(attacker, winner);
    }
}
