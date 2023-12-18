package day16;

public class TileBoard {
    private final Tile[][] tiles;

    public TileBoard(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}
