package src;

import java.util.List;

public class Game {
    private Board board;
    private List<IPlayer> players;
    private int currentPlayerIndex;
    private boolean gameEnded;
    private IPlayer winner;
    private IWinningStrategy winningStrategy;
    private IMakeMoveStrategy makeMoveStrategy;

    public Game(Board board, List<IPlayer> players, IWinningStrategy winningStrategy, IMakeMoveStrategy makeMoveStrategy) {
        this.board = board;
        this.players = players;
        this.currentPlayerIndex = 0;
        this.gameEnded = false;
        this.winner = null;
        this.winningStrategy = winningStrategy;
        this.makeMoveStrategy = makeMoveStrategy;

        for (IPlayer player : players) {
            board.addPlayer(player);
        }
    }

    public void startGame() {
        System.out.println("Starting Snake and Ladders game with " + players.size() + " players!");
        board.printBoard();

        while (!gameEnded) {
            IPlayer currentPlayer = getCurrentPlayer();
            System.out.println("\n" + currentPlayer.getName() + "'s turn (Position: " + currentPlayer.getPosition() + ")");

            DiceRollResult diceResult = currentPlayer.takeTurn();
            System.out.println(currentPlayer.getName() + " rolled: " + diceResult);

            int newPosition = makeMoveStrategy.makeMove(currentPlayer, diceResult, board);
            System.out.println(currentPlayer.getName() + " moved to position: " + newPosition);

            if (winningStrategy.checkWinner(currentPlayer, board)) {
                winner = currentPlayer;
                gameEnded = true;
                System.out.println("🎉 " + currentPlayer.getName() + " wins the game!");
                break;
            }

            if (!diceResult.hasSix()) {
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            } else {
                System.out.println(currentPlayer.getName() + " gets another turn for rolling a 6!");
            }
        }
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public IPlayer getWinner() {
        return winner;
    }

    public IPlayer getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public List<IPlayer> getPlayers() {
        return players;
    }
}