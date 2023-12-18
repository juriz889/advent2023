package day4;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameParser {
    private static final Pattern GAME_PATTERN = Pattern.compile("Card\\s+(\\d+):");

    public Game parse(String input) {
        System.out.println("Got input " + input);
        Matcher matcher = GAME_PATTERN.matcher(input);
        if (matcher.find()) {
            int gameNumber = Integer.parseInt(matcher.group(1));
            String rest = input.substring(matcher.end());
            String[] split = rest.split("\\|");
            return new Game(gameNumber, getNumbers(split[0]), getNumbers(split[1]));
        }
        throw new IllegalArgumentException("Invalid input");
    }

    private List<Integer> getNumbers(String input) {
        String[] split = input.split(" ");
        List<Integer> result = new ArrayList<>();
        for (String s : split) {
            if (!s.isEmpty())
                result.add(Integer.parseInt(s.trim()));
        }
        return result;
    }
}
