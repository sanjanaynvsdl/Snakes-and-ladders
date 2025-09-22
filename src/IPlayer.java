package src;

public interface IPlayer {
    String getName();
    int getPosition();
    void setPosition(int position);
    DiceRollResult takeTurn();
}