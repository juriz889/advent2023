package day10;

public class GameParser {
    public Game parse(String input, char startingPoint) {
        String[] split = input.split("\\n");
        Tile[][] tiles = new Tile[split.length][split[0].length()];
        int y = 0;
        for (String s : split) {
            char[] charArray = s.toCharArray();
            for (int x = 0; x < charArray.length; x++) {
                tiles[y][x] = getByCharacter(charArray[x], startingPoint);
            }
            y++;
        }
        return new Game(tiles);
    }

    private static Tile getByCharacter(char currentChar, char startingPoint) {
        if (currentChar == '|') {
            return new VerticalPipe();
        } else if (currentChar == '-') {
            return new HorizontalPipe();
        } else if (currentChar == 'L') {
            return new LPipe();
        } else if (currentChar == 'F') {
            return new FPipe();
        } else if (currentChar == '7') {
            return new SevenPipe();
        } else if (currentChar == 'J') {
            return new JPipe();
        } else if (currentChar == 'S') {
            return new StartingPoint(getByCharacter(startingPoint, startingPoint));
        } else if (currentChar == '.') {
            return new Dot();
        } else {
            throw new IllegalArgumentException("Unknown tile: " + currentChar);
        }
    }
}
