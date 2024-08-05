# Magical Arena Game

## Overview:
Magical Arena is a console application where two players engage in a battle using dice rolls to attack and defend, until one's health reaches zero. Each player has attributes: health, strength, and attack, all represented by positive integers.

## Getting Started:
### Prerequisites
- An IDE like IntelliJ IDEA, Eclipse, or VS Code with Java support
- Ensure Java Development Kit (JDK) is installed on your system.
- Maven must be installed and properly configured. [Download Maven](https://maven.apache.org/download.cgi)

## Running the Magical Arena Game and Tests

Run the Magical Arena game and execute its accompanying test cases using Maven.

### Running the Game

#### In IDEA

1. Open IntelliJ IDEA.
2. Import the project by selecting the project's `pom.xml` file.
3. Once the project is imported, you can run the `Main` class directly from IntelliJ IDEA.

#### Terminal or Command Prompt

1. **Open Terminal or Command Prompt**: Navigate to the root directory of your project.
2. **Compile the Project**:
    ```shell
    mvn compile
    ```
3. **Run the Game**: Identify the main class where your `public static void main(String[] args)` method resides. Then, execute:
    ```shell
    mvn exec:java -Dexec.mainClass="src.Main"
    ```


# Follow the Prompts:

1. Enter the details for Player A
   a.Name: [Enter Player A's Name]
   b.Health Points: [Enter Player A's Health Points]
   c.Strength Points: [Enter Player A's Strength Points]
   d.Attack Points: [Enter Player A's Attack Points]
2. Enter the details for Player B
   a.Name: [Enter Player B's Name]
   b.Health Points: [Enter Player B's Health Points]
   c.Strength Points: [Enter Player B's Strength Points]
   d.Attack Points: [Enter Player B's Attack Points]
3. At the beginning, the player with the least health points will start the game, acting as the attacking player and rolling the attacking dice.
   [Attacking player, Enter attacking dice roll(1-6)]
4. The other player will act as the defending player and roll the defending dice.
   [Defending player, Enter defending dice roll(1-6)]
5. The current health details of the players will be displayed.
6. From subsequent turns, the attacking and defending players will swap roles and repeat steps 3-5 until one player's health reaches zero.
7. The winner will be declared.


## Running Test Cases

To run the unit tests written for the game:

### In IDEA

1. Navigate to the test folder: `Magical_Area -> model`.
2. Run the test classes mentioned for each model to check.

### In Terminal

1. **Open Terminal or Command Prompt**: Ensure you are in the project's root directory.
2. **Execute Tests**:
    ```shell
    mvn test
    ```
This command runs all tests in the `src/test/java` directory. Maven will automatically find and execute all tests written with JUnit.

## Example Scenario

- **Player A**: 50 Health, 5 Strength, 10 Attack
- **Player B**: 100 Health, 10 Strength, 5 Attack
- Both the attacking and defending dice are 6-sided, with values ranging from 1 to 6.

### Turn 1
- **Player A's Attack**: Rolls a 5 on the attacking die.
- **Player B's Defense**: Rolls a 2 on the defending die.
- **Calculation**: Attack damage = 5 (die roll) * 10 (attack) = 50. Defending strength = 10 (strength) * 2 (die roll) = 20. Player B's health is reduced by 30 to 70.

### Turn 2
- **Player B's Attack**: Rolls a 4 on the attacking die.
- **Player A's Defense**: Rolls a 3 on the defending die.
- **Calculation**: Attack damage = 4 (die roll) * 5 (attack) = 20. Defending strength = 5 (strength) * 3 (die roll) = 15. Player A's health is reduced by 5 to 45.

The duel continues in this manner until the health of one of the players reaches 0, declaring the other player the winner.

