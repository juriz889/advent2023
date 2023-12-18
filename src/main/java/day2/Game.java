package day2;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    private final Config config;
    private final Pattern DIGIT = Pattern.compile("(\\d+) (\\w+)");

    public Game(Config config) {
        this.config = config;
    }

    public boolean isPossible(String s) {
        String[] setsPlayed = s.split(";");
        Map<Color, Integer> colorVsNumber = new HashMap<>();
        for (String set : setsPlayed) {
            String[] playedCubes = set.split(",");
            for (String playedCube : playedCubes) {
                Matcher matcher = DIGIT.matcher(playedCube);
                if (matcher.find()) {
                    Integer i = Integer.valueOf(matcher.group(1));
                    String color = matcher.group(2);
                    Color colorEnum = Color.valueOf(color.toUpperCase());
                    int config1 = config.getConfig(colorEnum);
                    if (config1 < i) {
                        return false;
                    }
                    colorVsNumber.putIfAbsent(colorEnum, 0);
                    colorVsNumber.put(colorEnum, colorVsNumber.get(colorEnum) + i);
                }
            }
        }
        return true;
    }

    public int getPower(String s) {
        String[] setsPlayed = s.split(";");
        Map<Color, Integer> colorVsNumber = new HashMap<>();
        for (String set : setsPlayed) {
            String[] playedCubes = set.split(",");
            for (String playedCube : playedCubes) {
                Matcher matcher = DIGIT.matcher(playedCube);
                if (matcher.find()) {
                    Integer i = Integer.valueOf(matcher.group(1));
                    String color = matcher.group(2);
                    Color colorEnum = Color.valueOf(color.toUpperCase());
                    colorVsNumber.putIfAbsent(colorEnum, 0);
                    if (i > colorVsNumber.get(colorEnum)) {
                        colorVsNumber.put(colorEnum, i);
                    }
                }
            }
        }
        System.out.println("colorVsNumber = " + colorVsNumber);
        return colorVsNumber.values().stream().reduce(1, (a, b) -> a * b);
    }
}
