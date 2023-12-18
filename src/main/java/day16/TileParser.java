package day16;

public class TileParser {
    public TileBoard parse(String input) {
        String[] split = input.split("\\n");
        Tile[][] tiles = new Tile[split.length][split[0].length()];
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            char[] charArray = s.toCharArray();
            for (int i1 = 0; i1 < charArray.length; i1++) {
                char c = charArray[i1];
                if (c == '.') {
                    tiles[i][i1] = new EmptySpace();
                } else if (c == '\\') {
                    tiles[i][i1] = new BackSlashSpace();
                } else if (c == '/') {
                    tiles[i][i1] = new SlashSpace();
                } else if (c == '-') {
                    tiles[i][i1] = new HorizontalSpace();
                } else if (c == '|') {
                    tiles[i][i1] = new VerticalSpace();
                } else {
                    throw new IllegalStateException("Unknown character: " + c);

                }
            }
        }
        return new TileBoard(tiles);
    }
}
