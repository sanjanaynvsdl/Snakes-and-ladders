package src;


public class BasicMakeMoveStrategy implements IMakeMoveStrategy {
    @Override
    public int makeMove(IPlayer player, DiceRollResult diceResult, Board board) {
        return board.movePlayer(player, diceResult);
    }
}