package src;

import java.util.List;

public class DiceRollResult {
    private List<Integer> individualRolls;
    private int totalSum;
    private boolean hasSix;

    public DiceRollResult(List<Integer> individualRolls, int totalSum, boolean hasSix) {
        this.individualRolls = individualRolls;
        this.totalSum = totalSum;
        this.hasSix = hasSix;
    }

    public List<Integer> getIndividualRolls() {
        return individualRolls;
    }

    public int getTotalSum() {
        return totalSum;
    }

    public boolean hasSix() {
        return hasSix;
    }

    @Override
    public String toString() {
        return "DiceRollResult{rolls=" + individualRolls + ", sum=" + totalSum + ", hasSix=" + hasSix + "}";
    }
}