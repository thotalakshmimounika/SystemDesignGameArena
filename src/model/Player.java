package model;

public class Player {

    private String name;
    private int health;     // Health attribute of the player
    private int strength;   // Strength attribute of the player
    private int attack;     // Attack attribute of the player

    public Player(String name, int health, int strength, int attack) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
    public int calculateAttack(int attackRoll) {
        return attack * attackRoll;
    }
    public int calculateDefense(int defenseRoll) {
        return strength * defenseRoll;
    }
    public void receiveDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }
    public boolean isAlive() {

        return this.health > 0;
    }

}
