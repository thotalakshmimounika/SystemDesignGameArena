package model;

import model.Dice;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiceTest {

    @Test
    void testGameDiceConstructor() {
        Dice dice = new Dice(6);
        assertNotNull(dice, "GameDice object should not be null.");
    }

    @Test
    void testGetSides() {
        Dice dice = new Dice(6);
        assertEquals(6, dice.getSides(), "getSides should return the correct number of sides.");
    }

    @Test
    void testIsValidRollWithinRange() {
        Dice dice = new Dice(6);
        assertTrue(dice.isValidRoll(1), "isValidRoll should return true for the lowest valid roll.");
        assertTrue(dice.isValidRoll(6), "isValidRoll should return true for the highest valid roll.");
        assertTrue(dice.isValidRoll(3), "isValidRoll should return true for a roll within the valid range.");
    }

    @Test
    void testIsValidRollBelowRange() {
        Dice dice = new Dice(6);
        assertFalse(dice.isValidRoll(0), "isValidRoll should return false for a roll below the valid range.");
    }

    @Test
    void testIsValidRollAboveRange() {
        Dice dice = new Dice(6);
        assertFalse(dice.isValidRoll(7), "isValidRoll should return false for a roll above the valid range.");
    }
}
