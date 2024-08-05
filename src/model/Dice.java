package model;

public class Dice {
    private int sides;

    public Dice(int sides) {
        this.sides = sides;
    }

    public int getSides() {
        return sides;
    }
    public boolean isValidRoll(int rollValue) {

        return rollValue >= 1 && rollValue <= sides;
    }
}
