package day10;

import day3.Coordinate;

import java.util.Set;

public class Dot implements Tile {
    @Override
    public Coordinate next(Coordinate previous, Coordinate current) {
        return null;
    }

    @Override
    public DirectionWithCoordinate move(Direction direction, Coordinate current) {
        throw new IllegalArgumentException("Should never reach here");
    }

    @Override
    public Set<Direction> getDirections() {
        throw new IllegalArgumentException("Should never reach here");

    }
    @Override
    public String toString() {
        return ".";
    }
}
