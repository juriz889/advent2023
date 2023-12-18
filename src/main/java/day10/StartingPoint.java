package day10;

import day3.Coordinate;

import java.util.Set;

public class StartingPoint implements Tile {
    private final Tile realTile;

    public StartingPoint(Tile realTile) {
        this.realTile = realTile;
    }

    @Override
    public Coordinate next(Coordinate previous, Coordinate current) {
        return null;
    }

    @Override
    public DirectionWithCoordinate move(Direction direction, Coordinate current) {
        return realTile.move(direction, current);
    }

    @Override
    public Set<Direction> getDirections() {
        return realTile.getDirections();
    }
}
