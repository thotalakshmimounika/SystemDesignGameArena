package model;

import model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;
    @BeforeEach
    void setUp() {
        // Initialize a Player object before each test with a consistent state
        player = new Player("Test Player", 100, 10, 20);
    }

    @Test
    void testPlayerConstructorAndGetters() {
        assertEquals("Test Player", player.getName());
        assertEquals(100, player.getHealth());
        assertEquals(10, player.getStrength());
        assertEquals(20, player.getAttack());
    }

    @Test
    void testSetName() {
        player.setName("New Name");
        assertEquals("New Name", player.getName());
    }

    @Test
    void testSetHealth() {
        player.setHealth(80);
        assertEquals(80, player.getHealth());
    }

    @Test
    void testSetStrength() {
        player.setStrength(15);
        assertEquals(15, player.getStrength());
    }

    @Test
    void testSetAttack() {
        player.setAttack(25);
        assertEquals(25, player.getAttack());
    }

    @Test
    void testCalculateAttack() {
        assertEquals(40, player.calculateAttack(2), "The attack calculation should multiply the attack value by the attack roll.");
    }

    @Test
    void testCalculateDefense() {
        assertEquals(30, player.calculateDefense(3), "The defense calculation should multiply the strength value by the defense roll.");
    }

    @Test
    void testReceiveDamage() {
        player.receiveDamage(10);
        assertEquals(90, player.getHealth(), "Health should decrease by the damage amount.");

        player.receiveDamage(100);
        assertEquals(0, player.getHealth(), "Health should not go below 0.");
    }

    @Test
    void testIsAlive() {
        assertTrue(player.isAlive(), "Player should be alive when health is above 0.");

        player.receiveDamage(100);
        assertFalse(player.isAlive(), "Player should be dead (not alive) when health is 0 or below.");
    }
}
