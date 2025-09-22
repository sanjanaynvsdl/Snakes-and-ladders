package src;

import java.util.*;

public class Board {
    private int size;
    private int boardDimension;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private Map<Integer, Integer> playerPositions;
    private Set<Integer> occupiedCells;

    public Board(int boardDimension) {
        this.boardDimension = boardDimension;
        this.size = boardDimension * boardDimension;
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
        this.playerPositions = new HashMap<>();
        this.occupiedCells = new HashSet<>();
        initializeBoard();
    }

    private void initializeBoard() {
        snakes.add(new Snake(16, 6));
        snakes.add(new Snake(47, 26));
        snakes.add(new Snake(49, 11));
        snakes.add(new Snake(56, 53));
        snakes.add(new Snake(62, 19));
        snakes.add(new Snake(64, 60));
        snakes.add(new Snake(87, 24));
        snakes.add(new Snake(93, 73));
        snakes.add(new Snake(95, 75));
        snakes.add(new Snake(98, 78));

        ladders.add(new Ladder(1, 38));
        ladders.add(new Ladder(4, 14));
        ladders.add(new Ladder(9, 31));
        ladders.add(new Ladder(21, 42));
        ladders.add(new Ladder(28, 84));
        ladders.add(new Ladder(36, 44));
        ladders.add(new Ladder(51, 67));
        ladders.add(new Ladder(71, 91));
        ladders.add(new Ladder(80, 100));
    }

    public int movePlayer(IPlayer player, DiceRollResult diceResult) {
        int currentPosition = player.getPosition();
        int newPosition = currentPosition + diceResult.getTotalSum();

        if (newPosition > size) {
            return currentPosition;
        }

        for (Snake snake : snakes) {
            if (snake.getStart() == newPosition) {
                newPosition = snake.getEnd();
                break;
            }
        }

        for (Ladder ladder : ladders) {
            if (ladder.getStart() == newPosition) {
                newPosition = ladder.getEnd();
                break;
            }
        }

        player.setPosition(newPosition);
        return newPosition;
    }

    public void printBoard() {
        System.out.println("Board size: " + size);
        System.out.println("Snakes: ");
        for (Snake snake : snakes) {
            System.out.println("  " + snake.getStart() + " -> " + snake.getEnd());
        }
        System.out.println("Ladders: ");
        for (Ladder ladder : ladders) {
            System.out.println("  " + ladder.getStart() + " -> " + ladder.getEnd());
        }
    }

    public boolean hasWinner(IPlayer player) {
        return player.getPosition() == size;
    }

    public void addPlayer(IPlayer player) {
        playerPositions.put(player.hashCode(), player.getPosition());
    }

    public void removePlayer(IPlayer player) {
        playerPositions.remove(player.hashCode());
    }
}