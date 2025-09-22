package src;

public class PlayerFactory {
    public static IPlayer createPlayer(String type, String name) {
        if (type.equalsIgnoreCase("HUMAN")) {
            return new HumanPlayer(name);
        } else if (type.equalsIgnoreCase("BOT")) {
            return new BotPlayer(name);
        }
        throw new IllegalArgumentException("Unknown player type: " + type);
    }

    public static HumanPlayer createHumanPlayer(String name) {
        return new HumanPlayer(name);
    }

    public static BotPlayer createBotPlayer(String name) {
        return new BotPlayer(name);
    }
}