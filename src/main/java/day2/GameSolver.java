package day2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameSolver {
    private final Pattern GAME = Pattern.compile("Game (\\d+):");
    private final Config config;

    public GameSolver(Config config) {
        this.config = config;
    }

    public int getSolvedGame(String input) {
        String[] split = input.split("\n");
        Game game = new Game(config);
        int result = 0;
        for (String s : split) {
            Matcher matcher = GAME.matcher(s);
            if (matcher.find()) {
                int gameNumber = Integer.parseInt(matcher.group(1));
                String rest = s.substring(matcher.end());
                boolean possible = game.isPossible(rest);
                if (possible) {
                    result += gameNumber;
                }
            }

        }
        return result;
    }

    public int getSolvedGamePart2(String input) {
        String[] split = input.split("\n");
        Game game = new Game(config);
        int result = 0;
        for (String s : split) {
            Matcher matcher = GAME.matcher(s);
            if (matcher.find()) {
                int gameNumber = Integer.parseInt(matcher.group(1));
                String rest = s.substring(matcher.end());
                result += game.getPower(rest);
            }

        }
        return result;
    }
}
