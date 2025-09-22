package src;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(10);

        List<IPlayer> players = new ArrayList<>();
        players.add(PlayerFactory.createHumanPlayer("XYZ"));
        players.add(PlayerFactory.createBotPlayer("ABC"));

        IWinningStrategy winningStrategy = new ExactEndWinningStrategy();
        IMakeMoveStrategy makeMoveStrategy = new BasicMakeMoveStrategy();

        Game gameEngine = new Game(board, players, winningStrategy, makeMoveStrategy);
        gameEngine.startGame();
    }
}
