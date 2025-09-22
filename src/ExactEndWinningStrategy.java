package src;

public class ExactEndWinningStrategy implements IWinningStrategy {
    @Override
    public boolean checkWinner(IPlayer player, Board board) {
        return board.hasWinner(player);
    }
}