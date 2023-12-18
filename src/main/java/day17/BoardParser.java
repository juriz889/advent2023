package day17;

import day16.BackSlashSpace;
import day16.EmptySpace;
import day16.HorizontalSpace;
import day16.SlashSpace;
import day16.Tile;
import day16.VerticalSpace;

public class BoardParser {
    public Board parse(String input) {
        String[] split = input.split("\\n");
        Integer[][] board = new Integer[split.length][split[0].length()];
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            char[] charArray = s.toCharArray();
            for (int i1 = 0; i1 < charArray.length; i1++) {
                char c = charArray[i1];
                Integer i2 = Integer.parseInt(c + "");
                board[i][i1] = i2;
            }
        }
        return new Board(board);
    }
}
