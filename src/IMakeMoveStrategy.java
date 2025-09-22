package src;

public interface IMakeMoveStrategy {
    int makeMove(IPlayer player, DiceRollResult diceResult, Board board);
}