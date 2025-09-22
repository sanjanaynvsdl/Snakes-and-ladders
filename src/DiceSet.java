package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceSet {
    private static DiceSet instance;
    private Random random;
    private int numberOfDice;

    private DiceSet() {
        this.random = new Random();
        this.numberOfDice = 1;
    }

    public static DiceSet getInstance() {
        if (instance == null) {
            instance = new DiceSet();
        }
        return instance;
    }

    public void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int getNumberOfDice() {
        return numberOfDice;
    }

    public DiceRollResult roll() {
        List<Integer> rolls = new ArrayList<>();
        int totalSum = 0;
        boolean hasSix = false;

        for (int i = 0; i < numberOfDice; i++) {
            int roll = random.nextInt(6) + 1;
            rolls.add(roll);
            totalSum += roll;
            if (roll == 6) {
                hasSix = true;
            }
        }

        return new DiceRollResult(rolls, totalSum, hasSix);
    }
}