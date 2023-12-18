package day3;

import java.util.Arrays;

public class GameParser {

    public char[][] parse(String input) {
        String[] lines = input.split("\n");
        char[][] result = new char[lines.length][lines[0].length()];
        for (int i = 0; i < lines.length; i++) {
            result[i] = lines[i].toCharArray();
        }
        System.out.println(Arrays.deepToString(result));
        return result;
    }
}
