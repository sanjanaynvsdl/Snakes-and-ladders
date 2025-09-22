package src;


public class BotPlayer implements IPlayer {
    private String name;
    private int position;

    public BotPlayer(String name) {
        this.name = name;
        this.position = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public DiceRollResult takeTurn() {
        DiceSet dice = DiceSet.getInstance();
        return dice.roll();
    }
}